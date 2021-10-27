// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class Bellman_Ford
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
    
        static class Solution
        {
            
            
            static int bellman_ford(int n,int[][] edges){
                int dis[]=new int[n];
                Arrays.fill(dis,Integer.MAX_VALUE);
                
                dis[0]=0;
                for(int x=0;x<n-1;x++){
                    for(int i=0;i<edges.length;i++){
                        int temp[]=edges[i];
                        
                        if(dis[temp[0]] != Integer.MAX_VALUE && dis[temp[0]]+temp[2]<dis[temp[1]]){
                            dis[temp[1]]=dis[temp[0]]+temp[2];
                        }
                    }
                }
                
            
                for(int i=0;i<edges.length;i++){
                    int temp[]=edges[i];
                    
                    if(dis[temp[0]]+temp[2]<dis[temp[1]]){
                        // dis[temp[1]]=dis[temp[0]]+temp[2];
                    
                        return 1;
                    }
                }
                    
                return 0;
            }
            
            public int isNegativeWeightCycle(int n, int[][] edges)
            {
                return bellman_ford(n,edges);
                // return 1;
            }
        }
}

import java.util.*;
public class TSP {

    public static int tsp(int[][] graph,boolean[] vis,int cur,int n,int count,int cost,int ans){
        
        if(count==n && graph[cur][0]>0){
            ans=Math.min(ans,cost+graph[cur][0]);
            return ans;
        }

        for(int i=0;i<n;i++){
            if(!vis[i] && graph[cur][i]>0){
                vis[i]=true;
                ans=tsp(graph, vis, i, n,count+1, cost+graph[cur][i], ans);
                vis[i]=false;
            }
        }

        return ans;
    }
    public static void main(String[] args)
    {
 
        // n is the number of nodes i.e. V
        int n = 4;
 
        int[][] graph = {{0, 10, 15, 20},
                         {10, 0, 35, 25},
                         {15, 35, 0, 30},
                         {20, 25, 30, 0}};
 
        boolean[] v = new boolean[n];
 
        v[0] = true;
        int ans = Integer.MAX_VALUE;
 
        ans = tsp(graph, v, 0, n, 1, 0, ans);

        System.out.println(ans);
    }
}

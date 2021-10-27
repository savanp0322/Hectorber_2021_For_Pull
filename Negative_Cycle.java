
import java.util.*;
public class Negative_Cycle {
    
    // https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int dis[]=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        int hasCycle = 0;
        for(int i=0;i<n;i++)
        {
            hasCycle = 0;
            for(int edge[]:edges)
            {
                int from = edge[0];
                int to = edge[1];
                int w = edge[2];
                if(dis[from]!=Integer.MAX_VALUE && dis[from]+w<dis[to])
                {
                    dis[to] = dis[from]+w;
                    hasCycle=1;
                }
            }
        }
        // Arrays has distances
        return hasCycle;
    }

}
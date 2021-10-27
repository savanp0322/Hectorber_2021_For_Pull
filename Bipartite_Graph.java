import java.util.*;
public class Bipartite_Graph {

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {   
        boolean ans=true;
        int color[]=new int[V];
        
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                color[i]=0;
                while(q.size()>0){
                    int p=q.remove();
                    for(int x:adj.get(p)){
                        if(color[x]==-1){
                            color[x]=color[p]==1?0:1;
                            q.add(x);
                        }
                        else{
                            ans&=color[x]!=color[p];
                            if(!ans)
                            return ans;
                        }
                    }
                }
                
            }
        }
        
        return ans;
    }
}

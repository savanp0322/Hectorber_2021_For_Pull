import java.util.*;

public class Vertex_Cover {

    static void printVertexCover(ArrayList<ArrayList<Integer>> adj){
        HashSet<Integer> hs=new HashSet<>();
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=adj.size()-1;i>=0;i--){
            if(!hs.contains(i)){
                ans.add(i);
                hs.add(i);
                for(int x:adj.get(i)){
                    hs.add(x);
                }
            }
        }

        System.out.println(ans);
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj,int src,int dst){
        adj.get(src).add(dst);
        adj.get(dst).add(src);
    }
    public static void main(String args[])
    {
        // Create a graph given in the above diagram
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int v=5;

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }
        addEdge(adj,0, 2);
        addEdge(adj,2, 4);
        addEdge(adj,4, 3);
        addEdge(adj,1, 4);
        // addEdge(adj,4, 5);
        // addEdge(adj,2, 5);
 
        printVertexCover(adj);
    }
}

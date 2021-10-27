import java.util.*;
class Prim
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static class Node implements Comparable<Node>{
        int val,wght;
        
        Node(int v,int w){
            val=v;
            wght=w;
        }
        
        
        public int compareTo(Node n){
            return this.wght-n.wght;
        }
        
        public String toString(){
            return "["+val+","+wght+"]";
        }
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        boolean visited[]=new boolean[V];
        int ans=0;
        // pq.add(new Node(0,adj.get(0).get(1)));
        int xx=1;
        
        
      for(ArrayList<Integer> x:adj.get(0)){
            // for(ArrayList<Integer> y:x){
                pq.add(new Node(x.get(0),x.get(1)));
            // } 
        }
        visited[0]=true;
        // pq.add(new Node(0,0));
        while(xx<V ){
            Node n=pq.poll();
            
            if(visited[n.val]){
                continue;
            }
            
            ans+=n.wght;
            xx++;
            visited[n.val]=true;
            //   System.out.println(pq+"---"+ans);
                for(ArrayList<Integer> y:adj.get(n.val)){
                    if(!visited[y.get(0)]){
                        pq.add(new Node(y.get(0),y.get(1)));
                    }
                }
            }
        return ans;
    }
}
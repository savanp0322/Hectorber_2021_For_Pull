import java.util.*;
public class Kruskal   {
    static class Edge implements Comparable<Edge>{
        int src,dest,wght;
        Edge(int s,int d,int w){
            src=s;
            dest=d;
            wght=w;
        }

        public int compareTo(Edge e){
            return this.wght-e.wght;
        }

    }

    static class DSU{
        int parent,rank;
        public String toString(){
            return "["+this.parent+","+this.rank+"]";
        }
    }
    
    // static int find(DSU[] x,int y){
    //     if(x[y].parent!=y){
    //         x[y].parent=find(x,x[y].parent);
    //     }
    //     // System.out.println(Arrays.toString(x));
    //     return x[y].parent;
    // }

    // static void union(DSU[] x,int a,int b){
    //     int aroot=find(x,a);
    //     int broot=find(x,b);

    //     if(x[aroot].rank > x[broot].rank){
    //         x[aroot].parent=broot;
    //     }
    //     else if(x[aroot].rank < x[broot].rank){
    //         x[broot].parent=aroot;
    //     }
    //     else{
    //         x[aroot].parent=broot;
    //         x[broot].rank++;
    //     }
    // }
    static int find(DSU subsets[], int i)
    {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent
                = find(subsets, subsets[i].parent);
 
        return subsets[i].parent;
    }
 
    // A function that does union of two sets
    // of x and y (uses union by rank)
    static void union(DSU subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
 
        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)
        if (subsets[xroot].rank
            < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank
                 > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
 
        // If ranks are same, then make one as
        // root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }
    static void Kruskal_Algo(Edge[] elist,int V){
        Arrays.sort(elist);
        int e=0;
        DSU[] dis=new DSU[V];
        for(int i=0;i<V;i++){
            dis[i]=new DSU();
            dis[i].parent=i;
            dis[i].rank=0;
        }
        int i=0;
        System.out.println(Arrays.toString(dis));
        while(e<V-1){
            Edge next_edge = elist[i++];
            int x=find(dis,next_edge.src);
            int y=find(dis,next_edge.dest);

            if(x!=y){
                System.out.println(next_edge.src+" "+next_edge.dest+" "+next_edge.wght+" ");
                union(dis, x, y);
                e++;
            }
        }
    }
    public static void main(String[] args) {
        Edge[] elist=new Edge[5];
        int V=4;
        elist[0]=new Edge(0,1,10);
        elist[1]=new Edge(0,2,6);
        elist[2]=new Edge(0,3,5);
        elist[3]=new Edge(1,3,15);
        elist[4]=new Edge(2,3,4);

        Kruskal_Algo(elist, V);
    }
}

import java.util.*;

public class Water_Jug {

    static class Pair{
        int f,s;
        Pair(int ff,int ss){
            f=ff;
            s=ss;
        }
        public String toString(){
            return "["+f+","+s+"]";
        }
    }

    static void water_jug(int a,int b,int target){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        Queue<Pair> ans=new LinkedList<>();
        int[][]  vis=new int[1000][1000];
        boolean isPossible=false;
        while(q.size()>0){
            // System.out.println(q);
            Pair p=q.remove();

            if(p.f>a || p.s>b || p.f<0 || p.s<0){
                continue;
            }

            if(vis[p.f][p.s]>0){
                continue;
            }
            vis[p.f][p.s]=1;
            ans.add(new Pair(p.f,p.s));
            if(p.f==target || p.s==target){
                isPossible=true;
                if(p.f==target){
                    if(p.s!=0){
                        ans.add(new Pair(p.f,0));
                    }
                }else{
                    if(p.f!=0){
                        ans.add(new Pair(0,p.s));
                    }
                }
                for(Pair x:ans){
                    System.out.println(x.f+" , "+x.s);
                }
                break;
            }
            q.add(new Pair(p.f,b));
            q.add(new Pair(a,p.s));
            for(int x=0;x<Math.max(a,b);x++){
                int na=p.f+x;
                int nb=p.s-x;

                if(na==a || nb==0 ){
                    q.add(new Pair(na,nb));
                }

                na=p.f-x;
                nb=p.s+x;
                if(na==0 || nb==b){
                    q.add(new Pair(na,nb));
                }
            }
            q.add(new Pair(a,0));
            q.add(new Pair(0,b));
        }
        if(!isPossible){
            System.out.println("Not Possible");
        }

    }    
    public static void main(String[] args) {
        water_jug(5,4,3);
    }
}


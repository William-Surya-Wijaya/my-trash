//import java.util.*;
//public class enjel{
//    int N;
//    int[][] matrix;
//    int counter;
//    int[] ord;
//    int[] parents;
//
//    public enjel(int N){
//        this.N = N;
//        this.matrix = new int[N][N];
//        this.ord=new int[N];
//        this.parents=new int[N];
//    }
//
//    public void addEdge(int v1, int v2){
//        this.matrix[v1][v2] = 1;
//        this.matrix[v2][v1] = 1;
//    }
//
//    public void addEdge(int v1, int v2, int bobot){
//        this.matrix[v1][v2] = bobot;
//        this.matrix[v2][v1] = bobot;
//    }
//
//    public void removeEdge(int v1, int v2){
//        this.matrix[v1][v2] = 0;
//        this.matrix[v2][v1] = 0;
//    }
//
//    public int isEdgeExist(int v1, int v2){
//        return this.matrix[v1][v2];
//    }
//
//    @Override
//    public String toString(){
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println("");
//        }
//        return "";
//    }
//
//    public void DFS(int edge){
//        for(int i=0;i<N;i++){
//            this.ord[i]=-1;
//            this.parents[i]=-1;
//        }
//        DFSR(edge);
//        System.out.println("");
//    }
//
//    public void DFSR(int idx){
//        this.ord[idx]=counter;
//        this.counter=this.counter+1;
//        process(idx);
//        for(int i=0;i<N;i++){
//            if(this.ord[i]==-1){
//                if(matrix[i][idx]==1){
//                    DFSR(i);
//                }
//            }
//        }
//    }
//
//    public void BFS(int edge){
//        Queue que=new LinkedList();
//        counter=1;
//        for(int i=0;i<N;i++){
//            this.ord[i]=-1;
//            this.parents[i]=-1;
//        }
//        for(int i=0;i<N;i++){
//            if(ord[i]==-1){
//                que.offer(i);
//                ord[i]=counter;
//                counter++;
//                while(que.isEmpty()==false){
//                    int x=(int)que.poll();
//                    process(x);
//                    for(int j=0;j<N;j++){
//                        if(ord[j]==-1){
//                            if(matrix[j][x]==1){
//                                parents[j]=x;
//                                ord[j]=counter;
//                                counter++;
//                                que.offer(j);
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public void process(int v){
//        System.out.print(v+" ");
//    }
//}
//
//class TesterGraph{
//    public static void main(String[] args){
//        enjel g = new enjel(6);
//        g.addEdge(0,1);
//        g.addEdge(1,2);
//        g.addEdge(2,3);
//        g.addEdge(1,3);
//        g.addEdge(5,1);
//        g.addEdge(1,3);
//        g.addEdge(5,4);
//        g.addEdge(3,4);
//
//        System.out.println(g);
//        g.DFS(5);
//        g.BFS(5);
//    }
//}

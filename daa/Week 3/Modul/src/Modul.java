import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class Modul {
    int N;
    int[][] matrix;
    int[] ord;
    int ctr;
    int[] parent;

    public Modul(int N) {
        this.N = N;
        this.matrix = new int[N][N];
        this.ord = new int[N];
        this.ctr = 0;
        this.parent = new int[N];
    }

    public void addEdge(int v1, int v2) {
        this.matrix[v1][v2] = 1;
        this.matrix[v2][v1] = 1;
    }

    public void addEdge(int v1, int v2, int bobot) {
        this.matrix[v1][v2] = bobot;
        this.matrix[v2][v1] = bobot;
    }

    public void removeEdge(int v1, int v2) {
        this.matrix[v1][v2] = 0;
        this.matrix[v2][v1] = 0;
    }

    public int isEdgeExist(int v1, int v2) {
        return this.matrix[v1][v2];
    }

    @Override
    public String toString() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        return "";
    }

    public void DFS(int edge) {
        for (int i = 0; i < N; i++) {
            this.ord[i] = 1;
            this.parent[i] = -1;
        }
        DFSRecursive(edge);
        System.out.println();
    }

    private void DFSRecursive(int idx) {
        this.ord[idx] = ctr;
        this.ctr = this.ctr + 1;

        process(idx);

        for(int i = 0; i < N; i++){
            if(this.ord[i] == -1){
                if(matrix[i][idx] == 1){
                    DFSRecursive(i);
                }
            }
        }
    }

    public void BFS(int edge) {
        Queue queue = new LinkedList();
        ctr = 1;

        for (int i = 0; i < N; i++) {
            this.ord[i] = -1;
            this.parent[i] = -1;
        }

        for (int i = 0; i < N; i++) {
            if (ord[i]==-1) {
                queue.offer(i);
                ord[i] = ctr;
                ctr++;

                while(queue.isEmpty()==false) {
                    int x = (int)queue.poll();
                    process(x);

                    for (int j = 0; j < N; j++) {
                        if (ord[j]==-1) {
                            if (matrix[j][x] == 1) {
                                parent[j] = x;
                                ord[j] = ctr;
                                ctr++;
                                queue.offer(j);
                            }
                        }
                    }
                }
            }
        }

    }

    public void process(int v) {
        System.out.print(v + " ");
    }
}

class testerGraph{
    public static void main(String[] args) {
        Modul g = new Modul(6);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
//        g.addEdge(2, 3);
//        g.addEdge(1, 3);
//        g.addEdge(5, 1);
//        g.addEdge(1, 3);
//        g.addEdge(5, 4);
//        g.addEdge(3, 4);

//        System.out.println(g);

        g.DFS(0);
//        g.BFS(5);

        System.out.println(g);
    }
}

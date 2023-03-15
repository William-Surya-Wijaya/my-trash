import java.util.LinkedList;
import java.util.Scanner;
import java.util.*;

public class DododanBatanganEmas2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int a = 0; a < n; a++) {
            int v = sc.nextInt();

            char[] abjad = new char[v];

            for (int i = 0; i < v; i++) {
                abjad[i] = sc.next().charAt(0);
            }

            int e = sc.nextInt();

            Modul g = new Modul(v);

            int awal = 0;

            for (int i = 0; i < e; i++) {
                char x = sc.next().charAt(0);
                char y = sc.next().charAt(0);

                int idx1=-1, idx2=-1;

                for ( int k = 0; k < v; k++){
                    if (abjad [k] == x){
                        idx1 = k;
                    }

                    if (abjad [k] == y){
                        idx2 = k;
                    }
                }

                g.addEdge(idx1,idx2);
            }

            g.DFS();

            int[][] ress = g.getMatrix();

            Graph gg = new Graph(v, ress);

            int x = gg.DFS();

            System.out.println(g.DFS());


        }
    }
}

class Modul {
    int N;
    int[][] matrix;
    int[] ord;
    int ctr;
    int[] parent;
    int counter;

    public Modul(int N) {
        this.N = N;
        this.matrix = new int[N][N];
        this.ord = new int[N];
        this.ctr = 0;
        this.parent = new int[N];
        this.counter = 0;
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

    public int DFS(){
        int hasil=0;

        for(int i = 0;i < N; i++){
            this.ord[i] = -1;
            this.parent[i] = -1;
        }

        for(int i = 0; i < N; i++){
            if(this.ord[i] == -1){
                DFSRecur(i);
                hasil++;
            }
        }

        return hasil;
    }

    public void DFSRecur(int idx){
        this.ord[idx] = ctr;
        this.counter++;

        for(int i = 0; i < N; i++){
            if(this.ord[i] == -1){
                if(matrix[i][idx] == 1){
                    parent[i] = idx;
                    DFSRecur(i);
                }
            }
        }
    }

    public int getCounter() {
        return this.counter;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public int getCtr() {
        return this.ctr;
    }
}

class Graph{
    int n;
    int[][] matrix;
    boolean[] visited;

    public Graph(int v, int[][] x) {
        this.n = v;

        this.matrix = new int[v][v];
        this.matrix = x;

        this.visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            visited[i] = false;
        }
    }

    public int DFS() {
        int counter = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]==false) {
                counter++;
                DFSRecursive(i);
            }
        }

        return counter;
    }

    public void DFSRecursive(int starting_node) {
        visited[starting_node] = true;

        for (int i = 0; i < n; i++) {
            if (matrix[i][starting_node] == 1 && visited[i] == false) {
                DFSRecursive(i);
            }
        }
    }
}
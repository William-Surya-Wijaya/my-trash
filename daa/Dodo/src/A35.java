import java.util.*;

public class A35 {
    // Menggunakan class dari Modul pada saat kemarin, dengan beberapa modifikasi. Pada saat modul
    // kemarin, adj Matrix nya merupakan graph tak berarah sehingga matrix adj nya tampak seperti
    // cermin ketika dibelah diagonal. Maka dari itu, di dalam method addEdge, saya hilangkan 1 baris
    // kodingannya agar bisa menjadi adj matrix berarah. Setelah berhasil membuat adj matrix berarah,
    // saya mengambil matrix tersebut kembali ke dalam method main. Matrix tersebut kemudian akan
    // di transpose oleh method transpose dan kemudian akan dibalikkan kembali ke dalam method main.
    // Kedua matrix tersebut kemudian akan diprint di dalam method main dan akan menjadi output
    // dalam soal ini.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        Graph g = new Graph(n);

        int[][] adjMatrixInt = new int[n][n];

        for (int i = 0; i < e; i++) {
            int idx1 = sc.nextInt();
            int idx2 = sc.nextInt();

            g.addEdge(idx1, idx2);
        }

        adjMatrixInt = g.getMatrix();

        String[][] adjMatrixBT = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrixInt[i][j]==1) {
                    adjMatrixBT[i][j] = "T";
                }else {
                    adjMatrixBT[i][j] = "F";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrixBT[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        String[][] adjMatrixAT = transpose(adjMatrixBT, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrixAT[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static String[][] transpose(String[][] matrix, int n) {
        String[][] matrixx = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixx[i][j] = matrix[j][i];
            }
        }
        return matrixx;
    }
}

class Graph {
    int N;
    int[][] matrix;
    int[] ord;
    int ctr;
    int[] parent;

    public Graph(int N) {
        this.N = N;
        this.matrix = new int[N][N];
        this.ord = new int[N];
        this.ctr = 0;
        this.parent = new int[N];
    }

    public void addEdge(int v1, int v2) {
        this.matrix[v1][v2] = 1;
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

    public int[][] getMatrix() {
        return this.matrix;
    }
}
//import java.util.Scanner;
//
//public class D06 {
//    // Pertama-tama masukan berupa parameter besarnya sebuah array, yang kemudian akan digunakan untuk
//    // membuat array 2 dimensi berukuran parameter x parameter. Setelah itu array tersebut akan
//    // dipanggil kedalam method yang ada di dalam class Graph. Di dalam method ini, akan dilakukan
//    // serangkaian pengecekan. Pertama-tama akan ada atribut array 2d matrix yang bertipe int dan
//    // array 1d visited yang boolean. Guna nya dari array visited adalah untuk melakukan pengecekan
//    // apakah vertex tersebut sudah pernah dikunjungi atau belum. Karena saya menggunakan DFS untuk
//    // melakukan pengecekan dan pembuatan graph nya, maka akan ada method recursive. Keluaran dari
//    // method ini adalah sebuah bilangan counter yang berguna untuk melakukan penambahan apabila ada
//    // graph yang tidak terconnected atau terhubung. Setelah itu, nilai ini akan diambil ke dalam method
//    // main dan akan dilakukan print terhadap nilai ini.
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        int[][] adjMatrix = new int[n][n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                adjMatrix[i][j] = sc.nextInt();
//            }
//        }
//
//        Graph graph = new Graph(n,adjMatrix);
//        int res = graph.DFS();
//
//        System.out.println(res);
//    }
//}
//
//class Graph{
//    int n;
//    int[][] matrix;
//    boolean[] visited;
//
//    public Graph(int v, int[][] x) {
//        this.n = v;
//
//        this.matrix = new int[v][v];
//        this.matrix = x;
//
//        this.visited = new boolean[v];
//
//        for (int i = 0; i < v; i++) {
//            visited[i] = false;
//        }
//    }
//
//    public int DFS() {
//        int counter = 0;
//
//        for (int i = 0; i < n; i++) {
//            if (visited[i]==false) {
//                counter++;
//                DFSRecursive(i);
//            }
//        }
//
//        return counter;
//    }
//
//    public void DFSRecursive(int starting_node) {
//        visited[starting_node] = true;
//
//        for (int i = 0; i < n; i++) {
//            if (matrix[i][starting_node] == 1 && visited[i] == false) {
//                DFSRecursive(i);
//            }
//        }
//    }
//}

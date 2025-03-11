import java.util.*;

public class DodoEulerGraf {
    static int vertices, edge;
    static int[][] matrix;
    static int[] degree;
    static boolean[] visited;

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        vertices = scanner.nextInt();
        edge = scanner.nextInt();

        matrix = new int[vertices][vertices];
        degree = new int[vertices];
        visited = new boolean[vertices];

        for(int i=0; i<edge; i++){
            int x = scanner.nextInt()-1;
            int y = scanner.nextInt()-1;

            matrix[x][y] = matrix[y][x] = 1;
            degree[x]++;
            degree[y]++;
        }

        scanner.close();
        printMatrix();

        if(isConnected()){
            if(isEulerian()){
                System.out.println("EULER");
            } else {
                System.out.println("!EULER");
            }
        } else {
            System.out.println("!EULER");
        }
    }

    static boolean isEulerian(){
        int oddCount = 0;
        for (int i = 0; i < vertices; i++) {
            if (degree[i] % 2 == 1) {
                oddCount++;
            }
        }

        return (oddCount == 0 || oddCount == 2);
    }

    static boolean isConnected(){
        int startNode = -1;
        for(int i = 0; i<vertices; i++){
            if(degree[i] > 0){
                startNode = i;
                break;
            }
        }

        if(startNode == -1) return true;

        dfs(startNode);

        for(int i = 0; i<vertices; i++){
            if(degree[i] > 0 && !visited[i]){
                return false;
            }
        }

        return true;
    }

    static void dfs(int startNode){
        visited[startNode] = true;
        for(int i = 0; i<vertices; i++){
            if(matrix[startNode][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    static void printMatrix(){
        for(int i=0; i<vertices; i++){
            for(int j=0; j<vertices; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
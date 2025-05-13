import java.util.*;
 
class ModulSearchGraph2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int papan[][] = new int[3][3];
 
        String arah[] = {"atas", "bawah", "kiri", "kanan"};
 
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                papan[i][j] = scanner.nextInt();
            }
        }
 
        State awal = new State(papan);
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                papan[i][j] = scanner.nextInt();
            }
        }
 
        State akhir = new State(papan);
        EigthPuzzle solver = new EigthPuzzle(awal, akhir);
        int depthLimit = 20;
        Stack<Integer> result = solver.DLS(depthLimit);

        if(result != null){
            System.out.printf("DLS solution %d step(s)\n", result.size());
        } else {
            System.out.println("DLS solution not found");
        }
    }
}
 
class State{
    private int papan[][] = new int[3][3];
    private int baris, kolom;
    
    private static int deltaBaris[] = {-1, +1, 0, 0};
    private static int deltaKolom[] = {0, 0, -1, +1};
 
    public State(int papan[][]){
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                this.papan[i][j] = papan[i][j];
                if(papan[i][j] == 0){
                    this.baris = i;
                    this.kolom = j;
                }
            }
        }
    }
 
    @Override
    public String toString(){
        String result = "";
        
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                result += this.papan[i][j];
            }
            result += "\n";
        }
 
        return result;
    }
 
    @Override
    public boolean equals(Object other){
        if(other == null || !(other instanceof State)){
            return false;
        }
 
        State check = (State) other;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(this.papan[i][j] != check.papan[i][j]){
                    return false;
                }
            }
        }
 
        return true;
    }
 
    @Override
    public int hashCode(){
        String hashed = "";
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                hashed += Integer.toString(papan[i][j]);
            }
        }
 
        return Integer.parseInt(hashed);
    }
 
    public State doAction(int idx) {
        int newBaris = baris + deltaBaris[idx];
        int newKolom = kolom + deltaKolom[idx];
 
        if (newBaris < 0 || newBaris > 2 || newKolom < 0 || newKolom > 2) {
            return null;
        }
 
        int[][] newBoard = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newBoard[i][j] = this.papan[i][j];
            }
        }
 
        newBoard[baris][kolom] = newBoard[newBaris][newKolom];
        newBoard[newBaris][newKolom] = 0;
 
        return new State(newBoard);
    }    
}
 
class EigthPuzzle{
    class Node{
        private State state;
        private Node parent;
        private int action;
        private int cost;
        private int depth;
        
        public Node(State state, Node parent, int action, int cost, int depth) {
            this.state = state;
            this.parent = parent;
            this.action = action;
            this.cost = cost;
            this.depth = depth;
        }
    }
 
    public State awal;
    public State akhir;
 
    public EigthPuzzle(State awal, State akhir){
        this.awal = awal;
        this.akhir = akhir;
    }
 
    public Stack<Integer> DLS(int limit) {
        Stack<Integer> actions = new Stack<>();

        if (awal.equals(akhir)) {
            return actions;
        }

        Stack<Node> frontier = new Stack<>();
        Set<State> visited = new HashSet<>();

        Node root = new Node(awal, null, -1, 0, 0);
        frontier.push(root);
        visited.add(awal);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.pop();

            if (currentNode.depth >= limit) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                State neighborState = currentNode.state.doAction(i);

                if (neighborState != null && !visited.contains(neighborState)) {
                    Node neighborNode = new Node(neighborState, currentNode, i, currentNode.cost + 1, currentNode.depth + 1);
                    if (neighborState.equals(akhir)) {
                        // Bangun kembali jalur tindakan
                        Stack<Integer> result = new Stack<>();
                        Node current = neighborNode;
                        while (current.parent != null) {
                            result.push(current.action);
                            current = current.parent;
                        }
                        return result;
                    }
                    frontier.push(neighborNode);
                    visited.add(neighborState);
                }
            }
        }

        return null;
    }
}
import java.util.*;
 
class ModulSearchGraph{
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
        Stack<Integer> result = solver.BFS();

        if(result == null){
            System.out.println("Tidak ada solusi ditemukan!");
            return;
        }

        System.out.printf("BFS %d step(s)\n\n", result.size());

        List<Integer> actionsList = new ArrayList<>(result);

        State currentState = awal;
        for(int i = actionsList.size() - 1; i >= 0; i--){
            int action = actionsList.get(i);
            System.out.println(arah[action]);
            currentState = currentState.doAction(action);
            System.out.println(currentState);
        }
 
        // Modul part 2 ---------
 
        // for(int i = 0; i<4; i++){
        //     System.out.println(arah[i]);
        //     System.out.println(awal.doAction(i));
        // }
 
        // Modul part 1 ---------
 
        // for(int i = 0; i<3; i++){
        //     for(int j = 0; j<3; j++){
        //         papan[i][j] = scanner.nextInt();
        //     }
        // }
 
        // State akhir = new State(papan);
 
        // System.out.println(awal.equals(akhir));
 
        // System.out.println(awal.hashCode());
        // System.out.println(akhir.hashCode());
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
        
        public Node(State state, Node parent, int action, int cost){
            this.state = state;
            this.parent = parent;
            this.action = action;
            this.cost = cost;
        }
    }
 
    public State awal;
    public State akhir;
 
    public EigthPuzzle(State awal, State akhir){
        this.awal = awal;
        this.akhir = akhir;
    }
 
    public boolean satuLangkah(){
        HashMap <State, Node> visited = new HashMap<State, Node>();
 
        Node root = new Node(awal, null, -1, 0);
        visited.put(awal, root);
        
        State temp;
        for(int i = 0; i<4; i++){
            temp = awal.doAction(i);
            visited.put(temp, new Node(temp, root, i, root.cost+1));
        }
 
        if(visited.get(akhir)!= null){
            return true;
        } else {
            return false;
        }
    }

    public Stack<Integer> BFS(){
        Stack<Integer> actions = new Stack<Integer>();

        if (awal.equals(akhir)) {
            return actions;
        }

        HashMap<State, Node> visited = new HashMap<>();
        Queue<Node> frontier = new LinkedList<>();

        Node root = new Node(awal, null, -1, 0);
        frontier.add(root);
        visited.put(awal, root);

        boolean finished = false;

        while (!frontier.isEmpty() && !finished) {
            Node currentNode = frontier.poll();

            for (int i = 0; i < 4; i++) {
                State neighborState = currentNode.state.doAction(i);

                if (neighborState != null && !visited.containsKey(neighborState)) {
                    Node neighborNode = new Node(neighborState, currentNode, i, currentNode.cost + 1);
                    frontier.add(neighborNode);
                    visited.put(neighborState, neighborNode);

                    if (neighborState.equals(akhir)) {
                        finished = true;
                        break;
                    }
                }
            }
        }

        if (finished) {
            Node current = visited.get(akhir);
            while (current.parent != null) {
                actions.push(current.action);
                current = current.parent;
            }
            return actions;
        } else {
            return null;
        }
    }
}
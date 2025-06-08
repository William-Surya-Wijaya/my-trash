package kuis;
import java.util.*;

public class LompatWombat {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int baris = scanner.nextInt();
        int kolom = scanner.nextInt();

        State state = new State(baris, kolom);

        for(int i = 0; i<baris; i++){
            for(int j = 0; j<kolom; j++){
                state.set(i,i,scanner.next());
            }
        }

        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        state.startingPosition(startX, startY);

        int goalX = scanner.nextInt();
        int goalY = scanner.nextInt();

        if(state.puzzle[goalX][goalY].equals("#")){
            System.out.println("solution not found");
        } else {
            state.goalPosition(goalX, goalY);

            Stack<Integer> actions = state.ABintang();
            if (actions == null) {
                System.out.println("solution not found");
            } else {
                System.out.println("solution " + actions.size() + " step(s)");
                State temp = new State(baris, kolom);
                for (int i = 0; i < baris; i++) {
                    for (int j = 0; j < kolom; j++) {
                        temp.puzzle[i][j] = state.puzzle[i][j];
                    }
                }
                temp.startingPosition(startX, startY);
                temp.goalPosition(goalX, goalY);

                while (!actions.isEmpty()) {
                    int act = actions.remove(0);
                    String[] arah = {"", "1:atas-kanan", "2:bawah-kanan", "3:kanan-atas", "4:kanan-bawah", "5:kiri-atas", "6:kiri-bawah", "7:bawah-kiri", "8:bawah-kanan"};
                    System.out.println(act + ":" + arah[act]);
                    temp = temp.move(act);
                    System.out.println(temp.currentX + "," + temp.currentY);
                }
            }
        }
    }
}

class State {
    String[][] puzzle;

    int sizeX;
    int sizeY;

    int currentX;
    int currentY;

    int goalX;
    int goalY;

    public State(int sizeX, int sizeY){
        this.puzzle = new String[sizeX][sizeY];
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void set(int baris, int kolom, String value){
        this.puzzle[baris][kolom] = value;
    }

    public void startingPosition(int baris, int kolom){
        this.currentX = baris;
        this.currentY = kolom;
    }
    
    public void goalPosition(int baris, int kolom){
        this.goalX = baris;
        this.goalY = kolom;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof State)) return false;

        State other = (State) object;
        return this.currentX == other.currentX && this.currentY == other.currentY;
    }

    @Override
    public int hashCode(){
        return Objects.hash(currentX, currentY);
    }

    private boolean isValid(int destX, int destY, int action){
        if(destX < 0 || destY < 0 || destX >= sizeX || destY >= sizeY){
            return false;
        }
        else if(this.puzzle[destX][destY].equals("#")){
            return false;
        }
        
        if(action == 1 || action == 2){
            if(this.puzzle[currentX][currentY+1].equals("#")){
                return false;
            }
        } else if(action == 3 || action == 4){
            if(this.puzzle[currentX-1][currentY].equals("#")){
                return false;
            }
        } else if(action == 5 || action == 6){
            if(this.puzzle[currentX+1][currentY].equals("#")){
                return false;
            }
        } else if(action == 7 || action == 8){
            if(this.puzzle[currentX][currentY-1].equals("#")){
                return false;
            }
        }
 
        return true;
    }

    public State move(int action){
        State nextPuzzle = new State(sizeX, sizeY);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                nextPuzzle.puzzle[i][j] = this.puzzle[i][j];
            }
        }

        int destX = 0, destY = 0;

        switch (action) {
            case 1: destX = currentX - 1; destY = currentY + 2; break;
            case 2: destX = currentX + 1; destY = currentY + 2; break;
            case 3: destX = currentX - 2; destY = currentY + 1; break;
            case 4: destX = currentX - 2; destY = currentY - 1; break;
            case 5: destX = currentX + 2; destY = currentY + 1; break;
            case 6: destX = currentX + 2; destY = currentY - 1; break;
            case 7: destX = currentX - 1; destY = currentY - 2; break;
            case 8: destX = currentX + 1; destY = currentY - 2; break;
            default: return null;
        }

        if (isValid(destX, destY, action)) {
            nextPuzzle.currentX = destX;
            nextPuzzle.currentY = destY;
            return nextPuzzle;
        } else {
            return null;
        }
    }

    private int manhattan(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2)) / 3;
    }

    public Stack<Integer> ABintang(){
        Stack<Integer> actions = new Stack<>();

        if(currentX == goalX && currentY == goalY) return actions;

        HashMap<State, Node> reached = new HashMap<>();
        HashMap<State, Node> openList = new HashMap<>();
        PriorityQueue<Node> frontier = new PriorityQueue<>();

        int hStart = manhattan(this.currentX, this.currentY, goalX, goalY);

        Node startNode = new Node(this, null, -1, 0, hStart);
        frontier.add(startNode);
        openList.put(this, startNode);

        Node goalNode = null;

        int i = 1;
        while(!frontier.isEmpty()){
            Node current = frontier.poll();

            if(current.state.currentX == goalX && current.state.currentY == goalY){
                goalNode = current;
                break;
            }

            if(reached.containsKey(current.state)) continue;

            openList.remove(current.state);
            reached.put(current.state, current);

            for(i = 1; i<=8; i++){
                State neighborState = current.state.move(i);
                if(neighborState == null) continue;

                int newG = current.g + 1;
                int newH = manhattan(neighborState.currentX, neighborState.currentY, goalX, goalY);

                Node neighbor = new Node(neighborState, current, i, newG, newH);

                if(reached.containsKey(neighborState)) continue;

                if(openList.containsKey(neighborState)){
                    Node old = openList.get(neighborState);
                    if(old.getF() <= neighbor.getF()) continue;
                }

                frontier.add(neighbor);
                openList.put(neighborState, neighbor);
            }
        }

        if(goalNode == null) return null;

        Node n = goalNode;
        while(n.parent != null){
            actions.push(n.action);

            n = n.parent;
        }

        return actions;
    }
}

class Node implements Comparable<Node>{
    State state;
    Node parent;
    int action;

    int g;
    int h;

    public Node(State state, Node parent, int action, int g, int h){
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.g = g;
        this.h = h;
    }

    public int getF(){
        return g+h;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.getF(), other.getF());
    }
}
import java.util.*;
 
public class LatA{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
 
        int baris = scanner.nextInt();
        int kolom = scanner.nextInt();
 
        Puzzle puzzle = new Puzzle(baris, kolom);
        
        for(int i = 0; i<baris; i++){
            for(int j = 0; j<kolom; j++){
                String value = scanner.next();
                puzzle.set(i, j, value);
            }
        }
 
        int awalX = scanner.nextInt();
        int awalY = scanner.nextInt();
 
        puzzle.putWombat(awalX, awalY);
 
        int akhirX = scanner.nextInt();
        int akhirY = scanner.nextInt();
 
        if(puzzle.matrix[akhirX][akhirY].equals("#")){
            System.out.println("solution not found");
        } else {
            puzzle.setFinal(akhirX, akhirY);
            Stack<Integer> actions = puzzle.ABintang();
                if (actions == null) {
                    System.out.println("solution not found");
                } else {
                    System.out.println("solution " + actions.size() + " step(s)");
                    Puzzle temp = new Puzzle(baris, kolom);
                    for (int i = 0; i < baris; i++) {
                        for (int j = 0; j < kolom; j++) {
                            temp.matrix[i][j] = puzzle.matrix[i][j];
                        }
                    }
                    temp.putWombat(awalX, awalY);
                    temp.setFinal(akhirX, akhirY);

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

class Node implements Comparable<Node> {
    Puzzle puzzle;
    Node parent;
    int action;
    int g;
    int h;

    public Node(Puzzle puzzle, Node parent, int action, int g, int h) {
        this.puzzle = puzzle;
        this.parent = parent;
        this.action = action;
        this.g = g;
        this.h = h;
    }

    public int getF() {
        return g + h;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.getF(), other.getF());
    }
}

 
class Puzzle{
    String[][] matrix;
 
    int sizeX;
    int sizeY;
 
    int currentX;
    int currentY;
 
    int finalX;
    int finalY;
 
    public Puzzle(int baris, int kolom){
        this.matrix = new String[baris][kolom];
        this.sizeX = baris;
        this.sizeY = kolom;
    }
 
    public void set(int baris, int kolom, String value){
        this.matrix[baris][kolom] = value;
    }
 
    public void putWombat(int baris, int kolom){
        this.currentX = baris;
        this.currentY = kolom;
    }
 
    public void setFinal(int baris, int kolom){
        this.finalX = baris;
        this.finalY = kolom;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Puzzle)) return false;
        Puzzle other = (Puzzle) obj;
        return this.currentX == other.currentX && this.currentY == other.currentY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentX, currentY);
    }
 
    public Puzzle move(int action){
        Puzzle nextPuzzle = new Puzzle(sizeX, sizeY);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                nextPuzzle.matrix[i][j] = this.matrix[i][j];
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
 
    private boolean isValid(int destX, int destY, int action){
        if(destX < 0 || destY < 0 || destX >= sizeX || destY >= sizeY){
            return false;
        }
        else if(this.matrix[destX][destY].equals("#")){
            return false;
        }
        
        if(action == 1 || action == 2){
            if(this.matrix[currentX][currentY+1] == "#"){
                return false;
            }
        } else if(action == 3 || action == 4){
            if(this.matrix[currentX-1][currentY] == "#"){
                return false;
            }
        } else if(action == 5 || action == 6){
            if(this.matrix[currentX+1][currentY] == "#"){
                return false;
            }
        } else if(action == 7 || action == 8){
            if(this.matrix[currentX][currentY-1] == "#"){
                return false;
            }
        }
 
        return true;
    }
    
    private int manhattan(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2)) / 3;
    }
    
 
    public Stack<Integer> ABintang() {
        // Stack untuk menyimpan urutan aksi lompatan dari awal ke tujuan
        Stack<Integer> actions = new Stack<>();
    
        // Jika posisi awal sama dengan posisi tujuan, tidak perlu melompat
        if (currentX == finalX && currentY == finalY) return actions;
    
        // Menyimpan state yang sudah dikunjungi (agar tidak diproses ulang)
        HashMap<Puzzle, Node> reached = new HashMap<>();
    
        // Menyimpan state yang sedang dalam antrean eksplorasi (untuk deteksi redundansi)
        HashMap<Puzzle, Node> openList = new HashMap<>();
    
        // Antrian prioritas untuk memilih node dengan nilai f(n) = g(n) + h(n) terkecil
        PriorityQueue<Node> frontier = new PriorityQueue<>();
    
        // Hitung heuristik awal menggunakan Manhattan Distance / 3
        int hStart = manhattan(this.currentX, this.currentY, finalX, finalY);
        
        // Buat node awal dan masukkan ke frontier
        Node startNode = new Node(this, null, -1, 0, hStart);
        frontier.add(startNode);
        openList.put(this, startNode);
    
        // Variabel untuk menyimpan node akhir jika ditemukan
        Node goalNode = null;
    
        // Proses eksplorasi sampai frontier kosong
        while (!frontier.isEmpty()) {
            // Ambil node dengan prioritas (f(n)) terkecil
            Node current = frontier.poll();
    
            // Jika posisi saat ini adalah tujuan, simpan dan keluar dari loop
            if (current.puzzle.currentX == finalX && current.puzzle.currentY == finalY) {
                goalNode = current;
                break;
            }
    
            // Jika node sudah pernah diproses, lewati
            if (reached.containsKey(current.puzzle)) continue;
    
            // Pindahkan node dari openList ke reached (sudah diproses)
            openList.remove(current.puzzle);
            reached.put(current.puzzle, current);
    
            // Coba semua kemungkinan aksi dari 1 hingga 8 (arah lompatan)
            for (int i = 1; i <= 8; i++) {
                // Buat state baru berdasarkan aksi
                Puzzle neighborState = current.puzzle.move(i);
                if (neighborState == null) continue; // jika tidak valid, lewati
    
                // Hitung biaya baru dan heuristik untuk node tetangga
                int newG = current.g + 1;
                int newH = manhattan(neighborState.currentX, neighborState.currentY, finalX, finalY);
                Node neighbor = new Node(neighborState, current, i, newG, newH);
    
                // Jika state sudah pernah diproses sebelumnya, lewati
                if (reached.containsKey(neighborState)) continue;
    
                // Jika state sudah ada di openList dan solusi sekarang lebih buruk, lewati
                if (openList.containsKey(neighborState)) {
                    Node old = openList.get(neighborState);
                    if (old.getF() <= neighbor.getF()) continue;
                }
    
                // Masukkan ke frontier dan openList (karena lebih baik atau belum ada)
                frontier.add(neighbor);
                openList.put(neighborState, neighbor);
            }
        }
    
        // Jika goal tidak ditemukan setelah semua eksplorasi, kembalikan null
        if (goalNode == null) return null;
    
        // Susun urutan aksi dari node tujuan ke node awal dengan backtracking
        Node n = goalNode;
        while (n.parent != null) {
            actions.push(n.action);  // masukkan ke stack agar urutannya benar (awal → tujuan)
            n = n.parent;
        }
    
        return actions;  // hasil akhir berupa urutan aksi melompat
    }    
}
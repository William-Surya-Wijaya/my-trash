import java.util.Scanner;

public class Womboland {
    // Dengan menggunakan kelas BinarySearchTree dari modul dengan sedikit modifikasi penambahan
    // method, maka soal ini bisa dikerjakan. Method Ancestor yang berada di dalam kelas
    // BinarySearchTree berfungsi untuk mencari leluhur yang dibutuhkan di soal ini.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //untuk memanggil scanner dari java
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(); //untuk memanggil class BinarySearchTree

        int p = sc.nextInt(); //masukan pertama untuk parameter banyaknya penduduk womboland

        for (int i = 0; i < p; i++) { // looping untuk memasukkan ke dalam tree nya
            bst.insert(sc.nextInt());
        }

        int n = sc.nextInt(); // masukan untuk parameter banyaknya pertanyaan dari wombo dan wombi

        for (int i = 0; i < n; i++) { // looping dengan parameter n
            int a = sc.nextInt(); // masukan selanjutnya yang berfungsi untuk menandakan 2 info yang akan dicari leluhur terdekatnya
            int b = sc.nextInt();

            System.out.println(bst.ancestor(a,b)); // print hasil dari method ancestor pada class BinarySearchTree
        }
    }
}

class BinarySearchTree<T extends Comparable<T>>{ // Kelas ini diadopsi dari kelas BinarySearchTree pada modul dengan ditambahkan 2 method baru yaitu Node Ancestor dan T Ancestor.
    private Node root;

    private class Node{ // Sama seperti pada modul
        T info;
        Node left, right, parent;

        Node(T info){
            this.info = info;
        }

        @Override
        public String toString() {
            return "[" + this.info.toString() + "]";
        }
    }

    public void insert(T data){ // Sama seperti pada modul
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;

        if (this.root==null){
            this.root = newNode;
        }else {
            while(curr!=null){
                parent = curr;

                if (data.compareTo(curr.info) < 0) {
                    curr = curr.left;
                }else {
                    curr = curr.right;
                }
            }

            newNode.parent = parent;

            if (data.compareTo(parent.info) < 0) {
                parent.left = newNode;
            }else {
                parent.right = newNode;
            }
        }
    }

    public Node ancestor(Node curr, T idx1, T idx2) { // Method baru
        if (curr==null) {// Dilakukan cek terlebih dahulu apakah rootnya ada atau tidak, bila tidak
            return null; // maka akan dilakukan return null.
        }
        // Bila ada, maka akan dilanjutkan ke dalam looping ini.
        while (curr!=null) {
            if (curr.info.compareTo(idx1) < 0 && curr.info.compareTo(idx2) < 0) { // Bila root lebih kecil dari idx1 dan lebih kecil dari idx2, maka akan dilakukan looping (while) mencari leluhur dengan root yang baru yaitu curr.right (root kanan).
                curr = curr.right;
            }else if (curr.info.compareTo(idx1) > 0 && curr.info.compareTo(idx2) > 0) { // Bila root lebih besar dari idx1 dan lebih besar dari idx2, maka akan dilakukan looping (while) mencari leluhur dengan root yang baru yaitu curr.left (root kiri).
                curr = curr.left;
            }else {
                break;
            }
        }

        return curr; // curr atau rootnya akan di return
    }

    public T ancestor(T a, T b) { // Method ini berguna untuk mereturn nilai dari Method node ancestor dikarenakan method tersebut mereturn root dan bukan hasil akhirnya.
        Node result = ancestor(this.root,a, b); // Pemanggilan method node ancestor dengan menggunakan parameter dari parameter method T ancestor yaitu a dan b.

        if (result==null) { // Bila hasil nya null, maka akan direturn null juga. Selain daripada itu, maka method ini akan mereturn result.info atau hasil dari perhitungan yang sudah dilakukan oleh method node ancestor.
            return null;
        }else {
            return result.info;
        }
    }

}
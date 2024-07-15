import java.util.Scanner;

public class A39 {
    // Dengan menggunakan class insert BST dari modul yang sudah pernah dikerjakan dengan ditambahkan
    // sedikit modifikasi (method ini akan mengeluarkan sebuah bilangan bulat yaitu counter)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//Scanner untuk input
        
        int n = sc.nextInt();//masukkan bilangan n sebagai parameter

        BinarySearchTree bst = new BinarySearchTree();//import kelas BinarySearchTree as bst

        for (int i = 0; i < n; i++) {//melakukan looping untuk input dengan parameter n
            int res = bst.insert(sc.nextInt());//karena method insert sekarang sudah mengeluarkan sebuah bilangan, maka bilangan tersebut akan saya tampung di dalam variabel res
            System.out.println(res);//melakukan print dari hasil keluaran method insert
        }

    }
}
//Secara garis besar sama seperti modul, tapi class ini saya persingkat karena tidak butuh method lainnya seperti delete, min, max, maka saya delete semua.
class BinarySearchTree<T extends Comparable<T>>{
    private Node root;
    private int counter = 0;//melakukan pembuatan variabel counter yang diisi dengan nilai 0 terlebih dahulu

    private class Node{
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

    public int insert(T data){//method insert
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;

        if (this.root==null){//melakukan pengecekan terlebih dahulu apakah root nya 0 atau tidak (hanya untuk pertama kali karena selanjutnya tentu saja root sudah diisi sehingga akan langsung masuk ke kodingan yang bawah)
            this.root = newNode;//melakukan pengisian node root
        }else {
            while(curr!=null){//melakukan looping untuk menentukan root mana yang kosong atau yang belum terbentuk
                parent = curr;

                if (data.compareTo(curr.info) < 0) {//melakukan pengecekan apabila nilai compare lebih kecil dari 0, maka akan dilakukan pembuatan ke arah kiri
                    curr = curr.left;
                }else {//sebaliknya, apabila nilai lebih besar dari 0, maka akan dilakukan pembuatan ke arah kanan
                    curr = curr.right;
                }

                this.counter++;//setelah dilakukan pengecekan, maka counter akan bertambah. counter akan tetap bertambah meskipun tidak dilakukan pembuatan node
            }

            newNode.parent = parent;

            if (data.compareTo(parent.info) < 0) {
                parent.left = newNode;
            }else {
                parent.right = newNode;
            }
        }

        return this.counter;//melakukan pengembalian nilai counter agar dapat diambil kembali di method main
    }
}
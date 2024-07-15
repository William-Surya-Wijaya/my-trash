import java.util.LinkedList;
import java.util.Scanner;

public class Womboland {
    // Saya menggunakan method dari modul kemarin yang sudah saya kerjakan modul deletenya.
    // Kemudian saya modifikasi sehingga setiap kali terjadi perubahan di node, maka perubahan
    // tersebut akan masuk ke dalam linkedlist yang telah saya buat yang kemudian method delete
    // akan mengeluarkan sebuah linkedlist yang kemudian akan di print di method main. Dikarenakan
    // linkedlist tersebut masih memiliki tipe Node, maka diperlukan sebuah cara untuk mengubah node
    // tersebut menjadi output yang diminta.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();

        BinarySearchTree bst = new BinarySearchTree();

        for (int i = 0; i < p; i++) {
            bst.insert(sc.nextInt());
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        for (int i = low; i < high; i++) {
            if (bst.search(i)!=null) {
                bst.delete(i);
            }
        }

    }
}

class BinarySearchTree<T extends Comparable<T>>{
    private Node root;

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

    public void insert(T data){
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

    @Override
    public String toString() {
        return inorder(this.root);
    }


    private String inorder(Node x) {
        if (x==null) {
            return "";
        }

        if (x.left==null && x.right==null) {
            return x.toString();
        }else {
            return inorder(x.left) + x.toString() + inorder(x.right);
        }
    }

    public T search(T data) {
        Node result = search(data, this.root);

        if (result==null) {
            return null;
        }else {
            return result.info;
        }
    }

    private Node search(T data, Node curr){
        if (curr==null) {
            return null;
        }else if (curr.info.compareTo(data)==0) {
            return curr;
        }else if (curr.info.compareTo(data) < 0) {
            return search(data, curr.right);
        }else {
            return search(data, curr.left);
        }
    }

    public T min() {
        Node result = min(this.root);

        if (result==null) {
            return null;
        }else {
            return result.info;
        }
    }

    private Node min(Node curr) {
        if (curr==null) {
            return null;
        }else {
            if (curr.left!=null) {
                curr = curr.left;
            }
            return curr;
        }
    }

    public T max() {
        Node result = max(this.root);

        if (result==null) {
            return null;
        }else {
            return result.info;
        }
    }

    private Node max(Node curr) {
        if (curr==null) {
            return null;
        }else {
            if (curr.right!=null) {
                curr = curr.right;
            }
            return curr;
        }
    }

    private Node successor(Node curr) {
        if (curr.right!=null) {
            return min(curr.right);
        }else {
            Node node = curr.parent;

            while(node!=null && curr==node.right) {
                curr = node;
                node = node.parent;
            }

            return node;
        }
    }

    private Node predecessor(Node curr) {
        if (curr.left!=null) {
            return min(curr.left);
        }else {
            Node node = curr.parent;

            while(node!=null && curr==node.right) {
                curr = node;
                node = node.parent;
            }

            return node;
        }
    }

    public boolean delete(T data) {
        Node del = search(data, this.root);

        if (del==null) {
            return false;
        }else {
            delete(del);
            return true;
        }
    }

    private LinkedList delete(Node del) {
        Node curr;

        LinkedList<Node> ll = new LinkedList<>();

        if (del.left==null && del.right==null) {
            if(del.parent!=null) {
                if(del==del.parent.right){
                    System.out.println(del.parent.right + " 1");
                    if (ll.indexOf(del.parent.right)!=-1) {
                        if (del.parent.right!=null) {
                            ll.push(del.parent.right);
                        }
                    }
                    del.parent.right = null;
                }else{
                    System.out.println(del.parent.left + " 2");
                    if (ll.indexOf(del.parent.left)!=-1) {
                        if (del.parent.left!=null) {
                            ll.push(del.parent.left);
                        }
                    }
                    del.parent.left = null;
                }
            }else {
                System.out.println(this.root + " 3");
                if (ll.indexOf(this.root)!=-1) {
                    if (this.root!=null) {
                        ll.push(this.root);
                    }
                }
                this.root = null;
            }
        }else if (del.left!=null && del.right==null) {
            if (del.parent!=null) {
                if (del==del.parent.right) {
                    System.out.println(del.parent.right);
                    if (ll.indexOf(del.parent.right)!=-1) {
                        if (del.parent.right!=null) {
                            ll.push(del.parent.right);
                        }
                    }
                    del.parent.right = del.left;
                }else {
                    System.out.println(del.parent.left);
                    if (ll.indexOf(del.parent.left)!=-1) {
                        if (del.parent.left!=null) {
                            ll.push(del.parent.left);
                        }
                    }
                    del.parent.left = del.left;
                }
                System.out.println(del.left.parent);
                del.left.parent = del.parent;
            }else {
                System.out.println(del.left);
                this.root = del.left;
            }
        }else if (del.left==null && del.right!=null) {
            if (del.parent!=null) {
                if (del==del.parent.right) {
                    System.out.println(del.parent.right);
                    del.parent.right = del.right;
                }else {
                    System.out.println(del.parent.left);
                    del.parent.left = del.right;
                }
                System.out.println(del.right.parent);
                del.right.parent = del.parent;
            }else {
                System.out.println(this.root);
                this.root = del.right;
            }
        }else if (del.left!=null && del.right!=null){
            Node node = successor(del);

            if (del.right!=node) {
                System.out.println(node);

                delete(node);
            }

            if (del.parent!=null) {
                if (del==del.parent.left) {
                    System.out.println(del.parent.left);

                    del.parent.left = node;
                }else {
                    System.out.println(del.parent.right);

                    del.parent.right = node;
                }
                System.out.println(node.parent);

                node.parent=del.parent;
            }else {
                System.out.println(this.root);

                this.root = node;
            }

            System.out.println(node.left);

            node.left = del.left;

            System.out.println(del.left.parent);

            del.left.parent = node;

            if (del.right!=node) {
                System.out.println(node.right);
                System.out.println(del.right.parent);

                node.right = del.right;
                del.right.parent = node;
            }else {
                System.out.println(node.right);

                node.right = null;
            }
        }

        return ll;
    }

    public Node ancestor(Node curr, T a, T b) {
        if (curr==null) {
            return null;
        }

        while (curr!=null) {
            if (curr.info.compareTo(a) < 0 && curr.info.compareTo(b) < 0) {
                curr = curr.right;
            }else if (curr.info.compareTo(a) > 0 && curr.info.compareTo(b) > 0) {
                curr = curr.left;
            }else {
                break;
            }
        }

        return curr;
    }

    public T ancestor(T a, T b) {
        Node result = ancestor(this.root,a, b);

        if (result==null) {
            return null;
        }else {
            return result.info;
        }
    }

}

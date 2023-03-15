import java.util.*;

public class wilson<T extends Comparable<T>> {

    private Node root;

    private class Node {
        T info;
        Node left, right, parent;

        Node(T info) {
            this.info = info;
        }

        @Override
        public String toString() {
            return "[" + this.info.toString() + "]";
        }
    }

    public void insert(T data) {
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;

        if (this.root == null) {
            this.root = newNode;
        } else {
            while (curr != null) {
                parent = curr;
                if (data.compareTo(curr.info) < 0) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            newNode.parent = parent;
            if (data.compareTo(parent.info) < 0) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    public T search(T x, T y) {
        Node result = search(x,y,this.root);
        if (result==null){
            return null;
        }else {
            return result.info;
        }
    }

    private Node search(T x, T y, Node curr) {
        if (curr == null) {
            return null;
        } else {
            if (curr.info.compareTo(x) > 0 && curr.info.compareTo(y) > 0) {
                return search(x, y, curr.left);
            } else if (curr.info.compareTo(x) < 0 && curr.info.compareTo(y) < 0) {
                return search(x, y, curr.right);
            } else {
                return curr;
            }
        }
    }

}

class Main {
    public static void main(String[] args) {

        wilson<Integer> bst = new wilson();
        Scanner userInput = new Scanner(System.in);

        int p = userInput.nextInt();
        for (int i = 0; i < p; i++) {
            bst.insert(userInput.nextInt());
        }

        int n = userInput.nextInt();
        while (n-- > 0) {

            int x = userInput.nextInt();
            int y = userInput.nextInt();

            System.out.println(bst.search(x, y));
        }

    }
}
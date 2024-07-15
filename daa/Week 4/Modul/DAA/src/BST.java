public class BST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(5);
        bst.insert(14);
        bst.insert(8);
        bst.insert(3);
        bst.insert(11);
        bst.insert(10);

        System.out.println(bst);

//        System.out.println(bst.search(10));
//        System.out.println(bst.search(3));
//        System.out.println(bst.search(12));

        System.out.println(bst.min());
        System.out.println(bst.max());
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

    private void delete(Node del) {
        if (del.left==null && del.right==null) {
            if(del.parent!=null) {
                if(del==del.parent.right){
                    del.parent.right = null;
                }else{
                    del.parent.left = null;
                }
            }else {
                this.root = null;
            }
        }else if (del.left!=null && del.right==null) {
            if (del.parent!=null) {
                if (del==del.parent.right) {
                    del.parent.right = del.left;
                }else {
                    del.parent.left = del.left;
                }

                del.left.parent = del.parent;
            }else {
                this.root = del.left;
            }
        }else if (del.left==null && del.right!=null) {
            if (del.parent!=null) {
                if (del==del.parent.right) {
                    del.parent.right = del.right;
                }else {
                    del.parent.left = del.right;
                }

                del.right.parent = del.parent;
            }else {
                this.root = del.right;
            }
        }else if (del.left!=null && del.right!=null){
            Node node = successor(del);

            if (del.right!=node) {
                delete(node);
            }

            if (del.parent!=null) {
                if (del==del.parent.left) {
                    del.parent.left = node;
                }else {
                    del.parent.right = node;
                }

                node.parent=del.parent;
            }else {
                this.root = node;
            }

            node.left = del.left;

            del.left.parent = node;

            if (del.right!=node) {
                node.right = del.right;
                del.right.parent = node;
            }else {
                node.right = null;
            }
        }
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

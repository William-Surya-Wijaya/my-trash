/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angelina123
 */
import java.util.Scanner;
public class Wombo<T extends Comparable<T>>{
    private Node root;

    private class Node{
        T info;
        Node left, right, parent;

        Node(T info) {
            this.info = info;
        }
        @Override
        public String toString(){
            return "[" + this.info.toString()+ "]";
        }
    }
    public void insert(T data){
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;

        if(this.root==null){
            this.root=newNode;
        }else{
            while(curr!=null){
                parent=curr;
                if(data.compareTo(curr.info)<0){
                    curr=curr.left;
                }else{
                    curr=curr.right;
                }
            }
            newNode.parent=parent;
            if(data.compareTo(parent.info)<0){
                parent.left=newNode;
            }else{
                parent.right=newNode;
            }
        }
    }
    public Node leluhur(Node node, T x, T y) {
        if(node == null) {
            return null;
        }else if (node.info.compareTo(x) > 0 && node.info.compareTo(y) > 0) {
            return leluhur(node.left,x,y);
        }else if (node.info.compareTo(x) < 0 && node.info.compareTo(y) < 0) {
            return leluhur(node.right,x,y);
        }else if (node.info.compareTo(x) > 0 && node.info.compareTo(y) < 0) {
            return node;
        }else if(node==x||node==y){
            return node;
        }

        return node;
    }
    public T leluhur(T x, T y) {
        Node result = leluhur(this.root,x, y);

        if (result==null) {
            return null;
        }else {
            return result.info;
        }
    }
}
class TesterBST{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Wombo<Integer> bst = new Wombo();
        int p = sc.nextInt();
        int simpan=0;
        for (int i = 0; i < p; i++) {
            int tes=sc.nextInt();
            if(i==0){
                simpan=tes;
            }
            bst.insert(tes);
        }
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.print(bst.leluhur( x, y));
        }
    }
}
//import java.util.Scanner;
//
//public class DisjointSets {
//    int[] parents;
//    int[] ranks;
//    int numOfElements;
//
//    DisjointSets(int numOfElements) {
//        this.numOfElements = numOfElements;
//        this.parents = new int[numOfElements];
//        this.ranks = new int[numOfElements];
//
//        int i;
//
//        for (i = 0; i < numOfElements; i++) {
//            this.parents[i] = i;
//            this.ranks[i] = 0;
//        }
//    }
//
//    public int findSets(int element) {
//        if (parents[element]==element) {
//            return element;
//        }else {
//            return findSets(parents[element]);
//        }
//    }
//
//    public void union(int element1, int element2) {
//        int root1 = this.findSets(element1);
//        int root2 = this.findSets(element2);
//
//        if (root1 == root2) {
//            return;
//        }
//
//        if (ranks[root1] > ranks[root2]) {
//            parents[root2] = root1;
//        }else if (ranks[root1] < ranks[root2]) {
//            parents[root1] = root2;
//        }else if (ranks[root1] == ranks[root2]) {
//            parents[root2] = root1;
//            ranks[root1] = ranks[root2] + 1;
//        }
//
//
//    }
//
//}
//
//class Tester {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        DisjointSets disjointSets = new DisjointSets(n);
//
//        int x = sc.nextInt();
//
//        for (int i = 0; i < x; i++) {
//            int a = sc.nextInt();
//            int b = sc.nextInt();
//
//            disjointSets.union(a,b);
//        }
//
//        int y = sc.nextInt();
//
//        for (int i = 0; i < y; i++) {
//            int cariTeman1 = sc.nextInt();
//            int cariTeman2 = sc.nextInt();
//
//            if (disjointSets.findSets(cariTeman1) == disjointSets.findSets(cariTeman2)) {
//                System.out.println("Sepertemanan");
//            }else {
//                System.out.println("Tidak sepertemanan");
//            }
//        }
//    }
//}
//

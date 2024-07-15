//import java.util.Scanner;
//
//public class MaxHeap {
//    private int maxHeap[];
//    private int heapSize;
//    private int length;
//
//    public MaxHeap (int length){
//        this.heapSize = 0;
//        this.length = length;
//        this.maxHeap = new int[length+1];
//    }
//
//    public MaxHeap (int [] arr){
//        this.heapSize = arr.length;
//        this.length = arr.length;
//        this.maxHeap = new int[length+1];
//        for (int i = 0; i < length; i++) {
//            this.maxHeap[i+1] = arr[i];
//        }
//    }
//
//    private int getLeft (int i){
//        return i<<1;
//    }
//
//    private int getRight (int i){
//        return (i<<1)|1;
//    }
//
//    private int getParent (int i){
//        return i>>1;
//    }
//
//    private void swap (int fi, int si){
//        int tmp = maxHeap[fi];
//        maxHeap[fi] = maxHeap[si];
//        maxHeap[si] = tmp;
//    }
//
//    //    private void maxHeapify (int i) {
////        int l = getLeft(i);
////        int r = getRight(i);
////        int largest = i;
////
////        if (l <= heapSize && maxHeap[l] > maxHeap[largest]){
////            largest = l;
////        }
////        if (r <= heapSize && maxHeap[r] > maxHeap[largest]){
////            largest = r;
////        }
////        if (largest != i){
////            swap (i,largest);
////            maxHeapify(largest);
////        }
////    }
//    public void maxHeapify(int i) {
//        int left = getLeft(i);
//        int right = getRight(i);
//        int largest = i;
//
//        if ((left <= heapSize) && (maxHeap[left] > maxHeap[largest])) {
//            largest = left;
//        }
//
//        if ((right <= heapSize) && (maxHeap[right] > maxHeap[largest])) {
//            largest = right;
//        }
//
//        if (largest != i) {
//            swap(i, largest);
//            maxHeapify(largest);
//        }
//    }
//
//    private void buildMaxHeap (){
//        for (int i = heapSize/2; i > 0; i--) {
//            maxHeapify(i);
//        }
//    }
//
//    public void insertKey(int key){
//        heapSize = heapSize + 1;
//        maxHeap[heapSize] = Integer.MIN_VALUE;
//        increaseKey(heapSize, key);
//    }
//
//    public boolean increaseKey(int i, int key){
//        if (key <= maxHeap[i]){
//            return false;
//        }else{
//            maxHeap[i] = key;
//            while(i > 1 && maxHeap[getParent(i)] < maxHeap[i]){
//                swap(getParent(i), i);
//                i = getParent(i);
//            }
//            return true;
//        }
//    }
//
//    public int extractMax (){
//        int max = maxHeap[1];
//        maxHeap[1] = maxHeap[heapSize];
//        heapSize = heapSize-1;
//        maxHeapify(1);
//        return max;
//    }
//
//    public void heapSort(){
//        buildMaxHeap();
//        for (int i = maxHeap.length; i > 1; i--) {
//            swap(1, i);
//            heapSize--;
//            maxHeapify(1);
//        }
//    }
//
//    public void print(){
//        for (int i = 0; i < maxHeap.length; i++) {
//            System.out.println(maxHeap[i]);
//        }
//    }
//}
//
//class Tester {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        MaxHeap max = new MaxHeap(n);
//        for (int i = 0; i < n; i++) {
//            max.insertKey(sc.nextInt());
//        }
//        max.heapSort();
//        max.print();
//    }
//}
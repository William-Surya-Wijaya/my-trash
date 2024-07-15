import java.util.Scanner;

//ide: melakkan sort setiap data dimaskan dan mencari nilai tengah lalu menjumlahkan setiap nilai tengah
public class M09 {
    private int[] arr;
    private int heapSize;
    private int length;

    public M09(int length) {
        this.heapSize = 0;
        this.arr = new int[length + 1];
        this.length = length;
    }

    public M09(int[] arr) {
        this.heapSize = arr.length;
        this.length = arr.length;
        this.arr = new int[length + 1];
        for (int i = 0; i < arr.length; i++) {
            this.arr[i + 1] = arr[i];
        }
    }

    public int getLeft(int i) {
        return i << 1;
    }

    public int getRight(int i) {
        return (i << 1) | 1;
    }

    public int getParent(int i) {
        return i >> 1;
    }

    // swap node
    private void swap(int des, int str) {
        int tmp;
        tmp = this.arr[des];
        this.arr[des] = this.arr[str];
        this.arr[str] = tmp;
    }

    private void heapify(int i) {
        int largest = i;//O(1)
        int l = getLeft(i);//O(1)
        int r = getRight(i);//O(1)

        if (l <= heapSize && this.arr[l] > this.arr[largest]) {
            largest = l;//O(1)
        }
        if (r <= heapSize && this.arr[r] > this.arr[largest]) {
            largest = r;//O(1)
        }
        if (largest != i) {
            swap(largest, i);//O(1)
            heapify(largest);//O(1)
        }
    }

    public void build_heap() {
        int cnt = this.heapSize / 2;//O(1)

        for (int i = cnt; i > 0; i--) {//O(log n)
            heapify(i);//O(1)
        }

    }

    public int[] getArr() {
        return this.arr;// O(1)
    }

    public int nilaiTengah() {
        // melakukan sort dengan heapsort
        this.sort();//O(log n)
        // mencari index tengah dari array
        int idxTengah = (this.length + 1) / 2;//O(1)
        // memasukan nlai tengah
        int res = this.arr[idxTengah];//O(1)
        // jika jumlah data genap maka tambahkan data tengah + 1 dan dibagi 2
        if (this.length % 2 == 0) {
            res += this.arr[idxTengah + 1];//O(1)
            res /= 2;//O(1)
        }
        return res;
        //perhitungan
        //T(n) = O(log n)+O(1)+O(1)+O(1)+O(1) = O(log n)
    }

    public void sort() {
        build_heap();//O(log n)
        for (int i = this.length; i > 1; i--) {//O(log n)
            swap(1, i);//O(1)
            this.heapSize--;//O(1)
            heapify(1);//O(log n)
        }
    }

    public void insertKey(int key) {
        heapSize++;// O(1)
        this.arr[heapSize] = Integer.MIN_VALUE;// O(1)
        this.increaseKey(heapSize, key);// O(log n)
        // perhitungan big O
        // T(n)=O(1)+O(1)+O(log n)
        // T(n)=O(log n)
    }

    public boolean increaseKey(int i, int key) {
        if (key <= this.arr[i]) {
            return false;// O(1)
        }
        this.arr[i] = key;// O(1)
        while (i != 1 && this.arr[i] > this.arr[getParent(i)]) {// O(log n)
            swap(i, getParent(i));// O(1)
            i = getParent(i);// O(1)
        }
        return true; // O(1)
        // perhitungan big O
        // T(n)=O(1)+O(log n)(O(1)+O(1))
        // T(n)=O(1)+O(log n)
        // T(n)=O(log n)
    }

    public void print() {
        for (int i = 0; i < this.arr.length; i++) {
            System.out.println(this.arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input jumlah kasus
        int jmlKasus = sc.nextInt();// O(1)
        int jmlNilai = 0;// O(1)
        int i = 0;// O(1)
        int res = 0;// O(1)
        M09 h = new M09(1);// O(1)
        while (jmlKasus > 0) {// O(n)
            if (i == 0) {
                jmlNilai = sc.nextInt();// O(1)
                res = 0;// O(1)
                h = new M09(1);// O(1)
            }

            int nilai = sc.nextInt();// O(1)
            h.increaseKey(1, nilai);// O(log n)
            // cari nilai tengah
            res += h.nilaiTengah();// O(log n)
            h = new M09(h.getArr());// O(1)
            i++;// O(1)
            if (i == jmlNilai) {
                System.out.println(res);// O(1)
                h.print();
                i = 0;// O(1)
                jmlKasus--;// O(1)
            }
        }
    }
}
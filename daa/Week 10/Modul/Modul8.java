import java.util.Scanner;
// agar mencegah looping dalam looping yang bisa menambah kompleksitas waktu, saya menggunakan looping hanya sekali saja.
// pertama-tama saya buat heap nya memiliki length 1 terlebih dahulu, baru kemudian setelah dilooping baru length nya
// akan bertambah seiring berjalannya looping dengan menggunakan method insert.

// penghitungan kompleksitas waktu : dikarenakan tidak ada looping dalam looping dan looping (kompleksitas looping = O(log n) dilakukan n kali, maka kompleksitas waktunya menjadi O(n log n)
// T(n) = O(n log n)

public class Modul8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); //masukkan berapa banyak test kasus
        MaxHeap maxHeap = new MaxHeap(1); //maxHeap dibuat sepanjang 1

        int counter = 0; //sudah berapa banyak test kasus yang selesai
        boolean cek = false; //untuk mengecek apakah ada masukkan penyimpan banyaknya nilai (n)
        int ctr = 0; //untuk mengecek sudah berapa kali dilakukan looping (ctr nilainya harus sampai n)
        int res = 0; //variabel hasil
        int n = 0; //untuk menyimpang banyaknya nilai

        while(counter < x) { //looping test kasus
            if (!cek) { //kalau pertama kali, maka akan disimpan nilai di variabel n terlebih dahulu
                n = sc.nextInt();
                cek = true; //diubah nilainya agar tidak tersimpan terus menerus
            }

            maxHeap.insertKey(sc.nextInt()); //masukkan ke dalam array maxHeap
            ctr++; //variabel ctr bertambah 1
            maxHeap = new MaxHeap(maxHeap.getMaxHeap()); //penyimpanan nilai ke dalam array MaxHeap agar bisa dilooping terus menerus
            res += maxHeap.median(); //variabel hasil ditambah nilai median
//            maxHeap.print();

            if (ctr == n) { //kalau sudah beres (sudah dilooping sebanyak n kali) maka semuanya akan direset untuk mengerjakan tes kasus selanjutnya dan juga dilakukan print hasil
                System.out.println(res);//print hasil

                ctr = 0; //reset ctr
                n = 0; //reset n
                cek = false; //reset cek
                res = 0; //reset res
                maxHeap.reset(); //reset class maxHeap

                counter++; //counter test kasus berlanjut
            }
        }
    }
}

class MaxHeap {
    private int maxHeap[];
    private int heapSize;
    private int length;

    public MaxHeap(int length) {
        this.heapSize = 0;
        this.length = length;
        this.maxHeap = new int[length + 1];
    }

    public void reset() {
        this.heapSize = 0;
        this.length = 1;
        this.maxHeap = new int[length + 1];
    }

    public MaxHeap(int[] arr) {
        this.heapSize = arr.length;
        this.length = arr.length;
        this.maxHeap = new int[length + 1];

        for (int i = 0; i < length; i++) {
            this.maxHeap[i + 1] = arr[i];
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

    public void maxHeapify(int i) {
        int left = getLeft(i);
        int right = getRight(i);
        int largest = i;

        if ((left <= heapSize) && (maxHeap[left] > maxHeap[largest])) {
            largest = left;
        }

        if ((right <= heapSize) && (maxHeap[right] > maxHeap[largest])) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    public void buildMaxHeap() {
        for (int i = heapSize / 2; i > 0; i--) {
            maxHeapify(i);
        }
    }

    public void insertKey(int key) {
        heapSize = heapSize + 1;
//        maxHeap[heapSize] = Integer.MIN_VALUE;

        increaseKey(1, key);
    }

    public boolean increaseKey(int i, int key) {
        if (key < maxHeap[i]) {
            return false;
        } else {
            maxHeap[i] = key;

            while ((i > 1) && (maxHeap[getParent(i)] < maxHeap[i])) {
                swap(getParent(i), i);
                i = getParent(i);
            }

            return true;
        }
    }

    public int extractMax() {
        int max = maxHeap[1];

        maxHeap[1] = heapSize - 1;
        heapSize = heapSize - 1;

        maxHeapify(1);

        return max;
    }

    public void swap(int i, int largest) {
        int temp = maxHeap[i];
        maxHeap[i] = maxHeap[largest];
        maxHeap[largest] = temp;
    }

    public void heapSort() {
        buildMaxHeap();

        for (int i = maxHeap.length - 1; i > 1; i--) {
            swap(1, i);
            heapSize--;
            maxHeapify(1);
        }
    }

    public void print() {
        for (int i = 0; i < maxHeap.length; i++) {
            System.out.println(maxHeap[i]);
        }
    }

    public int[] getMaxHeap() {
        return maxHeap;
    }

    public int median() {
        heapSort();

        int res = 0;

        if (length%2==0) {
            if (length==0) {
                res += maxHeap[length];
//                System.out.println(res + " " + maxHeap[length]);
            }else {
                int tmp = ((length+1)/2) + 1;
                res += maxHeap[tmp];
//                System.out.println(res + " " + maxHeap[tmp]);
            }
        }else {
            if (length==1) {
                int nilaiTengah = (maxHeap[length] + maxHeap[length-1]) / 2;
                res += nilaiTengah;
//                System.out.println(res + " " + nilaiTengah);
            }else {
                int tmp1 = ((length+1)/2);
                int tmp2 = tmp1 + 1;

                int nilaiTengah = (maxHeap[tmp1] + maxHeap[tmp2]) / 2;
                res += nilaiTengah;
//                System.out.println(res + " " + maxHeap[tmp1] + " " + maxHeap[tmp2] + " " + nilaiTengah);
            }
        }

//        System.out.println(res + " hasil");
        return res;
    }
}
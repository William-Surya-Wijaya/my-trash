import java.util.*;

// Dengan menggunakan priority queue, awalnya input semua dimasukkan
// terlebih dahulu ke dalam priority queue, lalu keluarkan 2 bilangan
// pertama dari priority queue (yang sudah pasti 2 bilangan terkecil)
// lalu jumlahkan. Hasil penjumlahan tersebut ditambahkan ke suatu
// variabel, dan hasil penjumlahan tersebut (bukan nilai variabel)
// dimasukkan kembali ke dalam priority queue. Proses ini dilakukan
// terus menerus hingga di dalam priority queue tinggal bersisa 1
// bilangan saja.

public class A10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        while(true) {
            int n = sc.nextInt();

            if (n==0) {
                return;
            }

            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();

                priorityQueue.add(input);
            }

            int res = 0;

            while(priorityQueue.size() > 1) {
                int temp1 = priorityQueue.poll();
                int temp2 = priorityQueue.poll();

                int resTemp = temp1 + temp2;

                priorityQueue.add(resTemp);

                res += resTemp;
            }

            System.out.println(res);
            priorityQueue = new PriorityQueue<>();

        }
    }
}

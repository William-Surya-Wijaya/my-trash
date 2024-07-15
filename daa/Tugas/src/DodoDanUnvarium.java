import java.util.*;

// Dengan menggunakan priority queue, awalnya input semua dimasukkan
// terlebih dahulu ke dalam priority queue, lalu keluarkan 2 bilangan
// pertama dari priority queue (yang sudah pasti 2 bilangan terkecil)
// lalu jumlahkan. Hasil penjumlahan tersebut ditambahkan ke suatu
// variabel, dan hasil penjumlahan tersebut (bukan nilai variabel)
// dimasukkan kembali ke dalam priority queue. Proses ini dilakukan
// terus menerus hingga di dalam priority queue tinggal bersisa 1
// bilangan saja. Sama seperti soal Dodo A10. Hanya semua bilangan
// bertipe int diganti ke long.

public class DodoDanUnvarium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while(true) { // dilakukan infinite looping
            int n = sc.nextInt(); //input masukkan

            if (n==0) { // bila masukkan = 0, maka akan keluar dari infinite looping
                return;
            }

            PriorityQueue<Long> priorityQueue = new PriorityQueue<>(); // buat priorityqueue

            for (int i = 0; i < n; i++) { // looping untuk memasukkan nilai ke dalam priorityqueue
                long input = sc.nextInt();

                priorityQueue.add(input); // dimasukkan ke dalam pq
            }

            long res = 0; // declare variabel res

            while(priorityQueue.size() > 1) { // looping hingga priority queue hanya bersisa 1
                long temp1 = priorityQueue.poll(); // keluarkan dua bilangan terdepan dari priority queue
                long temp2 = priorityQueue.poll(); // keluarkan dua bilangan terdepan dari priority queue

                long resTemp = temp1 + temp2; // tambahkan dua bilangan terkecil tersebut

                priorityQueue.add(resTemp); // masukkan kembali hasil penjumlahan tersebut

                res += resTemp; // hasil perjumlahan tersebut juga ditambahkan ke variabel res
            }

            System.out.println(res); // print hasil variabel res

        }

    }
}

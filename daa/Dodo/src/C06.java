import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class C06 {
    // Masukkan input ke dalam 3 variabel, n m dan l. Kemudian buat sebuah array berukuran 2
    // dimensi untuk menyimpan masukkan pasangan domino yang dapat jatuh. Buat juga sebuah
    // array 1d bertipe boolean untuk mencek apakah domino tersebut sudah jatuh atau belum. Kemudian
    // masukan pasangan domino yang dapat jatuh dimasukkan ke dalam ArrayList agar lebih mudah ketika
    // di sorting. ArrayList ini yang diberi nama urutan kemudian akan dilakukan sorting. Saat
    // pemasukkan angka ke dalam ArrayList, akan dicek terlebih dahulu apakah angka tersebut sudah
    // berada di dalam ArrayList atau belum, bila sudah maka tidak akan dimasukkan kembali tapi bila
    // belum ada, maka akan dimasukkan ke dalam ArrayList. Kemudian saat ada masukkan terakhir yaitu
    // angka awal domino jatuh, maka akan langsung dicari di dalam ArrayList tersebut di index ke
    // berapa ada angka tersebut yang kemudian akan dilakukan looping dari angka tersebut hingga
    // habis ArrayList nya dan akan dihitung ada berapa angka yang kemudian akan disimpan dalam
    // variabel ctr. Variabel ctr ini lah yang kemudian akan di print dan menjadi hasil akhir.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();

        int[][] array = new int[m][2];

        boolean[] domino = new boolean[n];

        for (int i = 0; i < n; i++) {
            domino[i] = true;
        }

        ArrayList<Integer> urutan = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (urutan.indexOf(x)==-1) {
                urutan.add(x);
            }

            if (urutan.indexOf(y)==-1) {
                urutan.add(y);
            }
        }

        Collections.sort(urutan);

        int ctr = 0;

        for (int i = 0; i < l; i++) {
            int awal = sc.nextInt();

            for (int j = urutan.indexOf(awal); j < urutan.size(); j++) {
                ctr++;
            }
        }

        System.out.println(ctr);
//        int ctr = 0;
//
//        for (int i = 0; i < l; i++) {
//            int awal = sc.nextInt();
//
////            for (int j = awal; j < n; j++) {
////
////            }
//
//            while(true) {
//                for (int k = 0; k < m; k++) {
//                    if (array[k][0]==awal) {
//                        domino[array[k][0]] = false;
//                        domino[array[k][1]] = false;
//
//                        awal = array[k][1];
//                        break;
//                    }
//                }
//            }
//
//        }
//
//        System.out.println(ctr);
    }
}
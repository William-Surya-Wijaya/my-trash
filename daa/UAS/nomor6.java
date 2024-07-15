import java.util.Scanner;

// Input dimasukkan ke dalam sebuah array berukuran 7 (dikarenakan index dimulai dari 1 sehingga perlu lebih 1),
// kemudian 1 per 1 index dicek. Untuk index pertama, pasti untuk monitor 6 x 6 sehingga angka di dalam array
// akan dikalikan dengan 36 (6 x 6). Untuk index kedua, pasti untuk monitor 5 x 5, sehingga angka di dalam
// array akan dikalikan dengan 25 (5 x 5). Begitu pula selanjut-selanjutnya, semua angka di dalam array akan
// dikalikan dengan 16 (4 x 4), 9 (3 x 3), 4 (2 x 2), dan 1 (1 x 1). Selanjutnya dari total penambahan semua itu,
// akan dibagi dengan 36 (karena kardus berukuran 6 x 6). Lalu bilangan tersebut akan dibulatkan keatas dengan
// menggunakan Math.ceil. Angka tersebut kemudian akan di output sebagai hasil.

public class nomor6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // masukkan test kasus

        int[] layar = new int[7]; // array untuk masukkan layar

        for (int a = 0; a < n; a++) { // looping untuk test kasus
            for (int i = 1; i < 7; i++) { // looping untuk masukkan monitor
                layar[i] = sc.nextInt(); // input dimasukkan ke dalam array
            }

            double counter = 0; // variabel counter

            for (int i = 1; i < 7; i++) { // looping untuk mengecek kembali

                if (i==1) { // bila dia index pertama maka akan dikali dengan 36 karena pasti monitor 6 x 6
                    counter += 36 * layar[i];
                }else if (i==2) { // bila dia index pertama maka akan dikali dengan 25 karena pasti monitor 5 x 5
                    counter += 25 * layar[i];
                }else if (i==3) { // bila dia index pertama maka akan dikali dengan 16 karena pasti monitor 4 x 4
                    counter += 16 * layar[i];
                }else if (i==4) { // bila dia index pertama maka akan dikali dengan 9 karena pasti monitor 3 x 3
                    counter += 9 * layar[i];
                }else if (i==5) { // bila dia index pertama maka akan dikali dengan 4 karena pasti monitor 2 x 2
                    counter += 4 * layar[i];
                }else if (i==6) { // bila dia index pertama maka akan dikali dengan 1 karena pasti monitor 1 x 1
                    counter += 1 * layar[i];
                }

            }

//            System.out.println(counter);

            counter /= 36; // jumlah penambahan tersebut akan dibagi dengan 36 karena kardus mempunyai ukuran fix yaitu 6 x 6 (36)

            System.out.println((int)Math.ceil(counter)); // setelah dibagi, maka akan dilakukan pembulatan ke atas dengan menggunakan Math.ceil (2.01 akan dibulatkan menjadi 3, tetapi 2.00 tidak akan dibulatkan menjadi 3)

        }
    }
}
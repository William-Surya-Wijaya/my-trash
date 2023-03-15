import java.util.HashMap;
import java.util.Scanner;

// Dilakukan looping terus menerus hingga ada angka 0 yang dimasukkan. untuk setiap tes kasus baru, akan ada 1 variabel yang akan tersimpan di pengunjung sebagai penanda ada berapa pengunjung.
// kemudian selanjutnya akan dilakukan masukan 5 kali (karena terdapat 5 nilai). Dari 5 nilai tersebut kemudian akan digabungkan menjadi 1 nilai agar mempermudah penyimpanan. Perlu dilakukan
// operasi baik tambah kurang kali bagi untuk menjadikan 1 nilai, dan setiap operasi yang dilakukan harus sama (apabila a * b, maka b harus * c, tidak boleh b + c, dan begitu seterusnya),
// maka saya memilih operasi kali agar tidak ada yang sama (a + b + c ada kemungkinan sama dengan a + c + d, tapi pasti berbeda apabila a * b * c dan a * c * d). Dalam proses penyimpanan,
// dicek terlebih dahulu, apakah masih bernilai null atau tidak, bila masih bernilai null maka akan dimasukkan 1 di valuenya, sedangkan bila sudah ada nilai sebelumnya,
// maka nilai dari yang sebelumnya ditambah 1 (value berfungsi sebagai penanda sudah ada berapa orang dengan kombinasi yang sama). Setelah itu semua berhasil dilakukan, maka selanjutnya
// akan dicek max kombinasi nya ada berapa. Bila ada beberapa kombinasi yang populer dengan nilai popularitas yang sama, maka nilai kombinasi nya akan bertambah tapi apabila ada nilai
// popularitas yang lebih tinggi dari nilai popularitas sebelumnya, maka kombinasi akan direset menjadi 1 kembali tapi max nya bertambah menjadi setinggi
// nilai popularitasnya (yang terdapat di dalam value map). Setelah berhasil mendapatkan max kombinasinya, maka tinggal di print apabila nilai counter sudah sama dengan pengunjung.
// Setelah dilakukan print, maka semua variabel yang digunakan sebelumnya di reset agar bisa dilanjutkan ke test kasus selanjutnya.

public class Map2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        int kombinasi = 0; //untuk kombinasi
        int max = 0; //untuk nilai max popularitas
        int counter = 0; //untuk penanda sudah di pengunjung ke berapa
        int pengunjung = 0; //nilai pengunjung dari soal

        while(true) { //dilakukan looping forever sampai pengunjung = 0
            if (counter==0) { //dalam setiap tes kasus baru, pertama-tama akan dilakukan masukkan pengunjung terlebih dahulu
                pengunjung = sc.nextInt();
            }

            if (pengunjung==0) { //bila nilai pengunjungnya = 0, maka akan break
                break;
            }

            int input1 = sc.nextInt(); //input pertama
            int input2 = sc.nextInt(); //input kedua
            int input3 = sc.nextInt(); //input ketiga
            int input4 = sc.nextInt(); //input keempat
            int input5 = sc.nextInt(); //input kelima

            int inputTemp = input1 * input2 * input3 * input4 * input5; //untuk menghasilkan nilai key baru dengan meng kali kan semua nilai input

            if (map.get(inputTemp) != null) { //dicek apabila belum ada nilai apapun di dalamnya, maka nilai yang akan dimasukkan adalah 1, tetapi bila sudah ada nilai di dalam map dengan key dari sebelumnya, maka value dari key nya akan ditambah 1
                int temp = map.get(inputTemp);
                temp += 1;

                map.put(inputTemp, temp);
            }else {
                map.put(inputTemp, 1);
            }

            int temp = map.get(inputTemp); //diambil value dari map dengan key inputTemp

            if (max==temp) { //dicek apabila nilai max nya lebih kecil dari value, maka kombinasi akan direset kembali menjadi 1 dan nilai max akan berubah menjadi sama dengan value, tetapi apabila max nya sama dengan value, maka kombinasi nya akan ditambah karena membuktikan ada kombinasi baru dengan popularitas yang sama
                kombinasi++;
            }else if (max < temp) {
                kombinasi = 1;
                max = temp;
            }

            counter++; //untuk menambah counter

//            System.out.println(max + " " + kombinasi);

            if (counter==pengunjung) { //bila nilai counter sudah sama dengan pengunjung (membuktikan bahwa test kasus sudah berakhir), maka akan dilakukan print max kombinasi dan dilakukan reset value dari setiap variabel yang akan digunakan kembali dalam test kasus selanjutnya (map nya juga akan direset)
                max *= kombinasi;
                System.out.println(max);

                kombinasi = 0;
                counter = 0;
                max = 0;

                map = new HashMap<>();
            }

//            System.out.println(res);
        }
    }
}

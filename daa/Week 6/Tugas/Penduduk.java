import java.util.Hashtable;
import java.util.Scanner;

//Dengan menggunakan rumus dari ppt (slide terakhir)
class Penduduk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 70000; //maximal input
        int m = 141767; //bilangan m

        while(sc.hasNext()) { //looping menggunakan hasnext
            String nama = sc.nextLine(); //masukkan nama menggunakan nextline karena mengandung spasi
            int value = sc.nextInt(); //masukkan pin menggunakan nextInt
            sc.nextLine();

            int total = hashFunction(nama,m, value); //penghitungan string to integer

            System.out.println(total);

        }

    }

    // rumus dasarnya sama dengan rumus yang ada di ppt, yaitu ABC26 tapi ada modifikasi sedikit yaitu
    // base diganti dari 26 ke 256 karena string bisa mengandung titik, koma, spasi, dll
    // cara yang saya gunakan adalah untuk mencegah terjadinya overflow sehingga memang agak rumit
    protected static int hashFunction(String key, int m, int value) {
        int total = 0;
        int ctr = 0;
//
        for (int i = key.length()-1; i >= 0; i--) {
            int ascii = key.charAt(0);

            int pangkat = 1;

            if (ctr==0) {
                pangkat = 1;
            }else {
                for (int j = 1; j <= ctr; j++) {
                    pangkat *= 256;
                }
            }

            total += Math.floor(Math.floor(ascii % m * pangkat % m) % m);

            total %= m;

            ctr++;

//            total += ascii;
        }

//        int res = (total + value) * (total + value + 1) + value;
//
        total += value;
//        total %= m;


        return total;
    }
}

import java.util.Scanner;

// Masukkan berupa 2 bilangan n dan m. Kemudian akan dilooping sebanyak n
// kali untuk masukan ketiga, dari masukan ketiga tersebut yang berupa String,
// karakter pertama akan diubah ke ASCII dan dikurangi dengan 65 agar sama
// dengan ketentuan soal (A = 0, dst), kemudian panggil 3 character terakhir
// dan diubah ke dalam integer sehingga bisa langsung dihitung dan hasilnya di
// mod dengan bilangan m dan akan di output.
public class D11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();

            int charTerakhir = Integer.parseInt(input.substring(input.length()-3, input.length()));
            int charAwal = input.charAt(0);
            charAwal -= 65;

            int res = (charAwal + charTerakhir) % m;

            System.out.println(res);
//            System.out.println(charAwal + " " + charTerakhir + " " + res);
        }

    }
}

import java.io.FileReader;
import java.util.Scanner;

// Dengan menggunakan method hashFunction dan rumus yang pernah diajari di slide,
// saya berhasil mendapatkan hash valuenya, kemudian setelah mendapatkan nilai hash valuenya,
// saya samakan dengan input yang didapat dari soal, bila sama, maka output utuh, bila tidak maka
// output rusak.
public class UTS3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int hash = sc.nextInt();
            String input = sc.next();

            int temp = hashFunction(input);

            if (temp==hash) {
                System.out.println("utuh");
            }else {
                System.out.println("rusak");
            }
        }
    }

    protected static int hashFunction(String key) {
        int l = key.length() - 1;
        int total = 0;

        int idx = 0;

        int temp = -1;

        for (int i : l) {
            int ascii = key.charAt(i);
            total += (ascii * Math.pow(256,idx)) % 7121;
            idx += 1;
//            total += ascii;
//            System.out.println(ascii + " " + key.charAt(i));
        }

//        System.out.println(total);
        total %= 7121;
//        System.out.println(total);
        return total;
    }
}

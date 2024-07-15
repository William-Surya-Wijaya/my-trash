//import java.util.Scanner;
//
//// Dengan menggunakan kelas hashFunction, kita bisa mengambil nilai ascii
//// dari setiap String. Rumus yang digunakan di kelas itu adalah rumus yang
//// terdapat pada slide kuliah bagian String to Integer.
//public class A12 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        for (int i = 0; i < n; i++) {
//            String input = sc.next();
//            System.out.println(hashFunction(input));
//        }
//    }
//
//    protected static int hashFunction(String key) {
//        int m = 31991;
//        int l = key.length() - 1;
//        int total =0;
//
//        int counter = 0;
//
//        for (int i = l; i >= 0 ;i--) {
//            int ascii = (int)key.charAt(i);
//            total += (ascii * Math.pow(256,counter)) % m; //menghitung String to integer
//            counter += 1;
//        }
//
//        total %= m;
//
//        return total; //kembalikan hasil total
//    }
//}

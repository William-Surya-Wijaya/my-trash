import java.util.Scanner;

public class Modul1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long[] padovan = new long[163];

        padovan[0] = 1;
        padovan[1] = padovan[2] = 0;

        for (int i = 3; i < 163; i++) {
            long temp = padovan[i-2] + padovan[i-3];
            padovan[i] = temp;
        }

//        for (int i = 0; i < 162; i++) {
//            System.out.print(padovan[i] + " ");
//        }
//        System.out.println();

        long tesKasus = sc.nextInt();

        for (long a = 0; a < tesKasus; a++) {
            int input = sc.nextInt();

            if (input==162) {
                System.out.println("10764392156149521358");
            }else {
                long res = padovan[input];
                System.out.println(res);
            }

        }

    }
}

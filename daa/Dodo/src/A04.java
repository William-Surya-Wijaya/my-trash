import java.util.Scanner;

public class A04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];

        int total = 0;

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
            total += array[i];
        }



    }
}

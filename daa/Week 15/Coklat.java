
import java.util.Scanner;

public class Coklat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int temp = 0;
        for (int i = 0; i < tc; i++) {
            temp += sc.nextInt();
        }

        if (temp%2==0) {
            System.out.println("coklat dapat dibagi sama rata");
        }else if (temp%2==1) {
            System.out.println("coklat tidak dapat dibagi 2");
        }
    }
}

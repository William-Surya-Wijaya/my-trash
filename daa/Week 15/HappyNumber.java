import java.util.Scanner;

public class HappyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 1; i <= tc; i++) {
            int n = sc.nextInt();
            int temp;
            if (n > 10) {
                String tempr = Integer.toString(n);
                int tempor2 = 0;

                for (int j = 0; j < tempr.length(); j++) {
                    int temp4 = Integer.parseInt(tempr.substring(j, j + 1));
                    tempor2 += (int) Math.pow(temp4, 2);
                }
                temp = tempor2;
            } else {
                temp = n * n;
            }
            while (true) {
                if (temp < 10) {
                    break;
                }

                String temp2 = Integer.toString(temp);
                int temp3 = 0;

                for (int j = 0; j < temp2.length(); j++) {
                    int temp4 = Integer.parseInt(temp2.substring(j, j + 1));
                    temp3 += (int) Math.pow(temp4, 2);
                }
                temp = temp3;
            }
            System.out.print("Case #" + i + ": ");
            if (temp == 1) {
                System.out.print(n + " is a Happy number.");
            } else {
                System.out.print(n + " is an Unhappy number.");
            }
            System.out.println();
        }
    }
}

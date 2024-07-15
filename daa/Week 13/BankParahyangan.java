import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BankParahyangan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();
        boolean loket = false;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String input = sc.next();

            if (input.equals("SELESAI")) {
                if (queue.isEmpty()) {
                    System.out.println("Loket istirahat.");
                    loket = false;
                }else {
                    System.out.println(queue.poll() + " dilayani di loket.");
                    loket = true;
                }
            }else {
                if (loket==false) {
                    System.out.println(input + " langsung dilayani di loket.");
                    loket = true;
                }else {
                    System.out.println(input + " mengantri dahulu.");
                    queue.offer(input);
                }
            }
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        Queue<String> queue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            String nama = sc.next();

            queue.offer(nama);
        }

        while(true) {
            if (queue.size()==1) {
                System.out.println(queue.poll());
                break;
            }

            for (int i = 0; i < n-1; i++) {
                String temp = queue.poll();
                queue.offer(temp);
            }

            queue.poll();
        }

    }
}

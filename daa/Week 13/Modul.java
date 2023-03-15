import java.util.LinkedList;
import java.util.Scanner;

public class Modul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int panjangJalan = sc.nextInt();
        int jarakTempuh = sc.nextInt();

        int n = sc.nextInt();

        int[] pomBensin = new int[n];

        for (int i = 0; i < n; i++) {
            pomBensin[i] = sc.nextInt();
        }

        int curr = 0;
        int max = jarakTempuh;

        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 0; i < n - 1; i++) {
            if(curr <= panjangJalan) {
                int temp = 0;
                int tempIdx = 0;

                for (int j = 0; j < n; j++) {
                    if (pomBensin[j] <= max) {
                        if (temp < pomBensin[j]) {
                            temp = pomBensin[j];
                            tempIdx = j + 1;
                        }
                    }
                }

                ll.offer(tempIdx);

                curr = temp;
                max = temp + jarakTempuh;

                if (curr==pomBensin[n-1]) {
                    int selisih = panjangJalan - curr;

                    if (selisih > jarakTempuh) {
                        System.out.println("-1");
                    }else {
                        System.out.println(ll.size());

                        while(!ll.isEmpty()) {
                            System.out.println(ll.poll());
                        }
                    }

                    break;
                }

            }
        }
    }
}


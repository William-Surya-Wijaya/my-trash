import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PengukurBaju {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Double> queue1 = new LinkedList<>();
        Queue<Double> queue2 = new LinkedList<>();

        PriorityQueue<Double> temp = new PriorityQueue<>();

        double[][] arrTemp = new double[2][1001];

        int counter = 0;
        double res = 0;

        while(true) {
            double tinggi = sc.nextDouble();
            double berat = sc.nextDouble();

            arrTemp[0][counter] = tinggi;
            arrTemp[1][counter] = berat;

            counter++;

            int tempTinggi = (int)tinggi;
            int tempBerat = (int)berat;

            if (tempTinggi==-1 && tempBerat==-1) {
                for (int i = 0; i < 1001; i++) {
                    if (queue2.isEmpty()==false) {
                        if (arrTemp[1][i]==queue2.peek()) {
                            res += arrTemp[0][i];
                            queue2.poll();
                        }
                    }else {
                        break;
                    }
                }
                res /= n;

                System.out.printf("%.2f", res);
                break;
            }

            if (queue1.size()==n) {
                double tempQ = queue2.poll();

                if (berat < tempQ) {
                    queue2.offer(berat);

                    while(queue2.isEmpty()==false) {
                        temp.offer(queue2.poll());
                    }

                    while(temp.isEmpty()==false) {
                        queue2.offer(temp.poll());
                    }
                }else {
                    queue2.offer(tempQ);
                }
            }else {
                queue1.offer(tinggi);
                queue2.offer(berat);

                while(queue2.isEmpty()==false) {
                    temp.offer(queue2.poll());
                }

                while(temp.isEmpty()==false) {
                    queue2.offer(temp.poll());
                }
            }
        }
    }
}

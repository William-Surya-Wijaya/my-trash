import java.util.LinkedList;
import java.util.Scanner;

// Dengan menggunakan linkedlist sebagai penyimpang hasil, cara penghitungan saya adalah dengan menggunakan array sebagai penanda apakah garis sudah terpenuhi atau belum, apabila sudah terpenuhi maka akan berubah menjadi 1, kalau belom 0

public class nomor6garis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();

        LinkedList<String> res = new LinkedList<>();

        int[] temp = new int[m+1];

        for (int i = 0; i < m+1; i++) {
            temp[i] = 0;
        }

        while(true) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (l==0 && r==0) {
                break;
            }

            if (l < 0) {
                if (r > 0) {
                    for (int i = 0; i <= r; i++) {
                        temp[i] = 1;
                    }

                    String tempRes = l + " " + r;
                    res.offer(tempRes);
                }else {
                    break;
                }
            }else {
                if (r > m) {
                    int tempp = (r - l) - (r - m);

                    for (int i = l-1; i < l + tempp; i++) {
                        temp[i] = 1;
                    }

                    String tempRes = l + " " + r;
                    res.offer(tempRes);
                }
            }

//            for (int i = 0; i < m; i++) {
//                System.out.println(temp[i]);
//            }

        }

        boolean cek = true;

        for (int i = 0; i < m; i++) {
            if (temp[i]==0) {
                cek = false;
                break;
            }
        }

        if (!cek) {
            System.out.println("0");
        }else {
            System.out.println(res.size());

            int size = res.size();

            for (int i = 0; i < size; i++) {
                System.out.println(res.poll());
            }
        }

    }
}

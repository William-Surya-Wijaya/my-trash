import java.util.LinkedList;
import java.util.Scanner;

// Dengan menggunakan algoritma LIS dari ppt, saya menggunakan algoritma tersebut
// untuk mencari ada berapa kombinasi yang bisa didapatkan dari Array jembatan
// tersebut, kemudian saya cari barisan terpanjangnya, semisal 3 1 2 5 4, maka
// bisa ada 2 barisan terpanjang menaik nya, yaitu 1 2 5 dan 1 2 4

public class JembatanPerdamaian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] wombat = new int[n];
        int[] dodo = new int[n];

        for (int i = 0; i < n; i++) {
            wombat[i] = sc.nextInt();
            dodo[i] = i + 1;
        }

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = 1;
        }

        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (temp[i] < 1 + temp[j] && wombat[i] > wombat[j]) {
                    temp[i] = 1 + temp[j];
                    prev[i] = j;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            if (max < temp[i]) {
                max = temp[i];
            }
        }

        System.out.println(max);

        LinkedList<Integer> llmax = new LinkedList<>();
        LinkedList<Integer> lltemp = new LinkedList<>();
        
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < n-1; j++) {
                if (wombat[j] < wombat[j+1]) {
                    if (j==0) {
                        lltemp.offer(wombat[j]);
                        lltemp.offer(wombat[j+1]);
                    }else {
                        lltemp.offer(wombat[j+1]);
                    }

                }else {
                    continue;
                }
            }

            System.out.println(lltemp);
        }
        
    }
}

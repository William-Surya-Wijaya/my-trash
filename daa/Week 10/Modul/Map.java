import java.util.Scanner;
import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        while(true) {
            int pengunjung = sc.nextInt();

            if (pengunjung==0) {
                break;
            }

            int cek = 0;
            int res = 1;

            for (int i = 0; i < pengunjung; i++) {
                for (int j = 0; j < 5; j++) {
                    int input = sc.nextInt();

                    if (map.put(input,1)!=null) {
                        cek++;
                    }
                }

                if (i>0) {
                    if (cek==5) {
                        res++;
                    }
                }

                cek = 0;
            }

            System.out.println(res);
        }
    }
}

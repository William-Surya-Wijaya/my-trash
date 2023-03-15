//6182001028 - Andrianho Fernando
import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String nama[] = new String[n];

        for (int i = 0; i < n; i++) {
            nama[i] = sc.next();
        }
        int m = sc.nextInt();
        String check[] = new String[m];
        for (int i = 0; i < m; i++) {
            check[i] = sc.next();
        }
        BinarySearch search = new BinarySearch();
        for (int i = 0; i < m; i++) {
            System.out.println(search.binarySearch(nama, check[i]));
        }

    }
}

class BinarySearch {
    public int binarySearch(String nama[], String x) {
        int left = 0;
        int right = nama.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nama[mid].equalsIgnoreCase(x))
                return mid;
            else if (nama[mid].compareToIgnoreCase(x) > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
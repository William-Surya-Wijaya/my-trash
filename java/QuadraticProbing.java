import java.util.*;

public class QuadraticProbing {
    static Integer[] table;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int con1 = scanner.nextInt();
        int con2 = scanner.nextInt();

        int tableSize = scanner.nextInt();
        int dataCount = scanner.nextInt();
        table = new Integer[tableSize];

        int[] input = new int[dataCount];
        for (int i = 0; i < dataCount; i++) {
            input[i] = scanner.nextInt();
        }

        for (int num : input) {
            insert(num, con1, con2, tableSize);
        }
    }

    public static void insert(int input, int con1, int con2, int tableSize) {
        int initialHash = input % tableSize;
        initialHash = (initialHash + tableSize) % tableSize;
        
        for (int j = 0; j < tableSize; j++) {
            int probeIndex = (initialHash + con1 * j + con2 * j * j) % tableSize;
            probeIndex = (probeIndex + tableSize) % tableSize;

            if (table[probeIndex] == null) {
                table[probeIndex] = input;
                System.out.println(j+1);
                return;
            }
        }
        System.out.println("-1");
    }
}

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();;

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();

        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < l; i++) {
            int input = sc.nextInt();
            arrayList.add(input);
            temp1.add(input);
        }

        for (int i = 0; i < l; i++) {
            int input = sc.nextInt();
            arrayList2.add(input);
            temp2.add(input);
        }

        Collections.sort(temp1);
        Collections.sort(temp2);

        for (int i = 0; i < l; i++) {
            int temp = arrayList.get(i);
            int idx = temp1.indexOf(temp);
            System.out.println(temp2.get(idx));
        }

    }
}

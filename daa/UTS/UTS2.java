import java.util.Scanner;

public class UTS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
//        int maxKali = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i!=j) {
//                    int temp = array[i] * array[j];
//                    if (temp>maxKali) {
//                        maxKali = temp;
//                    }
//                }
//            }
//        }
//        System.out.println(maxKali);

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int idx1 = -1;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int idx2 = -1;

        for (int i = 0; i < n; i++) {
            if (max1<array[i]) {
                max1 = array[i];
                idx1 = i;
            }
            if (min1>array[i]) {
                min1 = array[i];
                idx2 = i;
            }
        }
        array[idx1]=101;
        array[idx2]=101;
        for (int i = 0; i < n; i++) {
            if (array[i]!=101) {
                if (max2<array[i]) {
                    max2 = array[i];
                }
                if (min2>array[i]) {
                    min2 = array[i];
                }
            }
        }
        int temp1 = max1*max2;
        int temp2 = min1*min2;
        if (temp1 > temp2) {
            System.out.println(temp1);
        }else {
            System.out.println(temp2);
        }
    }
}

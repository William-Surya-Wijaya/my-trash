import java.util.Arrays;
import java.util.Scanner;

public class UTS1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] array = new String[3][n];
        int idx = 0;
        for (int a = 0; a < n; a++) {
            int p = sc.nextInt();
            int t = sc.nextInt();
            String judul = sc.next();

            array[0][idx] = judul;
            array[1][idx] = Integer.toString(p);
            array[2][idx] = Integer.toString(t);

            idx++;
        }
//        Arrays.sort(array);


        bubbleSort(array, n);

        for (int i = 0; i < n; i++) {
            System.out.println(array[0][i]);
//            System.out.print(" " + array[1][i]);
//            System.out.println(" " + array[2][i]);
        }
    }

    public static void bubbleSort(String array[][], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int p = Integer.parseInt(array[1][j]);
                int t = Integer.parseInt(array[2][j]);

                if (p < Integer.parseInt(array[1][j+1])) {
                    String temp = array[1][j];
                    array[1][j] = array[1][j+1];
                    array[1][j+1] = temp;

                    String temp2 = array[0][j];
                    array[0][j] = array[0][j+1];
                    array[0][j+1] = temp2;

                    String temp3 = array[2][j];
                    array[2][j] = array[2][j+1];
                    array[2][j+1] = temp3;
                }else if (p == Integer.parseInt(array[1][j+1])) {
                    if (t < Integer.parseInt(array[2][j+1])) {
                        String temp = array[1][j];
                        array[1][j] = array[1][j+1];
                        array[1][j+1] = temp;

                        String temp2 = array[0][j];
                        array[0][j] = array[0][j+1];
                        array[0][j+1] = temp2;

                        String temp3 = array[2][j];
                        array[2][j] = array[2][j+1];
                        array[2][j+1] = temp3;
                    }else if (t == Integer.parseInt(array[2][j+1])) {
                        int panjang1 = array[0][j].length();
                        int panjang2 = array[0][j+1].length();

                        int panjang;

                        if (panjang1 < panjang2) {
                            panjang = panjang1;
                        }else {
                            panjang = panjang2;
                        }

                        for (int k = 0; k < panjang; k++) {
                            if (array[0][j].charAt(k)==array[0][j+1].charAt(k)) {
                                continue;
                            }else {
                                int abjad1 = array[0][j].charAt(k);
                                int abjad2 = array[0][j+1].charAt(k);

                                if (abjad1 > abjad2) {
                                    String temp = array[1][j];
                                    array[1][j] = array[1][j+1];
                                    array[1][j+1] = temp;

                                    String temp2 = array[0][j];
                                    array[0][j] = array[0][j+1];
                                    array[0][j+1] = temp2;

                                    String temp3 = array[2][j];
                                    array[2][j] = array[2][j+1];
                                    array[2][j+1] = temp3;
                                }

                                break;
                            }
                        }


                    }
                }
            }
        }
    }

}

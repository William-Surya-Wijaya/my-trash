import java.util.Scanner;

public class pendapatan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 70000; //banyak data
        int m = 141767; //ukuran

        for (int i = 0; i < n; i++) {
            String a = sc.nextLine(); //nama
            int b = Integer.parseInt(sc.nextLine()); //pin

            System.out.println(hashFunction(a,b,m));
        }
    }

    public static int hashFunction(String a,int b,int m) {
        int l = a.length()-1;
        int total =0;

        for (int i = l; i >=0 ; i--) {
            int ascii = (int)a.charAt(0);
            total += Math.floor(Math.floor((ascii*Math.pow(256,i))/(b+1))/5)%m; //menghitung String to integer
        }

        total %= m;

        return total; //kembalikan hasil total
    }
}
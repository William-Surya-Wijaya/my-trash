import java.util.Scanner;

public class Modul2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tesKasus = sc.nextInt();

        for (int a = 0; a < tesKasus; a++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            long[][][] array3d = new long[16][16][16];

            long res = rek(array3d, x, y, z);

            System.out.println(res);
        }
    }

    public static long rek(long[][][] array3d, int x, int y, int z) {
        if (array3d[x][y][z]==0) {
            if (x==0) {
                return array3d[x][y][z] = y + 1;
            }else if (y==0) {
                return array3d[x][y][z] = rek(array3d,x-1, 1, z);
            }else if (z==0) {
                return array3d[x][y][z] = rek(array3d,x-1, y-1, 1);
            }else {
                return array3d[x][y][z] = rek(array3d,x-1, y, z) + rek(array3d, x, y-1, z) + rek(array3d,x ,y, z-1);
            }
        }else {
            return array3d[x][y][z];
        }
    }
}

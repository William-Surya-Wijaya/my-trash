import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author ELAINE
 */
// ide dasar: masukkan data pilihan ke hashmap
// filter hashmap dan cari popularitas kombinasi pilihan menu
// terbanyak dan cari pemenang
public class MenuBerhadiah {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);// O(1)
        int n = sc.nextInt();// O(1)
        // inisialisasi hashmap list
        HashMap<Integer, Integer> h = new HashMap<>();// O(1)

        // inisialisasi max
        int maxPop = 0;// O(1)
        int jmlPemenang=0;// O(1)
        // selama kasus tidak 0, input dimasukkan ke dalam hashmap
        while (n > 0) {// O(n)
            int nilai1=sc.nextInt();// O(1)
            int nilai2=sc.nextInt();// O(1)
            int nilai3=sc.nextInt();// O(1)
            int nilai4=sc.nextInt();// O(1)
            int nilai5=sc.nextInt();// O(1)
            //combine hash
            int hashing=nilai1*nilai2*nilai3*nilai4*nilai5;// O(1)
            // memasukan list kombinasi yang sudah di urutkan pada hash map
            // mencari data yang sama
            if (h.containsKey(hashing)) {
                h.put(hashing, h.get(hashing) + 1);// O(1)
            } else {
                h.put(hashing, 1);// O(1)
            }
            //hitung maximum popularitas
            if (maxPop < h.get(hashing)) {
                maxPop = h.get(hashing);// O(1)
                jmlPemenang=1;//O(1)
            }else{
                if(maxPop==h.get(hashing))
                    jmlPemenang++;//O(1)
            }

            n--;
            // mencari pemenang dengan kombinasi popularitas yang sama
            // popularitas terbanyak
            if (n == 0) {
                System.out.println(jmlPemenang + " " + maxPop);
                int res = jmlPemenang * maxPop; // O(1)
                System.out.println(res); // O(1)
                maxPop = 0;// O(1)
                jmlPemenang=0;//O(1)
                h=new HashMap();// O(1)

                n = sc.nextInt();// O(1)
            }
        }

    }
}
/*
 * PERHITUNGAN
 * T(n)=O(1)+O(1)+O(1)+O(1)+O(1)+O(n)(O(1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(
 * 1)+O(1)+O(1)+O(1)+O(1)+O(1)+O(1))
 * T(n)=O(n)
 */
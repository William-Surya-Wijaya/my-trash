import java.util.*;

// Dengan menggunakan hashmap, dimasukkan key nya berupa kata-kata dari
// tulisan, dan value nya berupa ada berapa banyaknya kata tersebut dalam
// tulisan. Semua masukkan akan sudah di lowercase terlebih dahulu. Kemudian
// untuk tulisan kedua, akan menggunakan cara yang sama, tetapi hanya untuk
// tulisan-tulisan yang terdapat di dalam kedua tulisan dengan cara
// membandingkan hashmap. Apabila di hashmap pertama tidak terdapat kata
// tersebut, maka kata tersebut tidak akan dimasukkan ke dalam hashmap kedua.
// Kemudian setelah proses memasukkan, akan ada proses perbandingan. Bila di
// dalam paragraf 1 terdapat 2 kata tetapi di paragraf 2 terdapat 3 kata,
// maka nilai yang akan diambil sebagai nilai max hanya yang 2. Kemudian
// nilai max tersebut akan dibandingkan terus menerus untuk kata yang lain,
// dan nantinya kata terbanyak yang muncul di kedua tulisan, itulah hasilnya.

public class A28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        int max = 0;
        String res = "";

        for (int i = 0; i < n1; i++) {
            String input = sc.next();
            input.toLowerCase();

            if (hashMap.isEmpty()) {
                hashMap.put(input, 1);
            }else {
                if (hashMap.get(input) == null) {
                    hashMap.put(input, 1);
                }else {
                    int value = hashMap.get(input);
                    value += 1;
                    hashMap.put(input, value);
                }
            }
        }

        for (int i = 0; i < n2; i++) {
            String input = sc.next();
            input.toLowerCase();

            if (hashMap.get(input) != null) {
                if (hashMap2.get(input) == null) {
                    hashMap2.put(input, 1);
                }else {
                    int value = hashMap2.get(input);
                    value += 1;

                    int hm1 = hashMap.get(input);
                    int hm2 = hashMap2.get(input);

                    if (hm1 < hm2) {
                        if (hm1 > max) {
                            max = hm1;
                            res = input;
                        }
                    }else if (hm1 > hm2) {
                        if (hm2 > max) {
                            max = hm2;
                            res = input;
                        }
                    }else {
                        if (hm2 > max) {
                            max = hm2;
                            res = input;
                        }
                    }

                    hashMap2.put(input, value);
                }
            }

        }

        if (res=="") {
            System.out.println("tidak ada kata yang sama");
        }else {
            System.out.println(res);
        }

    }
}

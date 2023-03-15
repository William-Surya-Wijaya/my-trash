import java.util.Scanner;

// Dengan menggunakan kelas DisjointSet dari modul, saya panggil ke dalam method main. Setelah itu saya
// gunakan method union untuk menggabungkan masukan. Setelah itu saya gunakan method findset untuk mencari
// relasi dari dari angka yang dicari. Method findset akan mengeluarkan angka paling kecil atau paling
// depan dari kumpulan angka-angka tersebut (kelompok). Sehingga akan bila ada hubungan, maka akan terlihat
// dari keluaran nya (apakah sama atau tidak). Keluaran dari method findset ini akan saya gunakan sebagai
// penambah counter di dalam array (misal keluaran findset adalah 1, maka di array[0] akan ditambah 1,
// begitu seterusnya. Kemudian di akhir akan ada looping untuk mengecek, apakah array[0] bernilai diatas
// 0 atau tidak, bila 0, maka tidak akan di print indexnya, bila ada diatas 0 (1 dan selebihnya), maka
// akan ditambahkan ke dalam variabel counter yang akan di print sebagai hasil akhir.

public class Tugas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); // masukan pertama
        int n = sc.nextInt(); // masukan kedua sebagai penanda ada berapa banyak bilangan yang akan di union

        DisjointSets disjointSets = new DisjointSets(x);

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(); // masukan pertama yang akan di union
            int b = sc.nextInt(); // masukan kedua yang akan di union

            disjointSets.union(a-1,b-1); //dilakukan union
        }

        int[] temp = new int[x]; // array sebagai counter

        for (int i = 0; i < x; i++) {
            int friends = disjointSets.findSets(i); // memanggil method findset dan hasilnya akan disimpan
                                                    // di dalam variabel friends. Setelah itu akan
                                                    // dilakukan penambahan 1 terhadap array di index
                                                    // friends (array[friends] ditambah 1).

            temp[friends] += 1;
        }

        int counter = 0;

        for (int i = 0; i < x; i++) {   // looping terakhir untuk mengecek apakah array tersebut bernilai
                                        // diatas 0 atau tidak, bila bernilai diatas 0 maka akan di
                                        // tambahkan ke dalam variabel counter, bila bernilai 0,
                                        // maka tidak akan di tambahkan.
            if (temp[i]==0) {
                continue;
            }else {
                counter++;
            }
        }

        System.out.println(counter); // print hasil akhirnya berupa banyaknya kelompok yang ada
    }
}

// kelas disjointsets yang saya ambil dari modul, tidak ada modifikasi apapun
class DisjointSets {
    int[] parents;
    int[] ranks;
    int numOfElements;

    DisjointSets(int numOfElements) {
        this.numOfElements = numOfElements;
        this.parents = new int[numOfElements];
        this.ranks = new int[numOfElements];

        int i;

        for (i = 0; i < numOfElements; i++) {
            this.parents[i] = i;
            this.ranks[i] = 0;
        }
    }

    public int findSets(int element) {
        if (parents[element]==element) {
            return element;
        }else {
            return findSets(parents[element]);
        }
    }

    public void union(int element1, int element2) {
        int root1 = this.findSets(element1);
        int root2 = this.findSets(element2);

        if (root1 == root2) {
            return;
        }

        if (ranks[root1] > ranks[root2]) {
            parents[root2] = root1;
        }else if (ranks[root1] < ranks[root2]) {
            parents[root1] = root2;
        }else if (ranks[root1] == ranks[root2]) {
            parents[root2] = root1;
            ranks[root1] = ranks[root2] + 1;
        }


    }

}

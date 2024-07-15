import java.util.LinkedList;
import java.util.Scanner;

// Dengan mencari kombinasi dari kemungkinan yang ada (menggunakan permutasi), kemudian setelah mendapatkan kombinasi nya, dilakukan pengecekan. Apabila dari kombinasi tersebut ditemukan yang cocok
// (sesuai dengan ketentuan soal mengenai jarak), maka akan dimasukkan ke dalam linkedlist. Tujuan dimasukkan ke dalam linkedlist adalah untuk mengecek, apabila sudah pernah ada kombinasi yang sama,
// maka tidak akan dimasukkan ke dalam linkedlist. Linkedlist disini hanya berguna untuk mencegah kombinasi yang sama masuk ke dalam perhitungan. Setelah itu, print counter (ketika linkedlist
// bertambah, counter bertambah sehingga bisa disimpulkan counter = linkedlist size).

public class TugasBacktracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //masukkan bilangan n

        Permutasi permutasi = new Permutasi(n); //panggil kelas permutasi
        permutasi.generatePermutasi(); //mencari kombinasi yang sesuai

        System.out.println(permutasi.getCounter()); //output counter dari kelas permutasi (print counter)
    }


}

class Permutasi {
    protected int[] result;
    protected boolean[] mark;
    protected int n;
    protected LinkedList<String> res;
    protected int counter;

    public Permutasi(int n) {
        this.result = new int[n * 2];
        this.mark = new boolean[n * 2];
        this.n = n;
        this.res = new LinkedList<>();
        this.counter = 0;
    }

    protected void generatePermutasiRek(int curIdx) {
        if (curIdx==-1) {
            process();
        }else {
            for (int i = 0; i < result.length; i++) {
                if (this.mark[i] == true) {
                    this.mark[i] = false;

                    if (i < n) {
                        result[curIdx] = i + 1;
                    }else {
                        result[curIdx] = i + 1 - n;
                    }

                    generatePermutasiRek(curIdx-1);
                    this.mark[i] = true;
                }
            }
        }
    }

    protected void process() {
        boolean cek = false;

        for (int i = 0; i < n; i++) {
            int temp = result[i];
            int idx = temp + i + 1;

            if (idx >= n * 2) {
                return;
            }else {
                if (result[idx]==temp) {
                    cek = true;
                }else {
                    cek = false;
                    return;
                }
            }
        }

        String temp = "";

        if (cek) {
            for (int i = 0; i < this.result.length; i++) {
                temp += this.result[i];
            }

            if (res.contains(temp)) {
                return;
            }else {
                res.push(temp);
                this.counter++;
            }
        }
    }

    public void generatePermutasi() {
        for (int i = 0; i < this.mark.length; i++) {
            this.mark[i] = true;
        }
        generatePermutasiRek(this.result.length-1);
    }

    public int getCounter() {
        return this.counter;
    }
}

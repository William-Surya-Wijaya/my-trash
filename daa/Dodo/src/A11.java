//import java.util.Scanner;
//
//// Dengan menggunakan kelas HashTable dari modul, dan kelas ModularHashInteger yang sudah
//// dimodifikasi sesuai soal agar bisa mengubah input key menjadi index dengan menggunakan
//// rumus di soal, saya mengerjakan soal ini. Bila perintah masukkannya i (insert), saya mengecek
//// apakah dia masuk atau tidak, kemudian untuk perintah search dan delete dilakukan juga hal yang
//// sama. Pengecekan tersebut kemudian saya output sesuai ketentuan soal.
//public class A11 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//
//        ModularHashInteger<String> h = new ModularHashInteger<>(100);
//
//        for (int i = 0; i < n; i++) {
//            String perintah = sc.next();
//            int key = sc.nextInt();
//
//            if (perintah.equals("i")) {
//                String value = sc.next();
//                int temp = h.insert(key, value);
//
//                if (temp!=-1) {
//                    System.out.println("Data disimpan di dalam tabel indeks ke-" + temp + ".");
//                }else {
//                    System.out.println("Data tidak dapat disimpan");
//                }
//            }else if (perintah.equals("s")) {
//                String temp = h.search(key);
//
//                if (temp==null) {
//                    System.out.println("Data tidak dapat ditemukan.");
//                }else {
//                    System.out.println("Data ditemukan, value = " + temp + ".");
//                }
//            }else {
//                String temp = h.delete(key);
//                if (temp==null) {
//                    System.out.println("Gagal menghapus data, data tidak ditemukan.");
//                }else {
//                    System.out.println("Data " + temp + " berhasil dihapus.");
//                }
//            }
//        }
//    }
//}
//
//abstract class HashTable<K, V> {
//    protected Data[] table;
//    protected int capacity;
//    protected double c1, c2;
//    protected Data tombstone;
//
//    abstract protected int hashFunction(K key);
//
//    private class Data{
//        K key;
//        V value;
//
//        Data(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//    }
//
//    public HashTable(int capacity) {
//        this.capacity = capacity;
//        this.table = (Data[]) new HashTable.Data[capacity];
//        this.c1 = c1;
//        this.c2 = c2;
//        this.tombstone = new Data(null, null);
//    }
//
//    public int insert(K key, V value) {
//        Data newData = new Data(key,value);
//        int k0 = this.hashFunction(key);
//        int idx;
//
//        for (int i = 0; i < this.capacity; i++) {
//            idx = k0;
//
//            if (this.table[idx] == null || this.table[idx]==this.tombstone) {
//                this.table[idx] = newData;
//                return idx;
//            }
//        }
//
//        return -1;
//    }
//
//    public V search(K key) {
//        int k0 = this.hashFunction(key);
//        int idx;
//
//        for (int i = 0; i < this.capacity; i++) {
//            idx = k0;
//
//            if (this.table[idx] == null) {
//                return null;
//            }else if (this.table[idx] != this.tombstone && this.table[idx].key.equals(key)) {
//                V result = this.table[idx].value;
//                return result;
//            }
//        }
//
//        return null;
//
//    }
//
//    public V delete(K key) {
//        int k0 = this.hashFunction(key);
//        int idx;
//
//        for (int i = 0; i < this.capacity; i++) {
//            idx = k0;
//
//            if (this.table[idx] == null) {
//                return null;
//            }else if (this.table[idx] != this.tombstone && this.table[idx].key.equals(key)) {
//                V result = this.table[idx].value;
//                V temp = this.table[idx].value;
//                this.table[idx] = this.tombstone;
//                result = temp;
//                return result;
//            }
//        }
//
//        return null;
//    }
//
//}
//
//class ModularHashInteger<V> extends HashTable<Integer,V> {
//    public ModularHashInteger(int capacity) {
//        super(capacity);
//    }
//
//    protected int hashFunction(Integer key) {
//        double idx = (100 * ((key * 0.618) % 1));
//        int res = (int) idx;
//
//        return res;
//    }
//}

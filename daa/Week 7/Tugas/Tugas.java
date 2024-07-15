//import java.util.Scanner;
//
//// Dengan menggunakan class HashTable dari modul (yang menggunakan tombstone)
//// saya menginput 3 bilangan, bilangan m, c1, c2. Kemudian menggunakan looping
//// hasNext untuk tetap melooping masukkan. Pertama masukkan string untuk
//// perintah (insert, delete, dan search), kemudian ada masukkan keynya.
//// Kemudian dimasukkan ke dalam if untuk dilakukan perintah tersebut.
//// Untuk perintah yang insert, ada masukkan int value sebagai value yang
//// akan dimasukkan. Kemudian, saat melakukan perintah tersebut, sekalian
//// di print juga hasil nya.
//public class Tugas {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int m = sc.nextInt(); //masukkan bilangan m
//        double c1 = sc.nextDouble();//masukkan bilangan c1
//        double c2 = sc.nextDouble();//masukkan bilangan c2
//
//        ModularHashString<Integer> h = new ModularHashString<>(m, c1, c2);//pemanggilan class ModularHashString
//
//        while(sc.hasNext()) {//looping masukkan
//            String perintah = sc.next();//masukkan perintah
//            String key = sc.next();//masukkan key
//            //pelaksanaan perintah
//            if (perintah.equals("insert")) {//perintah insert
//                int value = sc.nextInt();//dalam perintah insert, ada masukkan int value
//                System.out.println(h.insert(key, value));//print hasil dari insert, true berhasil masuk dan false gagal masuk
//            }else if (perintah.equals("delete")) {//perintah delete
//                System.out.println(h.delete(key));//print hasil dari delete
//            }else if (perintah.equals("search")) {//perintah search
//                System.out.println(h.search(key));//print hasil dari search, akan keluar value dari key yang dicari
//            }
//
//        }
//
//
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
//    public HashTable(int capacity, double c1, double c2) {
//        this.capacity = capacity;
//        this.table = (Data[]) new HashTable.Data[capacity];
//        this.c1 = c1;
//        this.c2 = c2;
//        this.tombstone = new Data(null, null);
//    }
//
//    protected int quadraticProbing(int k0, int i) {
//        return ((int) (k0 + this.c1 * i + this.c2 * i * i)) % this.capacity;
//    }
//
//    public boolean insert(K key, V value) {
//        Data newData = new Data(key,value);
//        int k0 = this.hashFunction(key);
//        int idx;
//
//        for (int i = 0; i < this.capacity; i++) {
//            idx = this.quadraticProbing(k0, i);
//
//            if (this.table[idx] == null || this.table[idx]==this.tombstone) {
//                this.table[idx] = newData;
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    public V search(K key) {
//        int k0 = this.hashFunction(key);
//        int idx;
//
////        if (this.table[idx] != this.tombstone && this.table[idx].key.equals(key)) {
////            return this.table[idx].value;
////        }else {
////            return null;
////        }
//
////        if (this.table[idx] != this.tombstone && this.table[idx].key.equals(key)) {
////            return this.table[idx].value;
////        }else {
////            return null;
////        }
//
//        for (int i = 0; i < this.capacity; i++) {
//            idx = this.quadraticProbing(k0, i);
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
//            idx = this.quadraticProbing(k0, i);
//
//            if (this.table[idx] == null) {
//                return null;
//            }else if (this.table[idx] != this.tombstone && this.table[idx].key.equals(key)) {
//                V result = this.table[idx].value;
//                this.table[idx] = this.tombstone;
//                return result;
//            }
//        }
//
//        return null;
//    }
//
//}
//
//class ModularHashInteger<V> extends HashTable<Integer, V> {
//    public ModularHashInteger(int capacity, double c1, double c2) {
//        super(capacity,c1,c2);
//    }
//
//    protected int hashFunction(Integer key) {
//        return key % this.capacity;
//    }
//}
//
//class ModularHashString<V> extends HashTable<String, V> {
//    public ModularHashString(int capacity, double c1, double c2) {
//        super(capacity,c1,c2);
//    }
//
//    protected int hashFunction(String key) {
//        int l = key.length() - 1;
//        int total =0;
//
//        int counter = 0;
//
//        for (int i = l; i >= 0 ;i--) {
//            int ascii = (int)key.charAt(i) % this.capacity;
//            total += (ascii * Math.pow(256,counter)) % this.capacity; //menghitung String to integer
//            counter += 1;
//        }
//
//        return total; //kembalikan hasil total
//
////        int total = 0;
////        int ctr = 0;
////
////        for (int i = key.length()-1; i >= 0; i--) {
////            int ascii = key.charAt(0);
////
////            int pangkat = 1;
////
////            if (ctr==0) {
////                pangkat = 1;
////            }else {
////                for (int j = 1; j <= ctr; j++) {
////                    pangkat *= 256;
////                }
////            }
////
////            total += (ascii % this.capacity * pangkat % this.capacity) % this.capacity;
////            ctr++;
////        }
////
////        return total;
//    }
//}
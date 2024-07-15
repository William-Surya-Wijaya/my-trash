//import java.util.Hashtable;
//import java.util.Scanner;
//
//class Modul {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        ModularHashString<String> h = new ModularHashString<>(11);
//        h.insert("a", "John Smith");
//        h.insert("A", "Jane Smith");
//
////        System.out.println(h.delete(5));
//        System.out.println(h.search("a"));
//        System.out.println(h.search("b"));
////        System.out.println(h.search(16));
//    }
//}
//
//abstract class HashTable<K, V> {
//    protected Data[] table;
//    protected int capacity;
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
//    }
//
//    abstract protected int hashFunction(K key);
//
//    public V search(K key) {
//        int idx = this.hashFunction(key);
//        if (this.table[idx] != null && this.table[idx].key.equals(key)) {
//            return this.table[idx].value;
//        }else {
//            return null;
//        }
//    }
//
//    public boolean insert (K key, V value) {
//        int idx = this.hashFunction(key);
//        boolean cek;
//
//        if (this.table[idx]==null) {
//            this.table[idx] = new Data(key, value);
//            cek = true;
//        }else {
//            cek = false;
//        }
//
//        return cek;
//    }
//
//    public V delete (K key) {
//        int idx = this.hashFunction(key);
//
//        if (this.table[idx] != null && this.table[idx].key.equals(key)) {
//            V temp = this.table[idx].value;
//            this.table[idx] = null;
//            return temp;
//        }else {
//            return null;
//        }
//
//    }
//}
//
//class MultiplicativeHashInteger<V> extends HashTable<Integer, V> {
//    public MultiplicativeHashInteger(int capacity) {
//        super(capacity);
//    }
//
//    protected int hashFunction(Integer key) {
//        double temp = Math.floor(this.capacity * (key * ((Math.sqrt(5) - 1) / 2) % 1));
//        return (int)temp;
//    }
//}
//
//class FoldingHashInteger<V> extends HashTable<Integer, V> {
//    public FoldingHashInteger(int capacity) {
//        super(capacity);
//    }
//
//    protected int hashFunction(Integer key) {
//
//    }
//}
//
//class ModularHashInteger<V> extends HashTable<Integer,V> {
//    public ModularHashInteger(int capacity) {
//        super(capacity);
//    }
//
//    protected int hashFunction(Integer key) {
//        return key % this.capacity;
//    }
//}
//
//class ModularHashString<V> extends HashTable<String, V> {
//    public ModularHashString(int capacity) {
//        super(capacity);
//    }
//
//    protected int hashFunction(String key) {
//        int temp = key.charAt(0);
//        return temp % this.capacity;
//    }
//}

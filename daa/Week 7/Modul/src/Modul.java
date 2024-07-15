//public class Modul {
//    public static void main(String[] args) {
//        ModularHashInteger<String> h = new ModularHashInteger<>(11,3,2);
//        h.insert(5, "Alice");
//        h.insert(16, "Bob");
//        h.insert(27, "Charlie");
//
//        h.delete(16);
//
//        System.out.println(h.search(5));
//        System.out.println(h.search(16));
//        System.out.println(h.search(27));
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
//            if (this.table[idx] == null) {
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




import java.util.*;
 
abstract class HashTable<K,V>{
    protected Data[]table;
    protected int capacity;
    protected double c1, c2;
 
    private class Data{
        K key;
        V value;
 
        Data(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
 
    public HashTable(int capacity, double c1, double c2){
        this.capacity = capacity;
        this.table = (Data[]) new HashTable.Data[capacity];
        this.c1=c1;
        this.c2=c2;
    }
 
    protected Data tombstone = new Data(null, null);
 
    abstract protected int quadraticProbing(int k0, int i);
 
    abstract protected int hashFunction(K key);
 
    public boolean insert(K key, V value){
        Data newData = new Data(key, value);
        int k0 = this.hashFunction(key);
        int idx;
        for(int i = 0;i<this.capacity;i++){
            idx = this.quadraticProbing(k0, i);
            if(this.table[idx]==null || this.table[idx] == this.tombstone){
                this.table[idx]=newData;
                return true;
            }
        }
        return false;
    }
 
    public V search(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for(int i =0;i<this.capacity;i++){
            idx = this.quadraticProbing(k0,i);
            if(this.table[idx]==null){
                return null;
            }else if(this.table[idx] == this.tombstone){
                continue;
            }else if(this.table[idx]!=tombstone && this.table[idx].key.equals(key)){
                return this.table[idx].value;
            }
        }
        return null;
    }
 
    public V delete(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for(int i = 0;i<this.capacity;i++){
            idx = this.quadraticProbing(k0,i);
            if(this.table[idx] == null){
                return null;
            }else if(this.table[idx]!=this.tombstone && this.table[idx].key.equals(key)){
                V result = this.table[idx].value;
                this.table[idx] = this.tombstone;
                return result;
            }
        }
        return null;
    }
}
 
class ModularHashInteger<V> extends HashTable<Integer,V>{
    public ModularHashInteger(int capacity, double c1, double c2){
        super(capacity, c1, c2);
    }
 
    protected int quadraticProbing(int k0, int i){
        return ((int) (k0 + this.c1*i + this.c2*i*i))%this.capacity;
    }
 
    protected int hashFunction(Integer key){
        return key%this.capacity;
    }
}
 
public class ujiHashing {
    public static void main(String[]args){
        Scanner masukan = new Scanner(System.in);
        int ukuranTable = masukan.nextInt();
        double c1 = masukan.nextDouble();
        double c2 = masukan.nextDouble();
        ModularHashInteger<String> h = new ModularHashInteger<String>(ukuranTable, c1, c2);
        while(masukan.hasNext()){
            String perintah = masukan.next();
 
            if(perintah.equals("insert")){
                int key = masukan.nextInt();
                String value = masukan.next();
                boolean result = h.insert(key, value);
                System.out.println(result);
            }else if(perintah.equals("delete")){
                int key = masukan.nextInt();
                String deleted = h.delete(key);
                if(deleted == "null"){
                    System.out.println("null");
                }else{
                    System.out.println(deleted);
                }
            }else if(perintah.equals("search")){
                int key = masukan.nextInt();
                String result = h.search(key);
                if(result ==null){
                    System.out.println("null");
                }else{
                    System.out.println(result);
                }
            }
        }
    }
}



import java.util.*;
 
abstract class HashTable<K,V>{
    protected Data[]table;
    protected int capacity;
    protected double c1, c2;
 
    private class Data{
        K key;
        V value;
 
        Data(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
 
    public HashTable(int capacity, double c1, double c2){
        this.capacity = capacity;
        this.table = (Data[]) new HashTable.Data[capacity];
        this.c1=c1;
        this.c2=c2;
    }
 
    protected Data tombstone = new Data(null, null);
 
    abstract protected int quadraticProbing(int k0, int i);
 
    abstract protected int hashFunction(K key);
 
    public boolean insert(K key, V value){
        Data newData = new Data(key, value);
        int k0 = this.hashFunction(key);
        int idx;
        for(int i = 0;i<this.capacity;i++){
            idx = this.quadraticProbing(k0, i);
            if(this.table[idx]==null || this.table[idx] == this.tombstone){
                this.table[idx]=newData;
                return true;
            }
        }
        return false;
    }
 
    public V search(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for(int i =0;i<this.capacity;i++){
            idx = this.quadraticProbing(k0,i);
            if(this.table[idx]==null){
                return null;
            }else if(this.table[idx] == this.tombstone){
                continue;
            }else if(this.table[idx]!=tombstone && this.table[idx].key.equals(key)){
                return this.table[idx].value;
            }
        }
        return null;
    }
 
    public V delete(K key){
        int k0 = this.hashFunction(key);
        int idx;
        for(int i = 0;i<this.capacity;i++){
            idx = this.quadraticProbing(k0,i);
            if(this.table[idx] == null){
                return null;
            }else if(this.table[idx]!=this.tombstone && this.table[idx].key.equals(key)){
                V result = this.table[idx].value;
                this.table[idx] = this.tombstone;
                return result;
            }
        }
        return null;
    }
}
 
class ModularHashInteger<V> extends HashTable<Integer,V>{
    public ModularHashInteger(int capacity, double c1, double c2){
        super(capacity, c1, c2);
    }
 
    protected int quadraticProbing(int k0, int i){
        return ((int) (k0 + this.c1*i + this.c2*i*i))%this.capacity;
    }
 
    protected int hashFunction(Integer key){
        return key%this.capacity;
    }
}
 
public class ujiHashing {
    public static void main(String[]args){
        Scanner masukan = new Scanner(System.in);
        int ukuranTable = masukan.nextInt();
        double c1 = masukan.nextDouble();
        double c2 = masukan.nextDouble();
        ModularHashInteger<String> h = new ModularHashInteger<String>(ukuranTable, c1, c2);
        while(masukan.hasNext()){
            String perintah = masukan.next();
 
            if(perintah.equals("insert")){
                int key = masukan.nextInt();
                String value = masukan.next();
                boolean result = h.insert(key, value);
                System.out.println(result);
            }else if(perintah.equals("delete")){
                int key = masukan.nextInt();
                String deleted = h.delete(key);
                if(deleted == "null"){
                    System.out.println("null");
                }else{
                    System.out.println(deleted);
                }
            }else if(perintah.equals("search")){
                int key = masukan.nextInt();
                String result = h.search(key);
                if(result ==null){
                    System.out.println("null");
                }else{
                    System.out.println(result);
                }
            }
        }
    }
}

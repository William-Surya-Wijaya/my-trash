import java.util.*;
 
public class Multiplicative {
    class FieldValue {
        String value;
 
        public FieldValue(String value){
            this.value = value;
        }
 
        public void deleteValue(){
            this.value = null;
        }
 
        public String getValue(){
            return this.value;
        }
    }
 
    public static void main(String[] args){
        HashMap<String, String> table = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
 
        int query = scanner.nextInt();
 
        for(int i =0; i<query; i++){
            String command = scanner.next();
 
            if(command.equals("i")){
                int key = scanner.nextInt();
                String value = scanner.next();
 
                int hashedKey = (int)(100 * (key * 0.618 % 1));

                if(table.get(Integer.toString(hashedKey)) == null){
                    table.put(Integer.toString(hashedKey), value);
                    System.out.println("Data disimpan di dalam tabel indeks ke-" + hashedKey + ".");
                } else {
                    System.out.println("Data tidak dapat disimpan.");
                }
            } else {
                if(command.equals("s")){
                    int key = scanner.nextInt();
                    int hashedKey = (int)(100 * (key * 0.618 % 1));
 
                    String queryResult = table.get(Integer.toString(hashedKey));
                    if(queryResult == null){
                        System.out.println("Data tidak ditemukan.");
                    } else {
                        System.out.println("Data ditemukan, value = "+queryResult+".");
                    }
                } else {
                    int key = scanner.nextInt();
                    int hashedKey = (int)(100 * (key * 0.618 % 1));
 
                    String queryResult = table.get(Integer.toString(hashedKey));
                    if(queryResult == null){
                        System.out.println("Gagal menghapus data, data tidak ditemukan.");
                    } else {
                        table.remove(Integer.toString(hashedKey));
                        System.out.println("Data "+queryResult+" berhasil dihapus.");
                    }
                }
            }
        }
 
    }
}
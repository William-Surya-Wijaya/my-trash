import java.util.*;

class Hashing{
    static int hash(String key, int m) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = (h * 256 + key.charAt(i)) % m;
        }
        return h;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Map<String, Value> table = new HashMap<String, Value>();
        
        int ukuranTable = scanner.nextInt();
        double c1 = scanner.nextDouble();
        double c2 = scanner.nextDouble();

        while(true){
            String command = scanner.next();

            if(command.equals("insert")){
                String key = scanner.next();
                String value = scanner.next();
            
                int h = hash(key, ukuranTable);
                boolean placed = false;
            
                for (int i = 0; i < ukuranTable; i++) {
                    int idx = (int)(h + (c1 * i) + (c2 * i * i)) % ukuranTable;
            
                    Value v = table.get(Integer.toString(idx));
                    if (v == null || v.getValue().equals("SENTINEL")) {
                        table.put(Integer.toString(idx), new Value(key,value));
                        System.out.println("true");
                        placed = true;
                        break;
                    }
                }

                if (!placed) System.out.println("false");
            }

            if(command.equals("search")){
                String key = scanner.next();
                boolean found = false;

                int h = 0;
                for(int i =0; i<key.length(); i++){
                    h = (h * 256 + key.charAt(i)) % ukuranTable;
                }

                for (int i = 0; i < ukuranTable; i++) {
                    int idx = (int)(h + (c1 * i) + (c2 * i * i)) % ukuranTable;

                    Value v = table.get(Integer.toString(idx));
                    if (v == null) break;
                    if (!v.getValue().equals("SENTINEL") && v.getKey().equals(key)) {
                        System.out.println(v.getValue());
                        found = true;
                        break;
                    }
                }

                if (!found) System.out.println("null");
            }

            if(command.equals("delete")){
                String key = scanner.next();

                int h = hash(key, ukuranTable);
                boolean deleted = false;

                for (int i = 0; i < ukuranTable; i++) {
                    int idx = (int)(h + (c1 * i) + (c2 * i * i)) % ukuranTable;

                    Value v = table.get(Integer.toString(idx));
                    if (v == null) break;
                    if (!v.getValue().equals("SENTINEL") && v.getKey().equals(key)) {
                        System.out.println(v.getValue());
                        table.put(Integer.toString(idx), new Value("SENTINEL","SENTINEL"));
                        deleted = true;
                        break;
                    }
                }
                if (!deleted) System.out.println("null");
            }
        }
    }
}

class Value{
    String value = "SENTINEL";
    String keyValue = "SENTINEL";

    public Value(String key ,String value){
        if(value == null){
            this.value = "SENTINEL";
            this.keyValue = "SENTINEL";
        } else {
            this.value = value;
            this.keyValue = key;
        }
    }

    public String getValue(){
        return this.value;
    }

    public String getKey(){
        return this.keyValue;
    }
}
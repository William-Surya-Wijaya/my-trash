import java.util.*;

public class MenghilangkanDuplikasi{
    public static void main(String[] args){
        Map<String, String> dict = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] listInput = input.split(" ");

        for(String one : listInput){
            if(dict.get(one) == null){
                dict.put(one, "1");
            } else {
                int val = Integer.parseInt(dict.get(one))+1;
                dict.put(one, Integer.toString(val));
            }
        }

        for(String key : dict.keySet()){
            System.out.println(key + " "+ dict.get(key));
        }
    }
}
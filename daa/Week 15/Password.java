
import java.util.*;

public class Password {
    private static void print(char result[],int pos){
        for(int i=0; i < pos; i++){
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static void combinationEasy(char[] input) {
        List<Character> r = new ArrayList<>();
        Arrays.sort(input);
        combinationEasy(input, 0, r);
    }

    private static void combinationEasy(char[] input, int pos, List<Character> r) {

        r.forEach(r1 -> System.out.print(r1 + " "));
        System.out.println();
        for (int i = pos; i < input.length; i++) {
            if (i != pos && input[i] == input[i-1]) {
                continue;
            }
            r.add(input[i]);
            combinationEasy(input, i + 1, r);
            r.remove(r.size() - 1);
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        char[] arrChar = new char[input.length()];

        for (int i = 0; i < input.length(); i++) {
            arrChar[i] = input.charAt(i);
        }

        combinationEasy(arrChar);
    }
}
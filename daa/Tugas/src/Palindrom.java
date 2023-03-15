import java.util.Scanner;
import java.util.Stack;

public class Palindrom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int j = sc.nextInt();

        for (int i = 0; i < j; i++) {
            String input = sc.next();
            int length = input.length();

            Stack<Character> stack = new Stack<>();

            for (int k = 0; k < length; k++) {
                stack.push(input.charAt(k));
            }

            String reverse = "";

            while(stack.isEmpty()==false) {
                reverse = reverse + stack.pop();
            }

            if (input.equals(reverse)) {
                System.out.println("true");
            }else {
                System.out.println("false");
            }

        }
    }
}

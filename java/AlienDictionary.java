import java.util.*;

public class AlienDictionary {
    static Map<Character, List<Character>> graph = new HashMap<>();
    static Set<Character> visited = new HashSet<>();
    static Stack<Character> topoStack = new Stack<>();

    static void buildGraph(ArrayList<String> words){
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i = 0; i<words.size()-1; i++){
            String word1 = words.get(i);
            String word2 = words.get(i+1);
            int minLength = Math.min(word1.length(), word2.length());

            for(int j = 0; j<minLength; j++){
                if(word1.charAt(j) != word2.charAt(j)){
                    graph.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
    }

    static void dfs(char node){
        if(visited.contains(node)) return;

        visited.add(node);
        for(char neighbor : graph.get(node)){
            dfs(neighbor);
        }

        topoStack.push(node);
    }

    static String findAlienAlphabet(ArrayList<String> words){
        buildGraph(words);

        for(char node : graph.keySet()){
            if(!visited.contains(node)){
                dfs(node);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!topoStack.isEmpty()){
            result.append(topoStack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> words = new ArrayList<>();

        while (true) {
            String input = scanner.next();
            if (input.equals("#")) break;
            words.add(input);
        }

        String order = findAlienAlphabet(words);
        System.out.println(order);
    }
}

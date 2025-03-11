import java.util.*;

public class TravelAgent {
    static Map<String, ArrayList<String>> listKota = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static Queue<String> queue = new LinkedList<>();
    static int bfsDepth;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int jumlahKota = scanner.nextInt();
        int jalan = scanner.nextInt();

        for(int i = 0; i<jalan; i++){
            String kota1 = scanner.next();
            String kota2 = scanner.next();

            listKota.putIfAbsent(kota1, new ArrayList<>());
            listKota.get(kota1).add(kota2);

            listKota.putIfAbsent(kota2, new ArrayList<>());
            listKota.get(kota2).add(kota1);
        }

        bfsDepth = scanner.nextInt()/2;

        int totalTerkunjungi = bfs("1");

        System.out.println(jumlahKota - totalTerkunjungi);
    }

    static int bfs(String node){
        Map<String, Integer> depthMap = new HashMap<>();
        int totalTerkunjungi = 1;

        visited.add(node);
        queue.offer(node);
        depthMap.put(node, 0);

        while(!queue.isEmpty()){
            String current = queue.poll();
            int depth = depthMap.get(current);

            if(depth >= bfsDepth){
                break;
            }

            for(String tetangga : listKota.get(current)){
                if(!visited.contains(tetangga)){
                    visited.add(tetangga);
                    queue.offer(tetangga);
                    depthMap.put(tetangga, depth + 1);
                    totalTerkunjungi ++;
                }
            }
        }

        return totalTerkunjungi;
    }
}

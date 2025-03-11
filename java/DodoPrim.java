import java.util.*;

class DodoPrim {
    static class Edge {
        int source, destination, weight;
        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalKota = scanner.nextInt();
        int totalJalan = scanner.nextInt();

        int kotaAwal = scanner.nextInt();
        int kotaTujuan = scanner.nextInt();

        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < totalJalan; i++) {
            int kotaA = scanner.nextInt();
            int kotaB = scanner.nextInt();
            int bobot = scanner.nextInt();

            graph.putIfAbsent(kotaA, new ArrayList<>());
            graph.putIfAbsent(kotaB, new ArrayList<>());

            graph.get(kotaA).add(new Edge(kotaA, kotaB, bobot));
            graph.get(kotaB).add(new Edge(kotaB, kotaA, bobot));
        }

        // Dapatkan MST (Minimum Spanning Tree)
        Map<Integer, List<Edge>> mst = primMST(graph, totalKota, kotaAwal);

        // Setelah MST diperoleh, cari jalur dari kotaAwal ke kotaTujuan
        List<Integer> path = findPath(mst, kotaAwal, kotaTujuan);

        // Hitung total jarak path tersebut
        int totalPathDistance = calculatePathDistance(mst, path);

        // Output hasil
        System.out.println(totalPathDistance);
        for (int node : path) {
            System.out.print(node + " ");
        }
    }

    static Map<Integer, List<Edge>> primMST(Map<Integer, List<Edge>> graph, int totalKota, int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Edge>> mst = new HashMap<>();
    
        queue.offer(new Edge(-1, start, 0)); // -1 means no source initially
    
        while (!queue.isEmpty() && visited.size() < totalKota) {
            Edge current = queue.poll();
            int currNode = current.destination;
    
            if (visited.contains(currNode)) continue;
            visited.add(currNode);
    
            if (current.source != -1) { // not the first node
                mst.putIfAbsent(current.source, new ArrayList<>());
                mst.putIfAbsent(currNode, new ArrayList<>());
                
                mst.get(current.source).add(new Edge(current.source, currNode, current.weight));
                mst.get(currNode).add(new Edge(currNode, current.source, current.weight));
            }
    
            for (Edge neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited.contains(neighbor.destination)) {
                    queue.offer(new Edge(currNode, neighbor.destination, neighbor.weight));
                }
            }
        }
    
        return mst;
    }
    

    static List<Integer> findPath(Map<Integer, List<Edge>> mst, int start, int end) {
        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        if (dfs(mst, start, end, visited, path)) {
            return path;
        }
        return Collections.emptyList();
    }

    static boolean dfs(Map<Integer, List<Edge>> mst, int current, int end, Set<Integer> visited, List<Integer> path) {
        visited.add(current);
        path.add(current);
        if (current == end) return true;

        for (Edge edge : mst.getOrDefault(current, new ArrayList<>())) {
            if (!visited.contains(edge.destination)) {
                if (dfs(mst, edge.destination, end, visited, path)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    static int calculatePathDistance(Map<Integer, List<Edge>> mst, List<Integer> path) {
        int distance = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            for (Edge edge : mst.get(from)) {
                if (edge.destination == to) {
                    distance += edge.weight;
                    break;
                }
            }
        }
        return distance;
    }    
}
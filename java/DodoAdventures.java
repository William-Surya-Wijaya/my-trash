import java.util.*;

class DodoAdventures {
    static class Edge {
        int destination, weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Result {
        int distance;
        List<Integer> path;
        public Result(int distance, List<Integer> path) {
            this.distance = distance;
            this.path = path;
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

            graph.get(kotaA).add(new Edge(kotaB, bobot));
            graph.get(kotaB).add(new Edge(kotaA, bobot));
        }

        Result result = dijkstra(graph, kotaAwal, kotaTujuan);
        System.out.println(result.distance);
        for (Integer node : result.path) {
            System.out.print(node + " ");
        }
    }

    static Result dijkstra(Map<Integer, List<Edge>> graph, int start, int target) {
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        for (Integer node : graph.keySet()) {
            distance.put(node, Integer.MAX_VALUE);
        }
        distance.put(start, 0);

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue.offer(new Edge(start, 0));

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Edge current = queue.poll();
            int currNode = current.destination;
            int currDistance = current.weight;

            if (visited.contains(currNode)) continue;
            visited.add(currNode);

            if (currNode == target) {
                List<Integer> path = new ArrayList<>();
                int at = target;
                while (at != start) {
                    path.add(at);
                    at = prev.get(at);
                }
                path.add(start);
                Collections.reverse(path);
                return new Result(currDistance, path);
            }

            for (Edge neighbor : graph.getOrDefault(currNode, new ArrayList<>())) {
                if (!visited.contains(neighbor.destination)) {
                    int newDistance = currDistance + neighbor.weight;
                    if (newDistance < distance.get(neighbor.destination)) {
                        distance.put(neighbor.destination, newDistance);

                        prev.put(neighbor.destination, currNode);
                        queue.offer(new Edge(neighbor.destination, newDistance));
                    }
                }
            }
        }

        return new Result(-1, new ArrayList<>());
    }
}

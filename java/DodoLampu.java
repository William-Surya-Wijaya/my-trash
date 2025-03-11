import java.util.*;

public class DodoLampu {
    public static void main(String[] args){
        Map<String, Kota> listKota = new HashMap<>();
        Map<String, ArrayList<Jalan>> mapKota = new HashMap<>();
        int totalBobot = 0;

        Scanner scanner = new Scanner(System.in);
        int banyakPersimpangan = scanner.nextInt();
        int banyakJalan = scanner.nextInt();

        for(int i = 0; i < banyakJalan; i++){
            String kotaA = scanner.next();
            String kotaB = scanner.next();
            int bobot = scanner.nextInt();
            scanner.nextLine();

            Kota kotaPing = new Kota(kotaA);
            listKota.putIfAbsent(kotaA, kotaPing);

            Kota kotaPong = new Kota(kotaB);
            listKota.putIfAbsent(kotaB, kotaPong);

            mapKota.putIfAbsent(kotaA, new ArrayList<>());
            mapKota.putIfAbsent(kotaB, new ArrayList<>());

            mapKota.get(kotaA).add(new Jalan(kotaA, kotaB, bobot));
            mapKota.get(kotaB).add(new Jalan(kotaB, kotaA, bobot));

            totalBobot += bobot;
        }

        String startingKota = "";
        for(String kota : listKota.keySet()){
            startingKota = kota;
            break;
        }

        int totalDilewati = dijkstra(listKota, mapKota, startingKota);
        System.out.println(totalBobot - totalDilewati);
    }

    public static int dijkstra(Map<String, Kota> listKota, Map<String, ArrayList<Jalan>> mapKota, String startingKota){
        PriorityQueue<Kota> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.bobot, n2.bobot));

        Kota startingPoint = listKota.get(startingKota);
        startingPoint.setBobot(0, 0);

        int totalBobot = 0;

        pq.offer(startingPoint);

        while(!pq.isEmpty()){
            Kota currentKota = pq.poll();

            if(currentKota.isVisited()){
                continue;
            }

            currentKota.setVisited();
            totalBobot += currentKota.getEdgeWeight();

            int currentWeight = currentKota.bobot;

            for(Jalan jalan : mapKota.get(currentKota.namaKota)){
                int newBobot = jalan.bobot+currentWeight;

                if(listKota.get(jalan.kotaB).getBobot() > newBobot){
                    listKota.get(jalan.kotaB).setBobot(newBobot, jalan.bobot);
                    pq.offer(listKota.get(jalan.kotaB));
                }
            }
        }

        return totalBobot;
    }
}

class Kota{
    String namaKota;
    Boolean visited = false;
    int bobot = Integer.MAX_VALUE;
    int edgeWeight;

    public Kota(String namaKota){
        this.namaKota = namaKota;
    }

    public void setVisited(){
        this.visited = true;
    }

    public Boolean isVisited(){
        return this.visited;
    }

    public void setBobot(int bobot, int edgeWeight){
        this.edgeWeight = edgeWeight;
        this.bobot = bobot;
    }

    public int getBobot(){
        return this.bobot;
    }

    public int getEdgeWeight(){
        return this.edgeWeight;
    }
}

class Jalan{
    String kotaA;
    String kotaB;
    int bobot;
    Boolean visited = false;

    public Jalan(String kotaA, String kotaB, int bobot){
        this.kotaA = kotaA;
        this.kotaB = kotaB;
        this.bobot = bobot;
    }

    public void setVisited(){
        this.visited = true;
    }

    public boolean isVisited(){
        return this.visited;
    }
}
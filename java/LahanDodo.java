import java.util.*;

class LahanDodo{
    static int jumlahTiang;
    static int jumlahTali;
    static Map<String, List<String>> battlefield = new HashMap<>();
    static Set<String> visited = new HashSet<>();
    static Set<String> inCurrentPath = new HashSet<>();
    static int areaCount = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        jumlahTiang = scanner.nextInt();
        jumlahTali = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i<jumlahTiang; i++){
            String in = scanner.next();
            battlefield.put(in, new ArrayList<>());
        }
        scanner.nextLine();

        for(int i = 0; i<jumlahTali; i++){
            String in = scanner.next();
            String ot = scanner.next();
            battlefield.get(in).add(ot);
            battlefield.get(ot).add(in);
        }
        scanner.close();

        for(String tiang : battlefield.keySet()){
            if(!visited.contains(tiang)){
                if (cycleDfs(tiang, null)) {
                    areaCount++;
                }
            }
        }

        System.out.println(areaCount);
    }

    static boolean cycleDfs(String node, String parent){
        visited.add(node);
        inCurrentPath.add(node);

        for(String neighbor : battlefield.get(node)){
            if(!visited.contains(neighbor)){
                if(cycleDfs(neighbor, node)){
                    return true;
                }
            } else if (!neighbor.equals(parent) && inCurrentPath.contains(neighbor)){
                return true;
            }
        }

        inCurrentPath.remove(node);
        return false;
    }
}
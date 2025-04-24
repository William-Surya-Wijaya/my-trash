import java.util.*;
 
public class DisjointSets{
    static Map<String, SetElement> elementMap = new HashMap<>();
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
 
        int elementsCount = scanner.nextInt();
        System.out.println("make-set "+elementsCount+" times");
        for(int i = 0; i<elementsCount; i++){
            elementMap.put(Integer.toString(i), new SetElement(Integer.toString(i)));
        }
 
        while(true){
            String command = scanner.next();
            if(command.equals("x")){
                break;
            }
 
            if(command.equals("f")){
                String target = scanner.next();
                String representative = findSet(target);
                System.out.println("representative of "+target+" is "+representative);
            }
 
            if(command.equals("u")){
                String setOne = scanner.next();
                String setTwo = scanner.next();
                union(setOne, setTwo);
                System.out.println("union between "+setOne+" and "+setTwo);
            }

            if(command.equals("p")){
                String element = scanner.next();
                String parent = elementMap.get(element).getParent();

                System.out.println("parents of "+element+" is "+parent);
            }

            if(command.equals("r")){
                String element = scanner.next();
                int rank = elementMap.get(element).getRank();

                System.out.println("ranks of "+element+" is "+rank);
            }

            if(command.equals("t")){
                List<String> parentList = new ArrayList<>();
                for(String element : elementMap.keySet()){
                    parentList.add(elementMap.get(element).getParent());
                }
                System.out.println("list of parents: [" + String.join(", ", parentList) + "]");
            }

            if(command.equals("k")){
                List<String> rankList = new ArrayList<>();
                for(String element : elementMap.keySet()){
                    rankList.add(Integer.toString(elementMap.get(element).getRank()));
                }
                System.out.println("list of ranks : [" + String.join(", ", rankList) + "]");
            }
        }
    }
 
    static String findSet(String elementName){
        String parent = elementMap.get(elementName).getParent();
        if(!elementName.equals(parent)){
            // ---------------------------
            String root = findSet(parent);
            elementMap.get(elementName).setParent(root);
            // ---------------------------
            return findSet(parent);
        }
        return elementName;
    }    
 
    static void union(String elementOne, String elementTwo) {
        String rootOne = findSet(elementOne);
        String rootTwo = findSet(elementTwo);

        if(rootOne.equals(rootTwo)) {
            return;
        }

        int rankOne = elementMap.get(rootOne).getRank();
        int rankTwo = elementMap.get(rootTwo).getRank();

        if (rankOne > rankTwo) {
            elementMap.get(rootTwo).setParent(rootOne);
        } else if (rankOne < rankTwo) {
            elementMap.get(rootOne).setParent(rootTwo);
        } else {
            elementMap.get(rootOne).setParent(rootTwo);
            elementMap.get(rootTwo).setRank(rankTwo + 1);
        }
    }
}
 
class SetElement{
    String elementName;
    String parent;
    int rank;
 
    public SetElement(String elementName){
        this.elementName = elementName;
        this.parent = elementName;
        this.rank = 0;
    }
 
    public void setParent(String parent){
        this.parent = parent;
    }
 
    public String getParent(){
        return this.parent;
    }
 
    public void setRank(int rank){
        this.rank = rank;
    }
 
    public int getRank(){
        return this.rank;
    }
}
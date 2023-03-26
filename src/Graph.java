import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Graph {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";

    public int[][] graph; //şehirler arası mesafeyi tutma //graph
    HashMap<Integer, String> hashMapCities; //şehirlerin ismini tutma //hashmap
    public int temporarySize = 0; //hashmap keyleri için
    Node walk; //linkedlist üzerinde dolaşmak için

    public Graph() {
    }

    //hashmap oluşturma
    public void createHashMap(LinkedList linkedList) {

        hashMapCities = new HashMap<>();

        //'null' kontrol etme
        if (linkedList.head.next != null) {
            walk = linkedList.head;
        } else {
            return;
        }

        //aynı değerleri eklemeyi engelleme
        boolean control;
        while (walk != null) {
            control = true;

            //hashmap boş ise ilk değeri ekleme
            if (hashMapCities.size() == 0) {
                String temporaryString = linkedList.head.from;
                hashMapCities.put(temporarySize, temporaryString);
                temporarySize++;
            } else {
                for (String i : hashMapCities.values()) {
                    if (Objects.equals(i, walk.from)) {
                        control = false;
                        break;
                    }
                }
                if (control) {
                    String temporaryString = walk.from;
                    hashMapCities.put(temporarySize, temporaryString);
                    temporarySize++;
                }
            }
            walk = walk.next;
        }

    }

    public int[][] createGraph(LinkedList linkedList) {

        createHashMap(linkedList);

        //graph oluşturma ve bütün değerlerine sıfır atama
        graph = new int[hashMapCities.size()][hashMapCities.size()];
        for (int i = 0; i < hashMapCities.size(); i++) {
            for (int j = 0; j < hashMapCities.size(); j++) {
                graph[i][j] = 0;
            }
        }

        //'null' kontrol etme
        if (linkedList.head.next != null) {
            walk = linkedList.head;
        }

        while (walk != null) {
            for (Map.Entry<Integer, String> entryFrom : hashMapCities.entrySet()) {
                if (Objects.equals(entryFrom.getValue(), walk.from)) {
                    for (Map.Entry<Integer, String> entryTo : hashMapCities.entrySet()) {
                        if (Objects.equals(entryTo.getValue(), walk.to)) {
                            graph[entryFrom.getKey()][entryTo.getKey()] = walk.distance;
                        }
                    }

                }
            }
            walk = walk.next;
        }
        return graph;
    }

    //hashmap yazdırma
    public void printHashMap() {

        int temporary = numberOfDigits(hashMapCities.size());

        System.out.println(ANSI_BOLD + ANSI_GREEN + "HashMap:" + ANSI_RESET);
        System.out.printf(ANSI_BOLD + ANSI_GREEN + "%" + temporary + "s %15s\n" + ANSI_RESET, "key", "value");
        for (Map.Entry<Integer, String> entry : hashMapCities.entrySet()) {
            System.out.printf("%" + temporary + "d -> %15s\n", entry.getKey(), entry.getValue());
        }

    }

    //graph yazdırma
    public void printGraph() {

        printHashMap();
        int temporary = numberOfDigits(hashMapCities.size());
        System.out.println();

        for (int i = 0; i < hashMapCities.size(); i++) {
            for (int j = 0; j < hashMapCities.size(); j++) {
                if (graph[i][j] != 0) {
                    System.out.printf(ANSI_BOLD + ANSI_GREEN + "%" + temporary + "d " + ANSI_RESET, graph[i][j]);
                } else {
                    System.out.printf(ANSI_BOLD + ANSI_WHITE + "%" + temporary + "d " + ANSI_RESET, graph[i][j]);
                }
            }
            System.out.println();
        }

    }

    public int numberOfDigits(int temporary) {

        int counter = 0;
        while (temporary > 0) {
            temporary /= 10;
            counter++;
        }
        return counter;

    }

}
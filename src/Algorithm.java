import java.util.HashMap;

public class Algorithm {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Algorithm() {
    }

    //minimum mesafeyi bulma
    public int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public void dijkstra(int[][] graph, int vertexFrom, HashMap<Integer, String> hashMapCities, int from, int to) {
        //graph boyutu
        int sizeGraph = graph.length;

        //zirayet edilen vertexleri tutma
        boolean[] visitedVertex = new boolean[sizeGraph];
        //vertexler arası mesafeyi tutma
        int[] distance = new int[sizeGraph];
        String[] path = new String[sizeGraph];

        //vertexleri hiç zirayet edilmedi olarak işaretle
        //vertexler arası mesafeyi sonsuz olarak tanımla
        for (int i = 0; i < sizeGraph; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        //Seçilen vertex'in mesafesine 0 atama
        distance[vertexFrom] = 0;
        path[vertexFrom] = ANSI_BOLD + "Road Map" + ": " + ANSI_RESET;

        for (int i = 0; i < sizeGraph; i++) {

            //seçilen vertex ile komşu vertex arasındaki mesafeyi güncelleme
            int update = findMinDistance(distance, visitedVertex);
            //zirayet edilen vertex'i işaretleme
            visitedVertex[update] = true;

            //komşu vertexlerin mesafesini güncelleme
            for (int numberOfVertex = 0; numberOfVertex < sizeGraph; numberOfVertex++) {
                if (!visitedVertex[numberOfVertex] && graph[update][numberOfVertex] != 0 &&
                        (distance[update] + graph[update][numberOfVertex] < distance[numberOfVertex])) {
                    distance[numberOfVertex] = distance[update] + graph[update][numberOfVertex];
                    path[numberOfVertex] = path[update] + hashMapCities.get(update) + " -> ";
                }
            }
        }

        //sonuçları yazdırma
        for (int i = 0; i < distance.length; i++) {
            if (i != from) {
                if (i == to) {
                    System.out.println(ANSI_BOLD + ANSI_GREEN + "-----------------------------------------------------------------------------------------" + ANSI_RESET);
                    System.out.printf(ANSI_GREEN + "✅" + ANSI_RESET + ANSI_BOLD + ANSI_BG_GREEN + " %3d " + ANSI_RESET + ANSI_BOLD + ANSI_GREEN + " distance from %s to %s%n" + ANSI_RESET, distance[i], hashMapCities.get(vertexFrom), hashMapCities.get(i));
                    System.out.println(ANSI_GREEN + path[i] + hashMapCities.get(i) + ANSI_RESET);
                    System.out.println(ANSI_BOLD + ANSI_GREEN + "-----------------------------------------------------------------------------------------" + ANSI_RESET);
                } else {
                    System.out.printf(ANSI_BOLD + ANSI_WHITE + " %3d distance from %s to %s%n" + ANSI_RESET, distance[i], hashMapCities.get(vertexFrom), hashMapCities.get(i));
                }
            }
        }

    }

}
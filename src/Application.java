import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        Graph graph = new Graph();
        Algorithm algorithm = new Algorithm();
        Print print = new Print();
        Scanner scanner = new Scanner(System.in);
        int[][] temporaryGraph;

        readFile.readerFromFile("map.txt");
        temporaryGraph = graph.createGraph(readFile.linkedList);

        System.out.println("WELCOME");

        //bulunan konumu seçme
        int choiceCitiesFrom;
        do {

            print.design();
            System.out.println("Please select your location: ");
            print.printCitiesFrom(graph.hashMapCities);
            System.out.print("Choice: ");
            choiceCitiesFrom = scanner.nextInt();

            if (choiceCitiesFrom < 1 || choiceCitiesFrom > graph.hashMapCities.size()) {
                System.out.println("WARNING, Please try again.");
            }

        } while (choiceCitiesFrom < 1 || choiceCitiesFrom > graph.hashMapCities.size());

        print.design();
        int choice;
        int choiceCitiesTo;
        do {

            System.out.println("1 -> Show possible cities" +
                    "\n2 -> Graph printing" +
                    "\n3 -> EXIT");
            System.out.println("Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    print.design();
                    do {
                        System.out.println("Please select destination: ");
                        print.printCitiesTo(graph.hashMapCities, choiceCitiesFrom - 1);
                        choiceCitiesTo = scanner.nextInt();
                        if (choiceCitiesTo < 1 || choiceCitiesTo > graph.hashMapCities.size() || choiceCitiesTo == choiceCitiesFrom) {
                            System.out.println("WARNING, Please try again.");
                        }
                    } while (choiceCitiesTo < 1 || choiceCitiesTo > graph.hashMapCities.size() || choiceCitiesTo == choiceCitiesFrom);
                    algorithm.dijkstra(temporaryGraph, choiceCitiesFrom - 1, graph.hashMapCities, choiceCitiesFrom - 1, choiceCitiesTo - 1);
                    print.design();
                    break;
                case 2:
                    print.design();
                    graph.printGraph();
                    print.design();
                    break;
                case 3:
                    print.design();
                    System.out.println("GOOD BYE");
                    print.design();
                    break;
                default:
                    print.design();
                    System.out.println("WARNING");
                    print.design();
                    break;
            }
        } while (choice != 3);
    }

}
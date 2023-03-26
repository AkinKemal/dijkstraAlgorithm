import java.io.BufferedReader;
import java.io.FileReader;

public class ReadFile {

    LinkedList linkedList = new LinkedList();
    public int sizeGraph = 0;

    public ReadFile() {
    }

    public LinkedList readerFromFile(String fileName) {
        try {
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while ((line = bufferedReader.readLine()) != null) {
                String[] arraySplit = line.split("-");
                if (arraySplit.length == 3) {
                    String from = arraySplit[0];
                    String to = arraySplit[1];
                    int distance = Integer.parseInt(arraySplit[2]);
                    boolean booleanContains = linkedList.contains(from, to);
                    if (booleanContains) {
                        linkedList.add(from, to, distance);
                    } else {
                        System.out.println("Warning! A pre-recorded distance!");
                    }
                    if (linkedList.containsGraph(from)) {
                        sizeGraph++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Warning! Error reading " + fileName + " file!");
        }
        return linkedList;
    }

}
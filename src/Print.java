import java.util.HashMap;
import java.util.Map;

public class Print {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Print() {
    }

    public void printCitiesFrom(HashMap<Integer, String> hashMapCities) {
        int temporary = numberOfDigits(hashMapCities.size());
        for (Map.Entry<Integer, String> entry : hashMapCities.entrySet()) {
            System.out.printf(ANSI_BOLD + ANSI_BG_GREEN + " %" + temporary + "d " + ANSI_RESET + ANSI_GREEN + " -> %15s\n" + ANSI_RESET, (entry.getKey() + 1), entry.getValue());
        }
    }

    public void printCitiesTo(HashMap<Integer, String> hashMapCities, int from) {
        int temporary = numberOfDigits(hashMapCities.size());
        for (Map.Entry<Integer, String> entry : hashMapCities.entrySet()) {
            if (entry.getKey() == from) {
                System.out.printf(ANSI_BOLD + ANSI_RED + "<<you are in this location>> " + ANSI_RESET + ANSI_WHITE + " %" + temporary + "d " + ANSI_RESET + ANSI_GREEN + " -> %15s\n" + ANSI_RESET, (entry.getKey() + 1), entry.getValue());
            } else {
                System.out.printf(ANSI_BOLD + ANSI_BG_GREEN + " %" + temporary + "d " + ANSI_RESET + ANSI_GREEN + " -> %15s\n" + ANSI_RESET, (entry.getKey() + 1), entry.getValue());
            }
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

    public void design() {
        System.out.println(ANSI_BOLD + ANSI_GREEN + "--------------------------------------------------------------------------------------------" + ANSI_RESET);
    }

}
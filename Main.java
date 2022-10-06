import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] line = br.readLine().split(",");

            for (int i = 0; i < line.length; i++) {
                inputList.add(line[i].trim());
            }
            System.out.println(inputList);
            getWordsPerLetter(inputList);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    private static HashMap<Character, Integer> getWordsPerLetter(List<String> fruits) {
        HashMap<Character, Integer> fruitsMap = new HashMap<>();

        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            fruitsMap.put(ch, 0);
        }

        for (String fruit : fruits) {
            char fruitBeginsWith = fruit.charAt(1);
            int currentValue = fruitsMap.get(fruitBeginsWith);
            fruitsMap.replace(fruitBeginsWith, currentValue+1);
        }
        return fruitsMap;
    }
}
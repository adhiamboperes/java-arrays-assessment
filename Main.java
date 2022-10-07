import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static List<String> inputList = new ArrayList<String>();
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(
                    "Select an output format\n Enter 1 to print number of words per letter\n Enter 2 to see list of words per letter");
            int outputChoice = Integer.parseInt(br.readLine());

            System.out.println("Enter your string array input:");

            String[] line = br.readLine().split(",");

            for (int i = 0; i < line.length; i++) {
                inputList.add(line[i].trim());
            }
            chooseOutputType(outputChoice, inputList);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static void chooseOutputType(int choice, List<String> list) {
        if (choice == 1) {
            printNumberOfWordsPerLetter(list);
        } else {
            printWordsAndNumberPerLetter(list);
        }
    }

    private static void printNumberOfWordsPerLetter(List<String> fruits) {
        HashMap<Character, Integer> fruitsMap = getWordsPerLetter(fruits);
        fruitsMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        });
    }

    private static void printWordsAndNumberPerLetter(List<String> fruits) {
        HashMap<Character, List<String>> multiMap = storeWordsPerLetter(fruits);
        for (char ch = 'A'; ch <= 'Z'; ++ch) {
            if (multiMap.containsKey(ch)) {
                System.out.println(ch + ": " + multiMap.get(ch).size());
                multiMap.get(ch).forEach(fruitInList -> {
                    System.out.println(1 + " " + fruitInList.replace("\"", ""));
                });
            } else {
                System.out.println(ch + ": " + 0);
            }
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
            fruitsMap.replace(fruitBeginsWith, currentValue + 1);
        }
        return fruitsMap;
    }

    private static HashMap<Character, List<String>> storeWordsPerLetter(List<String> fruits) {
        HashMap<Character, List<String>> multiMap = new HashMap<>();

        for (String fruit : fruits) {
            char firstLetter = fruit.charAt(1);

            if (multiMap.containsKey(firstLetter)) {
                multiMap.get(firstLetter).add(fruit);
            } else {
                List<String> alphabetFruitsList = new ArrayList<>();
                alphabetFruitsList.add(fruit);
                multiMap.put(firstLetter, alphabetFruitsList);
            }
        }
        return multiMap;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.*;
import java.util.*;

public class CountFruits {

    public static void main(String[] args) {

        // String[] fruits = { "Strawberry", "Mango", "Cherry", "Lime", "Guava",
        // "Papaya", "Nectarine", "Pineapple",
        // "Lemon", "Plum", "Tangerine", "Fig", "Blueberry", "Grape", "Jackfruit",
        // "Pomegranate", "Apple", "Pear",
        // "Orange", "Watermelon", "Raspberry", "Banana" };
        List<String> inputList = new ArrayList<String>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println(
                    "Select an output format\n Enter 1 to print number of words per letter\n Enter 2 to see list of words per letter");
            int outputChoice = Integer.parseInt(br.readLine());

            inputList = getFruits();

            Main.chooseOutputType(outputChoice, inputList);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getFruits() throws IOException {
        List<String> fruits = new ArrayList<String>();

        URL url = new URL("http://exple.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();

        Reader streamReader = null;

        if (status > 299) {
            streamReader = new InputStreamReader(con.getErrorStream());
            BufferedReader in = new BufferedReader(streamReader);
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }

            System.out.println(content);
        } else {
            streamReader = new InputStreamReader(con.getInputStream());
            BufferedReader in = new BufferedReader(streamReader);

            String[] line = in.readLine().split(",");

            for (int i = 0; i < line.length; i++) {
                fruits.add(line[i].trim());
            }
        }
        con.disconnect();
        return fruits;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> inputList = new ArrayList<String>();
        Scanner stdin = new Scanner(System.in);

        System.out.println("this is the current input" + inputList.toString());
        inputList.add(stdin.next());

        stdin.close();

        System.out.println("this is the input" + inputList);

        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        // try{
        // String[] line = br.readLine().split(",");
        
        // for(int i = 0; i<line.length; i++){
        //     inputList.add(line[i]);
        // }
        // System.out.println("this is the input" + inputList);
        // }catch(IOException ioe){

        // }


    }
}
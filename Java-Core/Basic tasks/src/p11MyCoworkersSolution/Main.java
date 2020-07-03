package p11MyCoworkersSolution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	/*
	 * This is Atanas Atanasov's solution.
	 * We wanted it to compare it to mine. 
	 * 
	 * I think it has a week spot.
	 * ---> boolean checkIfTriangleNumber(int n)
	 * method starts over calculating sum each time called
     * and doesn't save previous calculated results even if repeated.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader fileReader = new BufferedReader(
                new FileReader("src" + File.separator
        				+ "p11MyCoworkersSolution" + File.separator 
        				+ "words.txt"));
        Map<Character, Integer> charsValues = new HashMap<>();
        List<String> list = new ArrayList<>();
        String line;
        
        while ((line = fileReader.readLine()) != null) {
            int wordValue = Utils.getWordValue(line, charsValues);
            boolean isTriangleNumber = Utils.checkIfTriangleNumber(wordValue);
            if (isTriangleNumber) {
                list.add(line);
            }
            
            System.out.println(String.format("%s - %b", line, isTriangleNumber));
        }

        fileReader.close();
        System.out.println(String.join(", ", list));
        System.out.println(String.format("%d total words with triangle value.", list.size()));

	}
	
	public static int getInputInteger() throws IOException {
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in)
        );
        
        return Integer.parseInt(reader.readLine());
    }

}

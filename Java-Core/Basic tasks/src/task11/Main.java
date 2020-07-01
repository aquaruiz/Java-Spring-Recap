package task11;

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

	public static void main(String[] args) throws IOException {
		BufferedReader fileReader = new BufferedReader(
                new FileReader("src" + File.separator
        				+ "task11" + File.separator 
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

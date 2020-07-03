package p11MyCoworkersSolution;

import java.util.Map;

public class Utils {
 public static int getWordValue(String word, Map<Character, Integer> map) {
        int sum = 0;
        String formattedWord = word.toLowerCase();
        
        for (int i = 0; i < formattedWord.toCharArray().length; i++) {
            char currentCharacter = formattedWord.charAt(i);
            map.putIfAbsent(currentCharacter, currentCharacter - 96);
            sum += map.get(currentCharacter);
        }

        return sum;
    }

    public static boolean checkIfTriangleNumber(int n) {
        //  1/2*N(N+1)
        if (n <= 0)
            return false;

        int sum = 0; // Problem starts over calculating sum each time 
        // and doesn't count prevs counts

        for (int i = 1; sum <= n; i++) {
            sum = sum + i;
            if (sum == n) {
                return true;
            }
        }

		return false;
	}
}

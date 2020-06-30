package task22;

public class Main {

	public static void main(String[] args) {
		String[] words = WordManager.generateRandomWordsWithLength(2, 5);
		System.out.println(String.join(", ", words));
		
		words = WordManager.generateRandomWordsWithLength(2, 5);

		System.out.println(String.join(", ", words) + " - Have g inside: " + WordManager.hasLetterInWords(words, 'g'));
	}

}

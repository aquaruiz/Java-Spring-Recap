package constants;

import java.util.Arrays;
import java.util.List;

public class Names {
	private static int index = 0;
	private static List<String> names = Arrays.asList("Sasho", "Gosho", "Ivan", "Dora", "Elly");

	public static String getNextName() {
		if (index == names.size()) {
			index = 0;
		}
		
		return names.get(index++);
	}
}

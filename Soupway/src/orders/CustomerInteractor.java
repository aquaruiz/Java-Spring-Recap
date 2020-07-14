package orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerInteractor {
	public Scanner scanner;

	public CustomerInteractor() {
		this.scanner = new Scanner(System.in);
	}

	public String getCustomerStringInput() {
		return this.scanner.nextLine().trim().toLowerCase();
	}

	public boolean getCustomerBoolenInput() {
		String input = this.scanner.nextLine().trim().toLowerCase();
		if (input.equals("y") || input.equals("yes") || input.equals("yeap") || input.equals("yea") || input.equals("yeah")) {
			return true;
		}

		return false;
	}

	public List<Integer> getCustomerIntListInput() {
		String[] input = this.scanner.nextLine().split("\\W+");
		
		return Arrays.stream(input)
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(ArrayList<Integer>::new));
	}
}

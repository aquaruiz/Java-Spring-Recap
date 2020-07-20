package orders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomerInteractor {
	private static volatile CustomerInteractor instance;

	public Scanner scanner;

	private CustomerInteractor() {
		this.scanner = new Scanner(System.in);
	}

	public static CustomerInteractor getInstance() {
		if (instance == null) {
			synchronized (CustomerInteractor.class) {
				if (instance == null)
					instance = new CustomerInteractor();
				return instance;
			}
		}

		return instance;
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

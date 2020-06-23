package exam2.problem02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		scanner.close();
		int[] nPrimeNumbers = getFirstNPrimes(n*n);
		
		StringBuilder stringBuilder = new StringBuilder();
		
		for (int i = 0; i < nPrimeNumbers.length; i++) {
			stringBuilder.append(nPrimeNumbers[i]).append(" ");
			if ((i + 1) % n == 0) {
				stringBuilder.append(System.lineSeparator());
			}
		}
		
		System.out.println(stringBuilder.toString());
 	}

	private static int[] getFirstNPrimes(int n) {
		if (n < 1) {
			return new int[0];
		}
		
		List<Integer> primes = new ArrayList<>();
		boolean isPrime = true;
		primes.add(2);

		int num = 3;
		
		while (n >= 2) {
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {
				primes.add(num);
	            n--;
	        }
			
			isPrime = true;
	        num++;
		}
		
		return primes.stream()
				.mapToInt(i -> i)
				.toArray();
	}

}

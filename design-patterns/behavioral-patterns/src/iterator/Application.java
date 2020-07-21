package iterator;

import java.util.Iterator;

public class Application {
	public static void main(String[] args) {
		IcecreamRepository repo = new IcecreamRepository();
		
		repo.addIcecream("Vanilla");
		repo.addIcecream("Strawberry");
		repo.addIcecream("Chocolate");
		
		Iterator<String> icecreamIterator = repo.iterator();
		
		while (icecreamIterator.hasNext()) {
			System.out.println(icecreamIterator.next());
		}
	}
}

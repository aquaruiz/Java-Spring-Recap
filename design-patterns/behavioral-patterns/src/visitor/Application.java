package visitor;

import java.util.ArrayList;

public class Application {
	public static void main(String[] args) {
		// normal shopping cart stuff

		ArrayList<Visitable> items = new ArrayList<>();
		items.add(new Book(5, 2.5));
		items.add(new CD("rap", 9));
		items.add(new CD("pop", 8));
		items.add(new DVD(true, 15));

		PostageVisitor visitor = new PostageVisitor();
		for (Visitable item : items) {
			item.accept(visitor);
		}

		double postage = visitor.getTotalPostage();
	}
}

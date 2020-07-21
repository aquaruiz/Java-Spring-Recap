package visitor;

public class PostageVisitor implements Visitor {
	private double totalPostageForCart;

	public double getTotalPostage() {
		return totalPostageForCart;
	}

	@Override
	public void visit(Book book) {

		if (book.getPrice() < 10.0) {
			totalPostageForCart += book.getWeight() * 2;
		}
	}

	@Override
	public void visit(CD cd) {
		if (cd.getGenre().equals("rap")) {
			totalPostageForCart += cd.getPrice() / 2;
		} else {
			totalPostageForCart += cd.getPrice();
		}

	}

	@Override
	public void visit(DVD dvd) {
		if (dvd.isSetbox()) {
			totalPostageForCart += dvd.getPrice() * 0.9;
		} else {
			totalPostageForCart += dvd.getPrice();
		}
	}
}

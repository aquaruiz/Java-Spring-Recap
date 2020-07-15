package visitor;

public class DVD implements Visitable {
	private boolean isSetbox;
	private int price;
	
	public DVD(boolean isSetbox, int price) {
		super();
		this.isSetbox = isSetbox;
		this.price = price;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public boolean isSetbox() {
		return isSetbox;
	}
	
	public int getPrice() {
		return price;
	}
}

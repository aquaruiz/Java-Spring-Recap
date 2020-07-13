package composite;

public abstract class Item {
	public abstract int getPrice();

	public void addItem(Item item) {
		throw new UnsupportedOperationException("This is not alowed");
	}
}

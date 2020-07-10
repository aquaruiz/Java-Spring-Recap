package composite;

public class Product extends Item {
	private int price;
	
	public Product(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}

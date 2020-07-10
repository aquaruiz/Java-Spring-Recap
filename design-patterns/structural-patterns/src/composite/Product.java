package composite;

public class Product extends Item {
	private int price;
	private String name;
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
}

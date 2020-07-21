package composite;

public class Application {

	public static void main(String[] args) {
		Box myBox = new Box();
		Box littleBox = new Box();
		
		Product sunGlasses = new Product("sunGlasses", 120);
		Product hat = new Product("hat", 350);

		littleBox.addItem(sunGlasses);

		myBox.addItem(hat);
		myBox.addItem(littleBox);
		
		int totalPrice = myBox.getPrice();
		System.out.println(totalPrice);
	}

}

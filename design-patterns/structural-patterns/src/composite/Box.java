package composite;

import java.util.ArrayList;
import java.util.List;

public class Box extends Item {
	List<Item> items;
	
	public Box() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	@Override
	public int getPrice() {
		int totalPrice = 0;

		if (this.items.size() == 0) {
			return totalPrice;
		}
		
		
		for (Item item : items) {
			totalPrice += item.getPrice();
		}
		
		return totalPrice;
	}
}

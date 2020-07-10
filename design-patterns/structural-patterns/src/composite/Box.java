package composite;

import java.util.ArrayList;
import java.util.List;

public class Box extends Item {
	List<Item> items;
	
	public Box() {
		this.items = new ArrayList<>();
	}
	
	private void addItem(Item item) {
		this.items.add(item);
	}
	
	int calcBoxPrice() {
		if (this.items.size() == 0) {
			return 0;
		}
		
		int totalPrice = 0;
		
		for (Item item : items) {
			
		}
		
		return totalPrice;
	}
}

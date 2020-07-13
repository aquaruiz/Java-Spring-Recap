package kitchenFactory;

import menu.Soupable;

public interface AbstractKitchenFactory {
	
	Soupable cookSoup();
	
	Bread bakeBread();
	
	Icecream makeIcecream();
}

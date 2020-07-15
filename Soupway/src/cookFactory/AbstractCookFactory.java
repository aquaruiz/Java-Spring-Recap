package cookFactory;

import constants.Bread;
import constants.IceCream;
import menu.Soup;

public interface AbstractCookFactory {
		
	Soup cookSoup();
	
	Enum<Bread> addBread();
	
	Enum<IceCream> addIcecream();

}

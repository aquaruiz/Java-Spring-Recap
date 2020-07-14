package cookFactory;

import orders.CustomerInteractor;

public class CookFactoryManager {
	public static AbstractCookFactory getFactory(Boolean isVegetarian, CustomerInteractor customerInteractor) {
		
		if (isVegetarian) {
			return new VegeratianFactory(customerInteractor);
		}
		
		return new StandartFactory(customerInteractor);
	}
}

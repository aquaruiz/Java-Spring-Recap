package cookFactory;

public class CookFactoryManager {
	public static AbstractCookFactory getFactory(Boolean isVegetarian) {
		
		if (isVegetarian) {
			return new VegeratianFactory();
		}
		
		return new StandartFactory();
	}
}

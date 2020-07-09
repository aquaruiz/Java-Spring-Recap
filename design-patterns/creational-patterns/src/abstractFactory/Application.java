package abstractFactory;

import abstractFactory.furnitures.Chair;
import abstractFactory.furnitures.CoffeeTable;
import abstractFactory.furnitures.Sofa;

public class Application {

	public static void main(String[] args) {
		FurnitureStyle myNewStyle = FurnitureStyle.MODERN;
		
		AbstractFurnitureFactory myFactory = ConfigManager.getFactory(myNewStyle);
		Chair myNewChair = myFactory.createChair();
		Sofa myNewSofa = myFactory.createSofa();
		CoffeeTable myNewCofeeTable = myFactory.createCoffeeTable();
	}
}

package abstractFactory;

import abstractFactory.furnitures.Chair;
import abstractFactory.furnitures.CoffeeTable;
import abstractFactory.furnitures.Sofa;

public interface AbstractFurnitureFactory {
	Chair createChair();
	CoffeeTable createCoffeeTable();
	Sofa createSofa();
}

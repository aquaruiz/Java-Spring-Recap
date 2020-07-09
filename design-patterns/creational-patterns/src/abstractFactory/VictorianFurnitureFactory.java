package abstractFactory;

import abstractFactory.furnitures.Chair;
import abstractFactory.furnitures.CoffeeTable;
import abstractFactory.furnitures.Sofa;
import abstractFactory.furnitures.impl.VictorianChair;

public class VictorianFurnitureFactory implements AbstractFurnitureFactory {

	@Override
	public Chair createChair() {
		return new VictorianChair();
	}

	@Override
	public CoffeeTable createCoffeeTable() {
		return null;
	}

	@Override
	public Sofa createSofa() {
		// TODO Auto-generated method stub
		return null;
	}

}

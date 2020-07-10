package abstractFactory.furnitures.impl;

import abstractFactory.furnitures.Sofa;

public class VictorianSofa implements Sofa {

	@Override
	public boolean isComfortable() {
		return true;
	}

	@Override
	public int getPersonCapasity() {
		return 2;
	}

}

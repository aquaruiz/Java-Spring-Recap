package abstractFactory.furnitures.impl;

import abstractFactory.furnitures.Sofa;

public class ModernSofa implements Sofa {

	@Override
	public boolean isComfortable() {
		return false;
	}

	@Override
	public int getPersonCapasity() {
		return 1;
	}

}

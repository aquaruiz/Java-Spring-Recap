package cookFactory;

import constants.Bread;
import constants.IceCream;
import menu.Soup;

public class StandartFactory implements AbstractCookFactory {
	private CookFacade cookFacade;

	public StandartFactory() {
		this.cookFacade = new CookFacade();
	}

	@Override
	public Soup cookSoup() {
		Soup mySoup = cookFacade.cookVegetarianSoup();
		mySoup = cookFacade.addMeat(mySoup);
		mySoup = cookFacade.addCheese(mySoup);

		return mySoup;
	}

	@Override
	public Enum<Bread> addBread() {
		return cookFacade.getBread();
	}

	@Override
	public Enum<IceCream> addIcecream() {
		return cookFacade.getIceCream();
	}

}

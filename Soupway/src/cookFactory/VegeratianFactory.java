package cookFactory;

import constants.Bread;
import constants.IceCream;
import menu.Soup;

public class VegeratianFactory implements AbstractCookFactory {
	private CookFacade cookFacade;

	public VegeratianFactory() {
		this.cookFacade = new CookFacade();
	}

	@Override
	public Soup cookSoup() {
		return cookFacade.cookVegetarianSoup();
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

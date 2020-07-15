package cookFactory;

import constants.Bread;
import constants.IceCream;
import menu.Soup;
import orders.CustomerInteractor;

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
	public Enum<Bread> bakeBread() {
		return cookFacade.getBread();
	}

	@Override
	public Enum<IceCream> makeIcecream() {
		return cookFacade.getIceCream();
	}

}

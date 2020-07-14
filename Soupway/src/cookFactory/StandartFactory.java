package cookFactory;

import constants.Bread;
import constants.IceCream;
import menu.Soup;
import orders.CustomerInteractor;

public class StandartFactory implements AbstractCookFactory {
	private CustomerInteractor customerInteractor; // TODO remove it from here
	private CookFacade cookFacade;

	public StandartFactory(CustomerInteractor customerInteractor) {
		this.cookFacade = new CookFacade(customerInteractor);
	}

	@Override
	public Soup cookSoup() {
		Soup mySoup = cookFacade.cookVegetarianSoup();
		mySoup = cookFacade.addMeat(mySoup);
		mySoup = cookFacade.addCheese(mySoup);

		// print result
		return mySoup;
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

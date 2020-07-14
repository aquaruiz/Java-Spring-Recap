package cookFactory;

import constants.Bread;
import constants.IceCream;
import menu.Soup;
import orders.CustomerInteractor;

public class VegeratianFactory implements AbstractCookFactory {
	private CustomerInteractor customerInteractor;
	private CookFacade cookFacade;

	public VegeratianFactory(CustomerInteractor customerInteractor) {
		this.customerInteractor = customerInteractor;
		this.cookFacade = new CookFacade(customerInteractor);
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

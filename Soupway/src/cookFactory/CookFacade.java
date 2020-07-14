package cookFactory;

import java.util.List;

import constants.Bread;
import constants.Cheese;
import constants.IceCream;
import constants.Meat;
import menu.CheeseSoup;
import menu.MeatSoup;
import menu.Soup;
import menu.VegetarianSoup;
import orders.CustomerInteractor;

public class CookFacade {
	private CustomerInteractor customerInteractor;
	 
	public CookFacade(CustomerInteractor customerInteractor) {
		this.customerInteractor = customerInteractor;
	}
	
	public Soup cookVegetarianSoup() {
		return new VegetarianSoup(); // TODO
	}

	public Soup addCheese(Soup mySoup) {
		System.out.println("Do you want cheese in your soup? (Y/n)");
		boolean isWithCheese = customerInteractor.getCustomerBoolenInput();

		if (isWithCheese) {
			System.out.println("We are offering:\n");

			printCurrentStock(Cheese.values());

			System.out.println("Please choose one or more indredients in format: (1, 2, 2, 1)\n");
			List<Integer> cheeseCodes = customerInteractor.getCustomerIntListInput();

			for (int i = 0; i < cheeseCodes.size(); i++) {
				Enum currentCheese = Cheese.values[cheeseCodes.get(i) - 1];
				mySoup = new CheeseSoup(mySoup, currentCheese.toString().toLowerCase());
			}
		}

		return mySoup;
	}

	private <E extends Enum<E>> void printCurrentStock(E[] values) {
		for (E type : values) {
			System.out.print(String.format("%d. %s ", type.ordinal() + 1, type.toString().toLowerCase()));
		}		
		
		System.out.println();
	}

	public Soup addMeat(Soup mySoup) {
		System.out.println("Do you want meat in your soup? (Y/n)");
		boolean isWithMeat = customerInteractor.getCustomerBoolenInput();

		if (isWithMeat) {
			System.out.println("We are offering:\n");

			printCurrentStock(Meat.values);

			System.out.println("Please choose one or more indredients in format: (1, 2, 2, 1)\n");
			List<Integer> meatCodes = customerInteractor.getCustomerIntListInput();

			for (int i = 0; i < meatCodes.size(); i++) {
				Enum currentMeat = Meat.values[meatCodes.get(i) - 1];
				mySoup = new MeatSoup(mySoup, currentMeat.toString().toLowerCase());
			}
		}

		return mySoup;
	}

//	private void printCurrentMealStock() {
//		for (Meat meatType : Meat.values()) {
//			System.out.print(String.format("%d. %s ", meatType.ordinal() + 1, meatType.toString().toLowerCase()));
//		}
//	}

	public Enum<Bread> getBread() {
		return Bread.BROWN;
	}

	public Enum<IceCream> getIceCream() {
		return IceCream.VANILLA;
	}

}

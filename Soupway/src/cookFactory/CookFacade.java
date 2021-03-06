package cookFactory;

import java.util.ArrayList;
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

	public CookFacade() {
		this.customerInteractor = CustomerInteractor.getInstance();
	}

	public Soup cookVegetarianSoup() {
		return new VegetarianSoup();
	}

	public Soup addCheese(Soup mySoup) {
		System.out.println("Do you want cheese in your soup? (Y/n)");
		boolean isWithCheese = customerInteractor.getCustomerBoolenInput();

		if (isWithCheese) {
			System.out.println("We are offering:\n");
			printCurrentStock(Cheese.values());

			System.out.println("Please choose one or more indredients in format: (1, 2, 2, 1)\n");
			List<Integer> cheeseCodes = customerInteractor.getCustomerIntListInput();
			List<String> cheeseNames = new ArrayList<>();
			
			for (int i = 0; i < cheeseCodes.size(); i++) {
				try {
					Enum<Cheese> currentCheese = Cheese.values[cheeseCodes.get(i) - 1];
					cheeseNames.add(currentCheese.toString());
				} catch (Exception e) {
					System.out.println("We do not offer # " + cheeseCodes.get(i));
				}
			}
			
			mySoup = new CheeseSoup(mySoup, cheeseNames);
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
			List<String> meatNames = new ArrayList<>();
			
			for (int i = 0; i < meatCodes.size(); i++) {
				try {
					Enum<Meat> currentMeat = Meat.values[meatCodes.get(i) - 1];
					meatNames.add(currentMeat.toString());
				} catch (Exception e) {
					System.out.println("We do not offer # " + meatCodes.get(i));
				}
			}
			
			mySoup = new MeatSoup(mySoup, meatNames);
		}

		return mySoup;
	}

	public Enum<Bread> getBread() {
		return Bread.BROWN;
	}

	public Enum<IceCream> getIceCream() {
		return IceCream.VANILLA;
	}
}

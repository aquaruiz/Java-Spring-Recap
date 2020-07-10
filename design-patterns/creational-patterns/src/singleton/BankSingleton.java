package singleton;

public class BankSingleton {

	private static volatile BankSingleton instance;

	private BankSingleton() {}

	public static BankSingleton getInstance() {
		if (instance == null) {
			synchronized (BankSingleton.class) {
				if (instance == null)
					instance = new BankSingleton();
					return instance;
			}
		}

		return instance;
	}

}

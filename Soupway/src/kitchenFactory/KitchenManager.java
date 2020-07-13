package kitchenFactory;

public class KitchenManager {
	public static AbstractKitchenFactory getFactory(StarsCategory stars) {
		switch (stars) {
		case THREE_STAR:
			return new PublicFactory();
		case FOUR_STAR:
			return new PremiumFactory();
		default:
			throw new UnsupportedOperationException("No such factory yet");
		}
	}
}

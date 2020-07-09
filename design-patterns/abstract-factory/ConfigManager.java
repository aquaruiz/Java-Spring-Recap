package abstractFactory;

public class ConfigManager {

	public static AbstractFurnitureFactory getFactory(FurnitureStyle style) {
		switch (style) {
		case MODERN:
			return new ModernFurnitureFactory();
		case VICTORIAN:
			return new VictorianFurnitureFactory();
		default:
			throw new UnsupportedOperationException("No such factory yet");
		}
	}

}

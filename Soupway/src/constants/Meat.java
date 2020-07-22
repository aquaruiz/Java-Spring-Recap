package constants;

public enum Meat {
	CHICKEN, BEEF, PORK;

	public static final Meat values[] = values();

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}

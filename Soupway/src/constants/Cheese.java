package constants;

public enum Cheese {
	PARMESAN, BRI, MOZZARELLA;
	
	public static final Cheese values[] = values();
	
	@Override
	public String toString() {
		return name().toLowerCase();
	}

}

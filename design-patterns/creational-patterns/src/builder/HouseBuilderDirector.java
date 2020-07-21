package builder;

public class HouseBuilderDirector {
	/*
	 * Having a director class in your program isn’t strictly necessary.
	 */
	private HouseBuilder builder;
	

	public HouseBuilderDirector(HouseBuilder builder) {
		this.builder = builder;
	}
	
	public boolean changeBuilder(HouseBuilder builder) {
		this.builder = builder;
		
		return true;
	}

	public House makeFast() {
		return this.builder
				.addWalls()
				.addDoors()
				.addRoof()
				.addWindows()
				.build();
	}
	
	public House makeGood() {
		return this.builder.
				addWalls()
				.addDoors()
				.addRoof()
				.addWindows()
				.addGarage()
				.addPool()
				.build();
	}
}

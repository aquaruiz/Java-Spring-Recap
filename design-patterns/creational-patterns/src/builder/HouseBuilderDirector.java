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
		return this.builder.buildWalls().buildDoors().buildRoof().buildWindows().getResult();
	}
	
	public House makeGood() {
		return this.builder.
				buildWalls()
				.buildDoors()
				.buildRoof()
				.buildWindows()
				.buildGarage()
				.buildPool()
				.getResult();
	}
}

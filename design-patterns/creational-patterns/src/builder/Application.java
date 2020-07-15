package builder;

public class Application {
	public static void main(String[] args) {
		HouseBuilder stoneHouseBuilder = new StoneHouseBuilder();
		HouseBuilderDirector director = new HouseBuilderDirector(stoneHouseBuilder);
		
		HouseBuilder cabinBuilder = new WoodenCabinBuilder();

		director.changeBuilder(cabinBuilder);
		
		House myCabin = director.makeFast();
	}
}

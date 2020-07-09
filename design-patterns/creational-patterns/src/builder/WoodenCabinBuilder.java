package builder;

public class WoodenCabinBuilder implements HouseBuilder {
	private House result;

	public WoodenCabinBuilder() {
		this.result = new House();
	}
	
	@Override
	public HouseBuilder buildWalls() {
		this.result.setWalls(4);
		return this;
	}

	@Override
	public HouseBuilder buildDoors() {
		this.result.setDoor(1);
		return this;
	}

	@Override
	public HouseBuilder buildWindows() {
		this.result.setWindows(2);
		return this;
	}

	@Override
	public HouseBuilder buildRoof() {
		this.result.setRoof(1);
		return this;
	}

	@Override
	public HouseBuilder buildGarage() {
		this.result.setGarage(false);
		return this;
	}

	@Override
	public HouseBuilder buildPool() {
			this.result.setPool(false);
		return this;
	}

	@Override
	public House getResult() {
		return this.result;
	}
	

	@Override
	public boolean reset() {
		this.result = new House();
		return true;
	}
}

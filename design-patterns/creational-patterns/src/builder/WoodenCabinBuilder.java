package builder;

public class WoodenCabinBuilder implements HouseBuilder {
	private House woodenCabin;

	public WoodenCabinBuilder() {
		this.woodenCabin = new House();
	}
	
	@Override
	public HouseBuilder addWalls() {
		this.woodenCabin.setWalls(4);
		return this;
	}

	@Override
	public HouseBuilder addDoors() {
		this.woodenCabin.setDoor(1);
		return this;
	}

	@Override
	public HouseBuilder addWindows() {
		this.woodenCabin.setWindows(2);
		return this;
	}

	@Override
	public HouseBuilder addRoof() {
		this.woodenCabin.setRoof(1);
		return this;
	}

	@Override
	public HouseBuilder addGarage() {
		this.woodenCabin.setGarage(false);
		return this;
	}

	@Override
	public HouseBuilder addPool() {
			this.woodenCabin.setPool(false);
		return this;
	}

	@Override
	public House build() {
		House currentResult = this.woodenCabin;
		this.reset();
		return currentResult;
	}
	

	@Override
	public boolean reset() {
		this.woodenCabin = new House();
		return true;
	}
}

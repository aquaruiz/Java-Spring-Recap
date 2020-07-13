package builder;

public class WoodenCabinBuilder implements HouseBuilder {
	private House result;

	public WoodenCabinBuilder() {
		this.result = new House();
	}
	
	@Override
	public HouseBuilder addWalls() {
		this.result.setWalls(4);
		return this;
	}

	@Override
	public HouseBuilder addDoors() {
		this.result.setDoor(1);
		return this;
	}

	@Override
	public HouseBuilder addWindows() {
		this.result.setWindows(2);
		return this;
	}

	@Override
	public HouseBuilder addRoof() {
		this.result.setRoof(1);
		return this;
	}

	@Override
	public HouseBuilder addGarage() {
		this.result.setGarage(false);
		return this;
	}

	@Override
	public HouseBuilder addPool() {
			this.result.setPool(false);
		return this;
	}

	@Override
	public House build() {
		House currentResult = this.result;
		this.reset();
		return currentResult;
	}
	

	@Override
	public boolean reset() {
		this.result = new House();
		return true;
	}
}

package builder;

public class StoneHouseBuilder implements HouseBuilder {
	private House result;

	public StoneHouseBuilder() {
		this.result = new House();
	}

	@Override
	public HouseBuilder addWalls() {
		this.result.setWalls(28);
		return this;
	}

	@Override
	public HouseBuilder addDoors() {
		this.result.setDoor(4);
		return this;
	}

	@Override
	public HouseBuilder addWindows() {
		this.result.setWalls(28 * 2);
		return this;
	}

	@Override
	public HouseBuilder addRoof() {
		this.result.setRoof(2);
		return this;
	}

	@Override
	public HouseBuilder addGarage() {
		this.result.setGarage(true);
		return this;
	}

	@Override
	public HouseBuilder addPool() {
		this.result.setPool(true);
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

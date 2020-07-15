package builder;

public class StoneHouseBuilder implements HouseBuilder {
	private House stoneHouse;

	public StoneHouseBuilder() {
		this.stoneHouse = new House();
	}

	@Override
	public HouseBuilder addWalls() {
		this.stoneHouse.setWalls(28);
		return this;
	}

	@Override
	public HouseBuilder addDoors() {
		this.stoneHouse.setDoor(4);
		return this;
	}

	@Override
	public HouseBuilder addWindows() {
		this.stoneHouse.setWalls(28 * 2);
		return this;
	}

	@Override
	public HouseBuilder addRoof() {
		this.stoneHouse.setRoof(2);
		return this;
	}

	@Override
	public HouseBuilder addGarage() {
		this.stoneHouse.setGarage(true);
		return this;
	}

	@Override
	public HouseBuilder addPool() {
		this.stoneHouse.setPool(true);
		return this;
	}

	@Override
	public House build() {
		House currentResult = this.stoneHouse;
		this.reset();
		return currentResult;
	}

	@Override
	public boolean reset() {
		this.stoneHouse = new House();
		return true;
	}
}

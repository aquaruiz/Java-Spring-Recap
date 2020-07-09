package builder;

public class StoneHouseBuilder implements HouseBuilder {
	private House result;

	public StoneHouseBuilder() {
		this.result = new House();
	}

	@Override
	public HouseBuilder buildWalls() {
		this.result.setWalls(28);
		return this;
	}

	@Override
	public HouseBuilder buildDoors() {
		this.result.setDoor(4);
		return this;
	}

	@Override
	public HouseBuilder buildWindows() {
		this.result.setWalls(28 * 2);
		return this;
	}

	@Override
	public HouseBuilder buildRoof() {
		this.result.setRoof(2);
		return this;
	}

	@Override
	public HouseBuilder buildGarage() {
		this.result.setGarage(true);
		return this;
	}

	@Override
	public HouseBuilder buildPool() {
		this.result.setPool(true);
		return this;
	}

	@Override
	public House getResult() {
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

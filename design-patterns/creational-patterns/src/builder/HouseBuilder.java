package builder;

interface HouseBuilder {
	
	HouseBuilder addWalls();
	HouseBuilder addDoors();
	HouseBuilder addWindows();
	HouseBuilder addRoof();
	HouseBuilder addGarage();
	HouseBuilder addPool();
	boolean reset();
	
	House build();
}

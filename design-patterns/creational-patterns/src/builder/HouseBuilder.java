package builder;

interface HouseBuilder {
	
	HouseBuilder buildWalls();
	HouseBuilder buildDoors();
	HouseBuilder buildWindows();
	HouseBuilder buildRoof();
	HouseBuilder buildGarage();
	HouseBuilder buildPool();
	boolean reset();
	
	House getResult();
}

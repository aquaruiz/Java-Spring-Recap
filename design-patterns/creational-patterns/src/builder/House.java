package builder;

public class House {
	private int walls;
	private int windows;
	private int door;
	private int roof;
	private boolean garage;
	private boolean pool;
	
	public House() {
	}
	
	public void setWalls(int walls) {
		this.walls = walls;
	}
	
	public void setWindows(int windows) {
		this.windows = windows;
	}
	
	public void setDoor(int door) {
		this.door = door;
	}
	
	public void setRoof(int roof) {
		this.roof = roof;
	}
	
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	
	public void setPool(boolean pool) {
		this.pool = pool;
	}
}

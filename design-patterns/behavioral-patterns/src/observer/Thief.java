package observer;

public class Thief {

	private boolean isEntering;
	
	public Thief() {
		this.isEntering = false;
	}
	
	public void enter() {
		this.isEntering = true;
	}

	public boolean isEntering() {
		return this.isEntering;
	}
}

package observer;

class Surveillance implements AlarmListener {
	public void alarm() {
		System.out.println("Surveillance - by the numbers:");
		System.out.println("   establish a perimeter");
		isolate();
		System.out.println("   identify the source");
	}

	protected void isolate() {
		System.out.println("   train the cameras");
	}
}

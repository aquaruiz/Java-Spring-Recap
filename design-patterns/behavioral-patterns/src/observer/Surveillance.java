package observer;

class Surveillance implements AlarmListener {
	public void alarm() {
		System.out.println("Surveillance - by the numbers:");
		System.out.println("   establish a perimeter");
		System.out.println("   train the cameras");
		System.out.println("   identify the source");
	}
}

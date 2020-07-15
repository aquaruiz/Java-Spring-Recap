package observer;

public class Application {
	public static void main(String[] args) {
		SensorSystem sensorSystem = new SensorSystem();
		sensorSystem.register(new Gates());
		sensorSystem.register(new Lighting());
		sensorSystem.register(new Surveillance());
		
		Thief thief = new Thief();
		thief.enter();
		
		if (thief.isEntering()) {
			sensorSystem.soundTheAlarm();
		}
	}
}

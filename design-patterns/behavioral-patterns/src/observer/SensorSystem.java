package observer;

import java.util.ArrayList;
import java.util.List;

public class SensorSystem {
	private List<AlarmListener> listeners = new ArrayList<>();

	public void register(AlarmListener alarmListener) {
		listeners.add(alarmListener);
	}

	public void soundTheAlarm() {
		for (AlarmListener alarmListener : listeners) {
			alarmListener.alarm();
		}
	}
}

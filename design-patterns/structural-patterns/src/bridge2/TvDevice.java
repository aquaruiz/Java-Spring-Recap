package bridge2;

public class TvDevice extends EntertainmentDevice {

	public TvDevice(int deviceState, int maxSetting) {
		this.deviceState = deviceState;
		this.maxSetting = maxSetting;
	}
	
	@Override
	public void buttonFivePressed() {
		System.out.println("Channel down");
		deviceState--;
	}

	@Override
	public void buttonSixPressed() {
		System.out.println("Channel up");
		deviceState++;
	}

}

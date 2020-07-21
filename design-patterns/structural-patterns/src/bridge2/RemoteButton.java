package bridge2;

public abstract class RemoteButton {
	private EntertainmentDevice device;
	
	public RemoteButton(EntertainmentDevice device) {
		this.device = device;
	}
	

	public void buttonFivePressed() {
		this.device.buttonFivePressed();
	}
	

	public void buttonSixPressed() {
		this.device.buttonSixPressed();
	}
	
	public void deviceFeedback() {
		this.device.deviceFeedback();
	}
	
	public abstract void buttonNinePressed();
}

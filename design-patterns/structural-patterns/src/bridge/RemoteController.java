package bridge;

public class RemoteController {
	private Device device;
	private boolean on;
	private boolean off;
	
	public RemoteController(Device device) {
		this.device = device;
	}
	
	public void togglePower() {
		if (on) {
			on = false;
			off = true;
		} else {
			on = true;
			off = false;
		}
	}
	
	public void volumeDown() {
		int newVolume = device.getVolume();
		newVolume -= 10;
		device.setVolume(newVolume);
	}
	
	public void volumeUp() {
		int newVolume = device.getVolume();
		newVolume += 10;
		device.setVolume(newVolume);
	}
	
	public void channelDown() {
		int newChannel = device.getChannel();
		newChannel--;
		device.setChannel(newChannel);
	}
	
	public void channelUp() {
		int newChannel = device.getChannel();
		newChannel++;
		device.setChannel(newChannel);
	}
}

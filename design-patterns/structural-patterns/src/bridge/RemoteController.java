package bridge;

public class RemoteController {
	protected Device device;
	
	public RemoteController(Device device) {
		this.device = device;
	}
	
	public void togglePower() {
		if (device.isEnabled()) {
			device.disable();
		} else {
			device.enable();
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

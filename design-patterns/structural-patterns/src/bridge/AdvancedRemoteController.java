package bridge;

public class AdvancedRemoteController extends RemoteController {

	public AdvancedRemoteController(Device device) {
		super(device);
	}

	void mute () {
		super.device.setVolume(0);
	}

}

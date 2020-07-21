package bridge2;

public class TvRemotePause extends RemoteButton {

	public TvRemotePause(EntertainmentDevice device) {
		super(device);
	}

	@Override
	public void buttonNinePressed() {
		System.out.println("TV was paused");
		
	}

}

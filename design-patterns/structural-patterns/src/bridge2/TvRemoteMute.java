package bridge2;

public class TvRemoteMute extends RemoteButton {

	public TvRemoteMute(EntertainmentDevice device) {
		super(device);
	}

	@Override
	public void buttonNinePressed() {
		System.out.println("TV was muted");
		
	}

}

package bridge2;

public class App {

	public static void main(String[] args) {
		RemoteButton tv = new TvRemoteMute(new TvDevice(1, 200));
		RemoteButton secondTv = new TvRemotePause(new TvDevice(1, 200));
		
		System.out.println("Test TV was mute:");
		tv.buttonFivePressed();
		tv.buttonNinePressed();
		
		System.out.println("Test TV was paused:");
		secondTv.buttonNinePressed();
	}

}

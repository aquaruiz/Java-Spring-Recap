package bridge;

public class Application {
	public static void main(String[] args) {
		Tv myNewTv = new Tv();
		RemoteController tvRemote = new RemoteController(myNewTv);
		tvRemote.togglePower();
		
		Radio myOldRadio = new Radio();
		AdvancedRemoteController radioRemote = new AdvancedRemoteController(myOldRadio);
		radioRemote.mute();
	}
}

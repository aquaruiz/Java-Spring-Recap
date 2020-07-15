package objectPool;

public class NoAvailableIntstanceException extends Exception {
	public NoAvailableIntstanceException(){
		super("No more free usables");
	}
}

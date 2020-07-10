package objectPool;

public class NotFreeInstanceException extends Exception {
	public NotFreeInstanceException(){
		super("No more free usables");
	}
}

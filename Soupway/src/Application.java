import bar.Bar;
import exceptions.IllegalCloningException;
import exceptions.NoFreeSoupSellersException;

public class Application {
	public static void main(String[] args) throws InterruptedException, NoFreeSoupSellersException, IllegalCloningException {
		Bar soupWayBar = null;

		System.out.println("Welcome to Soupway! The soup paradise!");

		soupWayBar = new Bar();
		soupWayBar.run();
	}
}

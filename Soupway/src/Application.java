import bar.Bar;

public class Application {
	public static void main(String[] args) throws InterruptedException {
		Bar soupWayBar = null;
		
		System.out.println("Welcome to Soupway! The soup paradise!");
		
		while(soupWayBar == null) {
			try {
				soupWayBar = new Bar();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				Thread.sleep(1000);
			}
		}
		
		soupWayBar.run();
	}
}

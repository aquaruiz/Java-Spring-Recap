package proxy2;

public class App {
	public static void main(String[] args) {

		Internet internet = new ProxyInternet();

		try {
			internet.connectTo("abv.org");
			internet.connectTo("abc.com");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

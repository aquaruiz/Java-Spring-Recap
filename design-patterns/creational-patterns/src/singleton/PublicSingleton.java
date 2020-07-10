package singleton;

public class PublicSingleton {
	private static final PublicSingleton instance = new PublicSingleton();
	
	private PublicSingleton() {}
	
	public static synchronized PublicSingleton getInstance() {
		return instance;
	}
}

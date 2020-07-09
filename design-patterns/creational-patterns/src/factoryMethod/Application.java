package factoryMethod;

public class Application {
	static Archiver archiver;
	
	public static void initalize() {
		String currentOs = System.getProperty("os.name");
		
		if (currentOs.equals("Windows")) {
			archiver = new WindowsArchiver();
		} else if (currentOs.equals("Linux")) {
			archiver = new LinuxArchiver();
		} else {
			throw new UnsupportedOperationException("Unknown operation system.");
		}
	}
	
	public static void main(String[] args) {
		initalize();
		FileArchive myNewArchive = archiver.createFileArchive();
		
//		System.out.println(myNewArchive.getDetails());
	}
}

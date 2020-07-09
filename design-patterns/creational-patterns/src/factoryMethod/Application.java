package factoryMethod;

public class Application {
	static Archiver archiver;
	
	public static void initalize() {
		String currentOs = System.getProperty("os.name");
		
		try {

			OperationSystem os = OperationSystem.valueOf(currentOs.toUpperCase());
				
			archiver = ArchiverFactory.createArchive(os);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		initalize();
		FileArchive myNewArchive = archiver.createFileArchive();
		
//		System.out.println(myNewArchive.getDetails());
	}
}

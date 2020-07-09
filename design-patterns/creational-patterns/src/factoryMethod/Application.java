package factoryMethod;

public class Application {
	static Archiver archiver;
	
	public static void main(String[] args) {
		String currentOs = System.getProperty("os.name");

		try {
			OperationSystem os = OperationSystem.valueOf(currentOs);
			archiver = ArchiverFactory.createArchive(os);
		
			FileArchive myNewArchive = archiver.createFileArchive();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package factoryMethod;

public class ArchiverFactory {
	
	public static Archiver createArchive(OperationSystem os) throws UnsupportedOperationException {
		switch (os) {
			case LINUX:
				return new LinuxArchiver();
			case WINDOWS:
				return new WindowsArchiver();
			default:
				throw new UnsupportedOperationException("Unknown operation system.");
		}
	}
	
}

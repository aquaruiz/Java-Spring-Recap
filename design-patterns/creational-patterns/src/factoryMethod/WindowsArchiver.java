package factoryMethod;

public class WindowsArchiver extends Archiver {

	@Override
	public FileArchive createFileArchive() {
		return new RarFileArchive();
	}

}

package factoryMethod;

public class WindowsArchiver implements Archiver {

	@Override
	public FileArchive createFileArchive() {
		return new RarFileArchive();
	}

}

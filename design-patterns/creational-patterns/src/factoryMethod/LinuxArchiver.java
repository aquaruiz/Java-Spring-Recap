package factoryMethod;

public class LinuxArchiver implements Archiver {

	@Override
	public FileArchive createFileArchive() {
		return new ZipFileArchive();
	}

}

package factoryMethod;

public class LinuxArchiver extends Archiver {

	@Override
	public FileArchive createFileArchive() {
		return new ZipFileArchive();
	}

}

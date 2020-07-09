package factory;

public class LinuxArchiver extends Archiver {

	@Override
	public FileArchive createFileArchive() {
		return new ZipFileArchive();
	}

}

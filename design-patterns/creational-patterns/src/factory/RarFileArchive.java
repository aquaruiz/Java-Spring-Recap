package factory;

import java.io.File;

public class RarFileArchive implements FileArchive {

	@Override
	public String getDetails() {
		return "This is a RAR archive";
	}

	@Override
	public File[] extract() {
		return new File[0];
	}

	@Override
	public boolean archive(File[] files) {
		return false;
	}
}


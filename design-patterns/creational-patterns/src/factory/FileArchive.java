package factory;

import java.io.File;

public interface FileArchive {
	String getDetails();
	File[] extract();
	boolean archive(File[] files);
}

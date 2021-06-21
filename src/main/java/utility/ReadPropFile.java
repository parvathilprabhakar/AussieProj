package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

	Properties properties;
	FileInputStream fStream;

	public Properties getPropData() throws IOException {
		String propFilePath = System.getProperty("user.dir");
		fStream = new FileInputStream(propFilePath + "\\Utils\\data.properties");
		properties = new Properties();
		properties.load(fStream);
		return properties;
	}

}

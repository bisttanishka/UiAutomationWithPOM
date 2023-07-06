package uiautomation.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	

// First, we need to read the property file.
//Then we need to load that
	
//Now we need to get key and value from the property files.
//NOTE IF ANY METHOD, VARIABLE IS STATIC WITHIN A CLASS THEN WE CAN ACCESS THEM DIRECTLY BY USING <CLASS NAME.>.Because static variable and methods are being loaded during class load time.
//AND IF THE METHOD, VARIAVLE ARE NOT STATIC THE WE NEED TO CREATE THE OBJECT OF THAT CLASS TO ACCESS THEM. 
public static Properties prop;	
static File file;
static FileReader reader;
public static void loadProperties() throws IOException {
		prop = new Properties();
		file = new File(
				System.getProperty("user.dir")
						+ "/src/main/java/properties/credential.properties");

		reader = new FileReader(file);
		prop.load(reader);// this is to load the file

	}

public static String getProperties(String data) throws IOException {
	loadProperties();
	String dataValue = prop.getProperty(data);// this is to get value from property file by providing key.
	return dataValue;

}


}

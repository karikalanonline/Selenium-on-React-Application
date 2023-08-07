package properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	public static void main(String[] args) throws IOException {
		//setup path of the properties file
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		
		//Create a object for the properties file
		Properties prop = new Properties();
		
		//load the properties file using prop object
		prop.load(fis);
		
		//to read the data from the properties file
		String property = prop.getProperty("username");
		System.out.println(property);
		
		System.out.println(prop.getProperty("password"));
		
	}

}

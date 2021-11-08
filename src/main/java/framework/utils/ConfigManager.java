package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

	public static Properties prop;
	
	final static String PATH_TO_PROPERTIES = "src/main/resources/config.properties";

	public static Properties getConfigProperties() {
		if (prop == null) {
			prop = new Properties();
			readConfigPropertiesFromFile();
		}
		return prop;
	}

	public static void readConfigPropertiesFromFile() {
		try {
			FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
			prop.load(fileInputStream);
		} catch (IOException e) {
			System.out.println("File not found");
		}
	}

	public enum configProperties{
		browser("browser"),
		localization("localization"),
		durationOfSeconds("durationOfSeconds");

		private String property;

		configProperties(String property){
			this.property = property;
		}

		public String getProperty(){
			return prop.getProperty(property);
		}
	}
}

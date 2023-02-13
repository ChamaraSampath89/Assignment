package com.Chamara.Amazon.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandler {
	static PropertyFileHandler propertyFileHandler;
	static Properties prop = new Properties();
	
	private PropertyFileHandler() {
		
	}
	
	public static PropertyFileHandler getPropertyFileHandler() {
		if(propertyFileHandler == null) {
			propertyFileHandler = new PropertyFileHandler();
		}
		return propertyFileHandler;
	}
	
	public static void loadPropertyFile(String path) throws FileNotFoundException, IOException {
		prop.load(new FileInputStream(path));
	}
	
	public static String readProperty(String key) {
		return prop.getProperty(key);
	}
	
	public static void writeProperty(String key, String value) {
		prop.setProperty(key, value);
	}

}

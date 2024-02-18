package config;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
	
	// Create an object of "Properties" class
	private static Properties prop = new Properties(); 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
		getProperties();
		
	}
	
	public static void getProperties(){
		try {
			// Create an object of "InputStream" class
			String project_path = System.getProperty("user.dir");
			InputStream inp = new FileInputStream(project_path + "/src/test/java/config/config.properties");
		
			// Load the Properties file
			prop.load(inp);
			
			// Get values from Properties file
			String browser = prop.getProperty("browser");
			System.out.println(browser);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public static void setProperties() {
		try {
			// Create an object of "OutputStream" class
			String project_path = System.getProperty("user.dir");
			OutputStream out = new FileOutputStream(project_path+"/src/test/java/config/config.properties");
			
			// Set values to Properties file
			prop.setProperty("browser","Chrome");
			
			// Store the values
			prop.store(out,null);
		}
		
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}

package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	
	Properties prop;
	public ConfigDataProvider() {
		
		
		
		File src=new File("./config/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Not available" +e.getMessage());
		}
	}
	
	public String getBrowser() {
		return prop.getProperty("Browser");
		
	}
	
	public String getqaUrl() {
		return prop.getProperty("qaURL");
		
	}
	
	
	
	
}

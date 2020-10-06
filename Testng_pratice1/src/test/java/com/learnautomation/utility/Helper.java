package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
 
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/screenshots/login"+getCurrentDateTime()+".png";
		//FileHandler.copy(from, to);
		try {
			FileHandler.copy(src, new File("./screenshots/login"+getCurrentDateTime()+".png"));
		} catch (IOException e) {
		
			System.out.println("unable to take screenshot" +e.getMessage());
		}return screenshotpath;
	}
	
	
	//to get the current date and time of capturing the screenshot we have a class
	
	public static String getCurrentDateTime() {
		DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentdate=new Date();
		return customformat.format(currentdate);
		
		
	}
	
}

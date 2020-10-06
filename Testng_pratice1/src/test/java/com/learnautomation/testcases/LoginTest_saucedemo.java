package com.learnautomation.testcases;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.pages.BasePage;
import com.learnautomation.pages.LoginPage;
//import com.learnautomation.utility.Helper;
//import com.learnautomation.utility.ExcelDataProvider;
//import com.learnautomation.utility.BrowserFactory;

public class LoginTest_saucedemo extends BasePage {

	//WebDriver driver;: no need because it is coming from base page
	
	@Test
	public void loginApp() {
		
		//ExcelDataProvider excel=new ExcelDataProvider();
	//	excel.getStringData("login", 0, 0);
		logger=report.createTest("	Login to sauce demo");
		logger.info("Starting Application");
		

		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);

		loginpage.saucedemo_login(excel.getStringData("login", 0, 0), excel.getStringData("login", 0, 1));
		logger.pass("Login Successful");
		
	// >>used to take screenshot if test doesnot fail:	Helper.captureScreenshot(driver);
	}
  
	}

	
	
	
	



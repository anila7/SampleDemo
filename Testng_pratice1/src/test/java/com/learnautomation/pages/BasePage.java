package com.learnautomation.pages;                 

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

//this came from login test_sauce demo; it was first written there

public class BasePage {   //Base page has all the  pre-conditions and post-conditions

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite   //using report logs
	public void setupSuite() {
		Reporter.log("Setting up reports and tests getting started", true);

		excel=new ExcelDataProvider();
		config= new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/saucedemo"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);

		Reporter.log("Seetings done-Test can be started", true);
	}

	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start browser-Application ready", true);

		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.getqaUrl());

		Reporter.log("Browser and Application up and running", true);

		//		System.out.println(driver.getTitle()); [just to know whether it is going to same url
	}
	@ AfterClass
	public void teardown() {
		BrowserFactory.quitbrowser(driver);
	}

	@AfterMethod      //used to capture screenshot if test fails
	public void teardownMethod(ITestResult result) throws IOException {

		Reporter.log("Test is abpout to end", true);

		if(result.getStatus()==ITestResult.FAILURE)
		{

			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		} 
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}

		report.flush();

		Reporter.log("Test completed >>>Reports Generated", true);
	}




	
	
}

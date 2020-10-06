package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage { 
	
	WebDriver driver;
                           //using constructor
	public LoginPage(WebDriver ldriver) {

		this.driver=ldriver;

	}
	@FindBy(xpath= "//input[@id='user-name']") WebElement uname;

	@FindBy(xpath="//input[@id='password']") WebElement pass;

	@FindBy(xpath= "//input[@id='login-button']") WebElement loginbutton;

	public void saucedemo_login(String usernameApplication, String passwordApplication) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		uname.sendKeys(usernameApplication);
		pass.sendKeys(passwordApplication);
		loginbutton.click();

	}




}

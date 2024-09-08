package com.parentbooking.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parentbooking.pageobjects.GetDriver;
import com.parentbooking.pageobjects.Login_Page_Elements;

public class Logout_Test {
	
	public WebDriver driver;
	public Login_Page_Elements loginpage;
	
	@BeforeClass()
	public void setDriver(){
		driver =GetDriver.driver;		
		loginpage = new Login_Page_Elements(driver);
	}
	
	@Test(priority=0)
	public void logoutTest() {
		loginpage.logoutButton().click();
		
	}
}

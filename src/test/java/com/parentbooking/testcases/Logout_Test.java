package com.parentbooking.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.parentbooking.pageobjects.GetDriver;
import com.parentbooking.pageobjects.Login_Page_Elements;
import com.parentbooking.utils.ActionUtils;

public class Logout_Test {
	
	public WebDriver driver;
	public Login_Page_Elements loginpage;
	public ActionUtils action;
	
	@BeforeClass()
	public void setDriver(){
		driver =GetDriver.driver;		
		loginpage = new Login_Page_Elements(driver);
		action = new ActionUtils(driver);
	}
	
	@Test(priority=0)
	public void logoutTest() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.visibilityOf(loginpage.logoutButton()));
		action.scrollToElement(loginpage.logoutButton());
		Thread.sleep(3000);
		
		loginpage.logoutButton().click();
		
	}
}

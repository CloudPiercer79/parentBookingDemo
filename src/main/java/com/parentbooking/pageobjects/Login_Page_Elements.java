package com.parentbooking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Elements {
	public WebDriver driver;


// Creating Page factory to make these accessible for test cases //
	public Login_Page_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// User name text field //
	@FindBy(id="j_username")
	WebElement username;
	
	@FindBy(xpath="/html/body/div/div/a")
	WebElement acceptCookies;
	
	//Password text field //
	@FindBy(id="fauxPassword")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\"hedr\"]/div[2]/div[1]/a")
	WebElement logoutButton;
	
	// Login button//
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	
	
	public WebElement username() {
		return username;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
	
	public WebElement acceptCookies() {
		return acceptCookies;
	}
	
	public WebElement logoutButton() {
		return logoutButton;
	}
}

package com.parentbooking.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionUtils {
	public WebDriver driver;
	public ActionUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void scrollToElement(WebElement webElement) throws InterruptedException {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
		Thread.sleep(1000);
	}
}

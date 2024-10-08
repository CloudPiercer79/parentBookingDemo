package com.parentbooking.testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.parentbooking.pageobjects.GetDriver;
import com.parentbooking.pageobjects.Login_Page_Elements;
import com.parentbooking.utils.LoadProperties;

public class Login_Page_Test {
	public static WebDriver driver;
	public Login_Page_Elements loginpage;

	@BeforeSuite
	public void launchingWebBrowser() throws IOException {

		/* Creating an Instance of chrome browser if the browser selected is chrome */
		String browser = LoadProperties.getInstance().getProperty("browser");

		if (browser.equals("chrome")) {
			ChromeOptions handlingSSL = new ChromeOptions();
			handlingSSL.setAcceptInsecureCerts(true);
			Login_Page_Test.driver = new ChromeDriver(handlingSSL);
			System.out.println("Selected browser is : " + browser);
		} 
		/* Creating an Instance of Edge browser if the browser selected is edge */
		else if (browser.equals("edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			Login_Page_Test.driver = new EdgeDriver(edgeOptions);
			System.out.println("Selected browser is : " + browser);
		}
		/* Creating an Instance of safari browser if the browser selected is safari */
		else if (browser.equals("safari")) {
			Login_Page_Test.driver = new SafariDriver();
			driver.get("https://revoked.badssl.com");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("CertificateWarningController.visitInsecureWebsiteWithTemporaryBypass()");
			System.out.println("Selected browser is : " + browser);
		} 
		/* Exit the code of the browser definer in config.properties file is incorrect */
		else {
			System.out.println("[Error] : Please enter valid browser name in conig.properties");
			System.exit(0);
		}
		/* maximize the window */
		driver.manage().window().maximize();
		/* static wait for the page to load completely */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		/* hitting application URL */
		driver.get(LoadProperties.getInstance().getProperty("appURL"));

		GetDriver.driver = driver;
		loginpage = new Login_Page_Elements(driver);

	}

	@Test(priority = 0)
	public void loggingIntoTheApplication() throws IOException, InterruptedException {
		/* Dynamic wait */
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		/* waiting fro element to be visible making sure the element is loaded */
		wait.until(ExpectedConditions.visibilityOf(loginpage.username()));
		SoftAssert softAssert = new SoftAssert();
		// Checking for the title of the application//
		softAssert.assertEquals(driver.getTitle(), "Login | Parents Booking", "Title is not Matching at login page");

		wait.until(ExpectedConditions.visibilityOf(loginpage.acceptCookies()));
		//* Accepting cookies element */
		loginpage.acceptCookies().click();

		// Entering user name//
		loginpage.username().click();
		loginpage.username().sendKeys(LoadProperties.getInstance().getProperty("username"));

		// Entering Password //
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('fauxPassword').value='test';");

		Actions keyboardActions = new Actions(driver);
		keyboardActions.sendKeys(loginpage.password(), "test").perform();

		// Clicking on login button //
		loginpage.loginButton().click();
		softAssert.assertEquals(driver.getTitle(), "Dashboard | Parents Booking",
				"Title is not Matching at Dashboard page");
		softAssert.assertAll();
	}
}
package com.parentbooking.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.parentbooking.pageobjects.GetDriver;
import com.parentbooking.pageobjects.Parents_Page_Elements;
import com.parentbooking.utils.ActionUtils;

public class Parents_Page_Test {
	public WebDriver driver;
	public Parents_Page_Elements parentspage;
	public ActionUtils action ;
	
	@BeforeClass
	public void setDriver() {
		driver =GetDriver.driver;
		parentspage = new Parents_Page_Elements(driver);
		action = new ActionUtils(driver);
	}
	
	@Test(priority=0)
	public void parentsPageTest() throws InterruptedException {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		Actions actions = new Actions(driver);
		
		actions.moveToElement(parentspage.parentPageLink()).click().build().perform();
		// Clicking on Parents link from the side pane //
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewParentButton()));
		// Checking for the title of the parents page//
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | List of Parents","Title is not Matching at parents page");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=1)
	public void addNewParentsTest() throws InterruptedException {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		Actions actions = new Actions(driver);
		
		//action.scrollToElement(parentspage.addNewParentButton());
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewParentButton()));
		actions.moveToElement(parentspage.addNewParentButton()).click().build().perform();
		// Clicking on Add new parents button //
		
		actions.moveToElement(parentspage.addNewStudentbutton());
		//action.scrollToElement(parentspage.addNewStudentbutton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewStudentbutton()));	
		//Checking title of Create Parent & Student page //
		
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | Create Parent & Student","Title is not Matching at Create Parent & Student page");
		
		
		//action.scrollToElement(parentspage.titleTextBoxParent());
		wait.until(ExpectedConditions.elementToBeClickable(parentspage.titleTextBoxParent()));	
		actions.moveToElement(parentspage.titleTextBoxParent()).click().sendKeys("Mr").build().perform(); // Adding title //
		
		//action.scrollToElement(parentspage.firstNameTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.firstNameTextBoxParent()));	
		actions.moveToElement(parentspage.firstNameTextBoxParent()).click().sendKeys("First Name").build().perform(); // Adding first name //
		
		
		//action.scrollToElement(parentspage.surNameTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.surNameTextBoxParent()));	
		actions.moveToElement(parentspage.surNameTextBoxParent()).click().sendKeys("Sur Name").build().perform();// Adding surname //
		
		//action.scrollToElement(parentspage.emailTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.emailTextBoxParent()));
		actions.moveToElement(parentspage.emailTextBoxParent()).click().sendKeys("testemail@gmail.com").build().perform();// adding email //
		
		//action.scrollToElement(parentspage.phoneTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.phoneTextBoxParent()));
		actions.moveToElement(parentspage.phoneTextBoxParent()).click().sendKeys("9876543210").build().perform();// adding phone number //
		
		//action.scrollToElement(parentspage.addNewStudentbutton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewStudentbutton()));
		//Clicking  on add new student button //
		actions.moveToElement(parentspage.addNewStudentbutton()).click().build().perform();//

		
		//action.scrollToElement(parentspage.firstNameStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.firstNameStudent()));
		actions.moveToElement(parentspage.firstNameStudent()).click().sendKeys("StudentFirstname").build().perform(); // Adding student name //
		
		//action.scrollToElement(parentspage.surNameStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.surNameStudent()));
		actions.moveToElement(parentspage.surNameStudent()).click().sendKeys("Studentsurname").build().perform(); // Adding Sur name //

		
		//action.scrollToElement(parentspage.classStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.classStudent()));
		actions.moveToElement(parentspage.classStudent()).click().sendKeys("3A").build().perform(); // Adding student class //
		
		//action.scrollToElement(parentspage.yearStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.yearStudent()));
		actions.moveToElement(parentspage.yearStudent()).click().sendKeys("2021").build().perform(); // Adding student year group //
		
		//action.scrollToElement(parentspage.dobStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.dobStudent()));
		actions.moveToElement(parentspage.dobStudent()).click().build().perform(); // Clicking og DOB text field //
		
		//action.scrollToElement(parentspage.monthPicker());

		wait.until(ExpectedConditions.visibilityOf(parentspage.monthPicker()));

		// Selecting month of the student //
		actions.moveToElement(parentspage.monthPicker()).perform();

		Select monthDropdown = new Select(parentspage.monthPicker());  
		monthDropdown.selectByIndex(5);
		
		//action.scrollToElement(parentspage.yearPicker());
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.yearPicker()));
		//Selecting year of birth //
		actions.moveToElement(parentspage.yearPicker()).perform(); 

		Select yearDropdown = new Select(parentspage.yearPicker());
		yearDropdown.selectByValue("1999");
		
		// Clicking on date //
		//action.scrollToElement(parentspage.datePicker());
		wait.until(ExpectedConditions.visibilityOf(parentspage.datePicker()));
		actions.moveToElement(parentspage.datePicker()).click().build().perform(); 

		
		// Clicking on save button //
		//action.scrollToElement(parentspage.saveButton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.saveButton()));
		actions.moveToElement(parentspage.saveButton()).click().build().perform(); 
		
		softAssert.assertAll();
		
			
		}
	
	
	@Test(priority=3)
	public void parentDetailsVerification() throws InterruptedException {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		Actions actions = new Actions(driver);
		
		//action.scrollToElement(parentspage.searchParent());
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchParent()));
		actions.moveToElement(parentspage.searchParent()).click().build().perform();

		
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | List of Parents","Title is not Matching at Create Parent & Student page");
	
		//action.scrollToElement(parentspage.searchByDropDown());
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchByDropDown()));
		actions.moveToElement(parentspage.searchByDropDown()).build().perform();

		Select searchBy = new Select(parentspage.searchByDropDown());
		searchBy.selectByValue("1");
		
		//action.scrollToElement(parentspage.searchParent());
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchParent()));
		actions.moveToElement(parentspage.searchParent()).click().sendKeys("First Name").build().perform();
		
		
		//action.scrollToElement(parentspage.searchButton());

		wait.until(ExpectedConditions.visibilityOf(parentspage.searchButton()));
		actions.moveToElement(parentspage.searchButton()).click().build().perform();
		
		//Verifying parents details using soft Assert //
		
		//System.out.println(parentspage.Title().getText() + parentspage.surname().getText() + parentspage.surname().getAttribute("innerText")+parentspage.email().getText() + parentspage.phone().getText()+parentspage.numberOfStudent().getText());		
		//action.scrollToElement(parentspage.Title());
		wait.until(ExpectedConditions.visibilityOf(parentspage.Title()));
		actions.moveToElement(parentspage.Title()).build().perform();
		softAssert.assertEquals(parentspage.Title().getText(),"Mr","Parent Title Incorrect");
		
		//action.scrollToElement(parentspage.firstName());
		wait.until(ExpectedConditions.visibilityOf(parentspage.firstName()));
		actions.moveToElement(parentspage.firstName()).build().perform();
		softAssert.assertEquals(parentspage.firstName().getText(), "First Name","Inccorect first name");
		
		//action.scrollToElement(parentspage.surname());
		wait.until(ExpectedConditions.visibilityOf(parentspage.surname()));
		actions.moveToElement(parentspage.surname()).build().perform();
		softAssert.assertEquals(parentspage.surname().getText(), "Sur Name","Incorrect Surname");
		
		//action.scrollToElement(parentspage.email());
		wait.until(ExpectedConditions.visibilityOf(parentspage.email()));
		actions.moveToElement(parentspage.email()).build().perform();
		softAssert.assertEquals(parentspage.email().getText(), "testemail@gmail.com","Incorrect Email");
		
		//action.scrollToElement(parentspage.phone());
		wait.until(ExpectedConditions.visibilityOf(parentspage.phone()));
		actions.moveToElement(parentspage.phone()).build().perform();
		softAssert.assertEquals(parentspage.phone().getText(), "9876543210","Incorrect phone number");
		
		//action.scrollToElement(parentspage.numberOfStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.numberOfStudent()));
		actions.moveToElement(parentspage.numberOfStudent()).build().perform();
		softAssert.assertEquals(parentspage.numberOfStudent().getText(), "1","Incorrect student count");
		
		softAssert.assertAll();


		
	}
}

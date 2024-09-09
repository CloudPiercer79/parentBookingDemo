package com.parentbooking.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
		
		
		
		// Clicking on Parents link from the side pane //
		parentspage.parentPageLink().click();
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewParentButton()));
		// Checking for the title of the parents page//
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | List of Parents","Title is not Matching at parents page");
		
		softAssert.assertAll();
		
	}
	
	@Test(priority=1)
	public void addNewParentsTest() throws InterruptedException {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		
		action.scrollToElement(parentspage.addNewParentButton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewParentButton()));
		Thread.sleep(5000);
		// Clicking on Add new parents button //
		parentspage.addNewParentButton().click();
		
		action.scrollToElement(parentspage.addNewStudentbutton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewStudentbutton()));	
		//Checking title of Create Parent & Student page //
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | Create Parent & Student","Title is not Matching at Create Parent & Student page");
		
		
		action.scrollToElement(parentspage.titleTextBoxParent());
		wait.until(ExpectedConditions.elementToBeClickable(parentspage.titleTextBoxParent()));	
		parentspage.titleTextBoxParent().click();
		parentspage.titleTextBoxParent().sendKeys("Mr"); // Adding title //
		
		action.scrollToElement(parentspage.firstNameTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.firstNameTextBoxParent()));	
		parentspage.firstNameTextBoxParent().click();
		parentspage.firstNameTextBoxParent().sendKeys("FirstNameTestParent"); // Adding first name //
		
		
		action.scrollToElement(parentspage.surNameTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.surNameTextBoxParent()));	
		parentspage.surNameTextBoxParent().click();
		parentspage.surNameTextBoxParent().sendKeys("SurNameTest"); // Adding surname //
		
		action.scrollToElement(parentspage.emailTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.emailTextBoxParent()));
		parentspage.emailTextBoxParent().click();
		parentspage.emailTextBoxParent().sendKeys("testemail@gmail.com"); // adding email //
		
		action.scrollToElement(parentspage.phoneTextBoxParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.phoneTextBoxParent()));
		parentspage.phoneTextBoxParent().click();
		parentspage.phoneTextBoxParent().sendKeys("9876543210"); // adding phone number //
		
		action.scrollToElement(parentspage.addNewStudentbutton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewStudentbutton()));
		//Clicking  on add new student button //
		parentspage.addNewStudentbutton().click();
		
		action.scrollToElement(parentspage.firstNameStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.firstNameStudent()));
		parentspage.firstNameStudent().click();
		parentspage.firstNameStudent().sendKeys("StudentFirstname"); // Adding student name //
		
		action.scrollToElement(parentspage.surNameStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.surNameStudent()));
		parentspage.surNameStudent().click();
		parentspage.surNameStudent().sendKeys("Studentsurname"); // Adding student surname //
		
		action.scrollToElement(parentspage.classStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.classStudent()));
		parentspage.classStudent().click();
		parentspage.classStudent().sendKeys("3A"); // Adding student class //
		
		action.scrollToElement(parentspage.yearStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.yearStudent()));
		parentspage.yearStudent().click();
		parentspage.yearStudent().sendKeys("2021"); // Adding student year group //
		
		action.scrollToElement(parentspage.dobStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.dobStudent()));
		parentspage.dobStudent().click(); // Clicking og DOB text field //
		
		action.scrollToElement(parentspage.monthPicker());
		wait.until(ExpectedConditions.visibilityOf(parentspage.monthPicker()));

		// Selecting month of the student //
		Select monthDropdown = new Select(parentspage.monthPicker());  
		monthDropdown.selectByIndex(5);
		
		action.scrollToElement(parentspage.yearPicker());
		wait.until(ExpectedConditions.visibilityOf(parentspage.yearPicker()));
		//Selecting year of birth //
		Select yearDropdown = new Select(parentspage.yearPicker());
		yearDropdown.selectByValue("1999");
		
		// Clicking on date //
		action.scrollToElement(parentspage.datePicker());
		wait.until(ExpectedConditions.visibilityOf(parentspage.datePicker()));
		parentspage.datePicker().click();
		
		// Clicking on save button //
		action.scrollToElement(parentspage.saveButton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.saveButton()));
		parentspage.saveButton().click();
		
		softAssert.assertAll();
		
			
		}
	
	
	@Test(priority=3)
	public void parentDetailsVerification() throws InterruptedException {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		action.scrollToElement(parentspage.searchParent());
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchParent()));
		parentspage.searchParent().click();
		
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | List of Parents","Title is not Matching at Create Parent & Student page");
	
		action.scrollToElement(parentspage.searchByDropDown());
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchByDropDown()));
		Select yearDropdown = new Select(parentspage.searchByDropDown());
		yearDropdown.selectByValue("1");
		
		action.scrollToElement(parentspage.searchParent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchParent()));
		parentspage.searchParent().click();
		parentspage.searchParent().sendKeys("FirstNameTestParent");
		
		
		action.scrollToElement(parentspage.searchButton());
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchButton()));
		parentspage.searchButton().click();
		
		//Verifying parents details using soft Assert //
		
		//System.out.println(parentspage.Title().getText() + parentspage.surname().getText() + parentspage.surname().getAttribute("innerText")+parentspage.email().getText() + parentspage.phone().getText()+parentspage.numberOfStudent().getText());		
		action.scrollToElement(parentspage.Title());
		wait.until(ExpectedConditions.visibilityOf(parentspage.Title()));
		softAssert.assertEquals(parentspage.Title().getText(),"Mr","Parent Title Incorrect");
		
		action.scrollToElement(parentspage.firstName());
		wait.until(ExpectedConditions.visibilityOf(parentspage.firstName()));
		softAssert.assertEquals(parentspage.firstName().getText(), "FirstNameTestParent","Inccorect first name");
		
		action.scrollToElement(parentspage.surname());
		wait.until(ExpectedConditions.visibilityOf(parentspage.surname()));
		softAssert.assertEquals(parentspage.surname().getText(), "SurNameTest","Incorrect Surname");
		
		action.scrollToElement(parentspage.email());
		wait.until(ExpectedConditions.visibilityOf(parentspage.email()));
		softAssert.assertEquals(parentspage.email().getText(), "testemail@gmail.com","Incorrect Email");
		
		action.scrollToElement(parentspage.phone());
		wait.until(ExpectedConditions.visibilityOf(parentspage.phone()));
		softAssert.assertEquals(parentspage.phone().getText(), "9876543210","Incorrect phone number");
		
		action.scrollToElement(parentspage.numberOfStudent());
		wait.until(ExpectedConditions.visibilityOf(parentspage.numberOfStudent()));
		softAssert.assertEquals(parentspage.numberOfStudent().getText(), "1","Incorrect student count");
		
		softAssert.assertAll();


		
	}
}

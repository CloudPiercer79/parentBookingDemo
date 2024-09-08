package com.parentbooking.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.parentbooking.pageobjects.GetDriver;
import com.parentbooking.pageobjects.Parents_Page_Elements;

public class Parents_Page_Test {
	public WebDriver driver;
	public Parents_Page_Elements parentspage;
	
	@BeforeClass
	public void setDriver() {
		driver =GetDriver.driver;
		parentspage = new Parents_Page_Elements(driver);	
	}
	
	@Test(priority=0)
	public void parentsPageTest() {
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
	public void addNewParentsTest() {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		
		// Clicking on Add new parents button //
		parentspage.addNewParentButton().click();
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.addNewStudentbutton()));	
		//Checking title of Create Parent & Student page //
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | Create Parent & Student","Title is not Matching at Create Parent & Student page");
		
		
		
		parentspage.titleTextBoxParent().click();
		parentspage.titleTextBoxParent().sendKeys("Mr"); // Adding title //
		
		parentspage.firstNameTextBoxParent().click();
		parentspage.firstNameTextBoxParent().sendKeys("FirstNameTestParent"); // Adding first name //
		
		parentspage.surNameTextBoxParent().click();
		parentspage.surNameTextBoxParent().sendKeys("SurNameTest"); // Adding surname //
		
		parentspage.emailTextBoxParent().click();
		parentspage.emailTextBoxParent().sendKeys("testemail@gmail.com"); // adding email //
		
		parentspage.phoneTextBoxParent().click();
		parentspage.phoneTextBoxParent().sendKeys("9876543210"); // adding phone number //
		
		//Clicking  on add new student button //
		parentspage.addNewStudentbutton().click();
		
		parentspage.firstNameStudent().click();
		parentspage.firstNameStudent().sendKeys("StudentFirstname"); // Adding student name //
		
		parentspage.surNameStudent().click();
		parentspage.surNameStudent().sendKeys("Studentsurname"); // Adding student surname //
		
		parentspage.classStudent().click();
		parentspage.classStudent().sendKeys("3A"); // Adding student class //
		
		parentspage.yearStudent().click();
		parentspage.yearStudent().sendKeys("2021"); // Adding student year group //
		
		parentspage.dobStudent().click(); // Clicking og DOB text field //

		wait.until(ExpectedConditions.visibilityOf(parentspage.monthPicker()));

		// Selecting month of the student //
		Select monthDropdown = new Select(parentspage.monthPicker());  
		monthDropdown.selectByIndex(5);
		
		//Selecting year of birth //
		Select yearDropdown = new Select(parentspage.yearPicker());
		yearDropdown.selectByValue("1999");
		
		// Clicking on date //
		parentspage.datePicker().click();
		
		// Clicking on save button //
		parentspage.saveButton().click();
		
		softAssert.assertAll();
		
			
		}
	
	
	@Test(priority=3)
	public void parentDetailsVerification() {
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		SoftAssert softAssert = new SoftAssert();
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchParent()));
		parentspage.searchParent().click();
		
		softAssert.assertEquals(driver.getTitle(),"Parents Booking | List of Parents","Title is not Matching at Create Parent & Student page");
	
		Select yearDropdown = new Select(parentspage.searchByDropDown());
		yearDropdown.selectByValue("1");
		
		parentspage.searchParent().click();
		
		parentspage.searchParent().sendKeys("FirstNameTestParent");
		
		wait.until(ExpectedConditions.visibilityOf(parentspage.searchButton()));
		parentspage.searchButton().click();
		
		//Verifying parents details using soft Assert //
		
		System.out.println(parentspage.Title().getText() + parentspage.surname().getText() + parentspage.surname().getAttribute("innerText")+parentspage.email().getText() + parentspage.phone().getText()+parentspage.numberOfStudent().getText());		
		softAssert.assertEquals(parentspage.Title().getText(),"Mr","Parent Title Incorrect");
		softAssert.assertEquals(parentspage.firstName().getText(), "FirstNameTestParent","Inccorect first name");
		softAssert.assertEquals(parentspage.surname().getText(), "SurNameTest","Incorrect Surname");
		softAssert.assertEquals(parentspage.email().getText(), "testemail@gmail.com","Incorrect Email");
		softAssert.assertEquals(parentspage.phone().getText(), "9876543210","Incorrect phone number");
		softAssert.assertEquals(parentspage.numberOfStudent().getText(), "1","Incorrect student count");
		
		softAssert.assertAll();


		
	}
}

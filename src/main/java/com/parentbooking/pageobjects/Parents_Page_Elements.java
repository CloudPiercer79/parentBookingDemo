package com.parentbooking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Parents_Page_Elements {
	public WebDriver driver;


	// Creating Page factory to make these accessible for test cases //
		public Parents_Page_Elements(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="parent")
		WebElement parentPageLink;
		
		@FindBy(xpath= "//*[@id=\"c\"]/div[2]/div/div[4]/div/div")
		WebElement addNewParentButton;
		
		@FindBy(xpath="//*[@id=\"parent\"]/div[4]/div/div/div[1]/div[3]/button")
		WebElement addNewStudentbutton;
		
		@FindBy(name="title")
		WebElement titleTextBoxParent;
		
		@FindBy(name ="firstName")
		WebElement firstNameTextBoxParent;
		
		@FindBy(name ="surName")
		WebElement surNameTextBoxParent;
		
		@FindBy(name ="email")
		WebElement emailTextBoxParent;
		
		@FindBy(name ="phone")
		WebElement phoneTextBoxParent;
		
		@FindBy(id ="firstNames_0")
		WebElement firstNameStudent;
		
		@FindBy(id ="surNames_0")
		WebElement surNameStudent;
		
		@FindBy(id ="classNumbers_0")
		WebElement classStudent;
		
		@FindBy(id ="yearGroups_0")
		WebElement yearStudent;
		
		@FindBy(xpath="//*[@id=\"parent\"]/div[4]/div/div/div[2]/div/div/div")
		WebElement saveButton;
		
		@FindBy(id="dobs_0")
		WebElement dobStudent;
		
		@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
		WebElement monthPicker;
		
		@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
		WebElement yearPicker;
		
		@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[1]/a")
		WebElement datePicker;
		
		@FindBy(name = "searchValue")
		WebElement searchParent;
		
		public WebElement parentPageLink() {	
			return parentPageLink;
			
		}
		
		public WebElement addNewParentButton() {	
			return addNewParentButton;
		}
		
		public WebElement addNewStudentbutton() {
			return addNewStudentbutton;
		}
		
		public WebElement titleTextBoxParent() {
			return titleTextBoxParent;
		}
		
		public WebElement firstNameTextBoxParent() {
			return firstNameTextBoxParent;
		}
		
		public WebElement surNameTextBoxParent() {
			return surNameTextBoxParent;
		}
		
		public WebElement emailTextBoxParent() {
			return emailTextBoxParent;
		}
		
		public WebElement phoneTextBoxParent() {
			return phoneTextBoxParent;
		}
		
		public WebElement firstNameStudent() {
			return firstNameStudent;
		}
		

		public WebElement surNameStudent() {
			return surNameStudent;
		}
		
		public WebElement classStudent() {
			return classStudent;
		}
		
		public WebElement yearStudent() {
			return yearStudent;
		}
		
		public WebElement dobStudent() {
			return dobStudent;
		}
		
		
		public WebElement saveButton() {
			return saveButton;
		}
		
		public WebElement monthPicker() {
			return monthPicker;
		}
		
		public WebElement yearPicker() {
			return yearPicker;
		}
		
		public WebElement datePicker() {
			return datePicker;
		}
		
		public WebElement searchParent() {	
			return searchParent;
		}
		
		@FindBy(xpath="//*[@id='format']")
		WebElement searchByDropDown;
		
		@FindBy(xpath="//*[@id=\"c\"]/div[2]/div/form/div[3]/div/button")
		WebElement searchButton;
		
		@FindBy(xpath="//*[@id=\"b\"]/div/div[3]/div[3]/div/div[2]/ul[2]/li[1]")
		WebElement Title;
		
		@FindBy(xpath="//*[@id=\"b\"]/div/div[3]/div[3]/div/div[2]/ul[2]/li[2]")
		WebElement firstName;
		
		@FindBy(xpath="//*[@id=\"b\"]/div/div[3]/div[3]/div/div[2]/ul[2]/li[3]")
		WebElement surname;
		
		@FindBy(xpath="//*[@id=\"b\"]/div/div[3]/div[3]/div/div[2]/ul[2]/li[4]")
		WebElement email;
		
		@FindBy(xpath="//*[@id=\"b\"]/div/div[3]/div[3]/div/div[2]/ul[2]/li[5]")
		WebElement phone;
		
		@FindBy(xpath="//*[@id=\"b\"]/div/div[3]/div[3]/div/div[2]/ul[2]/li[6]")
		WebElement numberOfStudent;
		
		public WebElement Title() {	
			return Title;
		}
		
		public WebElement phone() {	
			return phone;
		}
		
		public WebElement firstName() {	
			return firstName;
		}
		
		public WebElement surname() {	
			return surname;
		}
		
		public WebElement email() {	
			return email;
		}
		
		public WebElement numberOfStudent() {	
			return numberOfStudent;
		}
		
		
		public WebElement searchByDropDown() {	
			return searchByDropDown;
		}
		
		public WebElement searchButton() {	
			return searchButton;
		}
		
		
		

}

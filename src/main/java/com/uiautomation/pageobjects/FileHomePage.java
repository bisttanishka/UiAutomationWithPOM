package com.uiautomation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileHomePage {
	
//To define WebElement(PageObjects of Fileupload page)	

	@FindBy(xpath ="//div[@class=\"heroSection-buttonContainer_secondaryBtn__text\"]")
	public
	WebElement uploadButton;
	
	@FindBy(xpath = "//input[@id=\"file-upload\"]")
	public
	WebElement inputFile;
	
	@FindBy(xpath = "//span//input[@type=\"submit\"]")
	public
	WebElement submitButton;
	
	@FindBy(xpath = "//h1[normalize-space(text())=\"Create an Account\"]")
	public
	WebElement createAnAccount;
	
//To initialize all the webelement from page factory class
	
public FileHomePage(WebDriver driver) {

	PageFactory.initElements(driver, this);
	
}

}

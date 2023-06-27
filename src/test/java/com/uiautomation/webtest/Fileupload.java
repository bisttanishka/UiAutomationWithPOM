package com.uiautomation.webtest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.uiautomation.pageobjects.FileHomePage;
import com.uiautomation.utility.ScreenShotUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fileupload {
WebDriver driver;
FileHomePage homePageObjects;

@BeforeTest
public void launchBrowser() {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.foundit.in/");
driver.manage().window().maximize();
//wait for pageload
driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);
homePageObjects =new FileHomePage(driver);

}

@Test
public void verifyFileUpload() throws InterruptedException, IOException

{
	boolean fileupLoadButton=homePageObjects.uploadButton.isDisplayed();
	Assert.assertEquals(fileupLoadButton, true,"FileUploadButton is not displayed");
	homePageObjects.uploadButton.click();
	Thread.sleep(5000);
	//boolean fileInput=homePageObjects.inputFile.isDisplayed();
	//Assert.assertEquals(fileInput, true,"fileInput is not displayed");
	System.out.println(System.getProperty("user.dir"));
    homePageObjects.inputFile.sendKeys(System.getProperty("user.dir")+"/ResumeS.docx");
    //Taking the screenshot after uploading file
    ScreenShotUtility.takeScreenshot(driver, System.getProperty("user.dir")+"/src/main/java/com/uiautomation/screenshots/resumeuploaded.png");
    boolean submitButton=homePageObjects.submitButton.isEnabled();
	Assert.assertEquals(submitButton, true,"SubmitButton is not enabled");
	homePageObjects.submitButton.click();
	driver.manage().timeouts().pageLoadTimeout(10000,TimeUnit.MILLISECONDS);
	boolean displayCreateAccount=homePageObjects.createAnAccount.isDisplayed();
	Assert.assertEquals(displayCreateAccount, true,"displayCreateAccount is not displayed");
	//After submission of resume
    ScreenShotUtility.takeScreenshot(driver, System.getProperty("user.dir")+"/src/main/java/com/uiautomation/screenshots/createanaccount.png");
}

@AfterTest
public void closebrowser() {
	System.out.println("Broswer Close");
	driver.close();
	
}

}




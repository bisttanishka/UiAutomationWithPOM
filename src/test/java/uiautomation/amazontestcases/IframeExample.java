package uiautomation.amazontestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeExample {
	//How to handles multiple window in selenium using JAva
	//How to iterate SET collection object
	WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	}

@Test
public void verifyWindowHandles() {

String gettext=driver.findElement(By.xpath("//a[@id=\"getwebsitebtn\"]")).getText();
System.out.println(gettext);
Assert.assertEquals(gettext,"Get your own website","Text didn't match");

//Logic for switch to iframe
driver.switchTo().frame("iframeResult");
String gettextiframe1=driver.findElement((By.xpath("//p[text()=\"You can use the height and width attributes to specify the size of the iframe:\"]"))).getText();
System.out.println(gettextiframe1);
// come out from iframe
driver.switchTo().defaultContent();
String gettext1=driver.findElement(By.xpath("//a[@id=\"getwebsitebtn\"]")).getText();
System.out.println(gettext1);
Assert.assertEquals(gettext,"Get your own website","Text didn't match");
}
@AfterTest
public void driverClose() {
	driver.close();
}

}

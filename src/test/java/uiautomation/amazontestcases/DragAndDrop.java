package uiautomation.amazontestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	//How to handles multiple window in selenium using JAva
	//How to iterate SET collection object
	WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://demo.guru99.com/test/drag_drop.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	}
//it's not completed...............need to complete
@Test
public void verifyWindowHandles() throws InterruptedException {
//driver.switchTo().frame("iframeResult");	

WebElement source=driver.findElement(By.xpath("//a[text()=\" BANK \"]"));
WebElement destination= driver.findElement(By.xpath("//div[@ondrop=\"drop(event)\"]"));

Actions action=new Actions(driver);
action.clickAndHold(source)
.moveToElement(destination)
.release()
.build()
.perform();
//action.dragAndDrop(source, destination).build().perform();
//Thread.sleep(10000);


}
@AfterTest
public void driverClose() {
	//driver.close();
}

}

package uiautomation.amazontestcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {
	//How to handles multiple window in selenium using JAva
	//How to iterate SET collection object
	WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.MILLISECONDS);
	}

@Test
public void verifyWindowHandles() {

driver.findElement(By.xpath("//input[@name=\"field-keywords\"]")).sendKeys("Laptop");
//get parent window ID
String parentWindow = driver.getWindowHandle();
System.out.println(parentWindow); 
System.out.println("Title of the page"+ driver.getTitle());
driver.findElement((By.xpath("//input[@id=\"nav-search-submit-button\"]"))).click();
driver.findElement((By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]"))).click();

//get Child window ID
Set<String> childWindows = driver.getWindowHandles();
System.out.println(childWindows);

//Switch to new Window
//one way of iterating SET collection object usong arraylist class and get method

/*ArrayList<String> newHandlesList = new ArrayList<>(childWindow);
driver.switchTo().window(newHandlesList.get(1));
System.out.println("Title of the page"+ driver.getTitle());*/

//Another way is Foreach loop(Enchance forloop)

for (String childWindow : childWindows) {
    if (!childWindow.equals(parentWindow)) {
        driver.switchTo().window(childWindow);
        break;
    }	
}

//Create an iterator to iterate through the window handles
Iterator<String> iterator = childWindows.iterator();

// Iterate through the window handles
while (iterator.hasNext()) {
    String childwindow1 = iterator.next();

    // Switch to the window if it is different from the main window
    if (!childwindow1.equals(parentWindow)) {
        driver.switchTo().window(childwindow1);
        break;
    }
}  

}
@AfterTest
public void driverClose() {
	driver.close();
}

}

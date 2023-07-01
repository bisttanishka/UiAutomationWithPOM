package uiautomation.amazontestcases;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import uiautomation.amazonpomobjects.AmazonHomePage;

public class Amazon {

WebDriver driver;
AmazonHomePage amazonhomepageobject;

@BeforeTest
public void launchbrowser() {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.manage().window().maximize();
amazonhomepageobject=new AmazonHomePage(driver);
}
@Test
public void signupaccount() {

amazonhomepageobject.signin1.click();

boolean singnupdi=amazonhomepageobject.signupdisplay.isDisplayed();
Assert.assertEquals(singnupdi, true,"Signup not displayed");

boolean emailphndisplay=amazonhomepageobject.emailphonedisplay.isDisplayed();
Assert.assertEquals(emailphndisplay, true,"emailphndisplay not displayed");

amazonhomepageobject.emailinput.sendKeys("8126921207");// bcz respo is public so i have made this empty while pushing to github.
amazonhomepageobject.continuebutton.click();
boolean passdisplay=amazonhomepageobject.pwrddisplay.isDisplayed();
Assert.assertEquals(passdisplay, true,"Password not displayed");
amazonhomepageobject.enterpwd.sendKeys("Karan@1234");//bcz respo is public so i have made this empty while pushing to github.
amazonhomepageobject.signin.click();
amazonhomepageobject.search.sendKeys("Pen under 150");
amazonhomepageobject.selectpen.click();
amazonhomepageobject.hitpen1.click();
//we can use this as it will show window's id

/*Set<String> s= driver.getWindowHandles();
ArrayList ar=new ArrayList(s);
System.out.println(ar.get(0));
System.out.println(ar.get(1));
driver.switchTo().window((String)ar.get(1));*/
//or we can use below one also

Set<String> newWindowHandles = driver.getWindowHandles();
ArrayList<String> newHandlesList = new ArrayList<>(newWindowHandles);
driver.switchTo().window(newHandlesList.get(1));
amazonhomepageobject.buynow.click();

Set<String> newWindowHandles1 = driver.getWindowHandles();
ArrayList<String> newHandlesList1 = new ArrayList<>(newWindowHandles1);
driver.switchTo().window(newHandlesList.get(1));
amazonhomepageobject.usethispaymentmethod.click();

placeorder();
}

public void placeorder() {
   WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(amazonhomepageobject.placeorder)).click();
}
}








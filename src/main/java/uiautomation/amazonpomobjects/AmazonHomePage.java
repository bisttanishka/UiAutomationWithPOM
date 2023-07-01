package uiautomation.amazonpomobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

	@FindBy(id = "nav-link-accountList-nav-line-1")
	public
	WebElement signin1;
	
	@FindBy(xpath = "//h1[normalize-space(text())=\"Sign in\"]")
	public
	WebElement signupdisplay;
	
	@FindBy(xpath = "//label[normalize-space(text())=\"Email or mobile phone number\"]")
	public
	WebElement emailphonedisplay;//// //   
	
	@FindBy(xpath = "//input[@type=\"email\"]")
	public
	WebElement emailinput;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	public
	WebElement continuebutton;
	
	@FindBy(xpath = "//label[normalize-space(text())=\"Password\"]")
	public
	WebElement pwrddisplay;
	
	@FindBy(xpath = "//input[@type=\"password\"]")
	public
	WebElement enterpwd;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	public
	WebElement signin;
	
	@FindBy(xpath = "//input[@id=\"twotabsearchtextbox\"]")
	public
	WebElement search;
	
	@FindBy(xpath = "//input[@id=\"nav-search-submit-button\"]")
	public
	WebElement selectpen;
	
	@FindBy(xpath = "//span[text()=\"Cello Bling Pastel Ball Pen | Blue Ball Pen | Jar of 25 Units | Best Ball Pens for Smooth Writing | Ball Point Pen Set | Pens for Students | Office Stationery Items | Best pen for Exam\"]")
	public
	WebElement hitpen1;
	
	//@FindBy(xpath ="//span[text()=\"Cello Signature Carbon Ball Pen | Blue Ball Pen | Pack of 1 | Premium Ball Pens | Best Ball Pen for Smooth Writing | Gifting Pens | Premium Pens Signature Pens\"]")
	//public
	//WebElement hitpen;
	
	@FindBy(xpath = "//input[@id=\"buy-now-button\"]")
	public
	WebElement buynow;
	
	//@FindBy(xpath = "//input[@id=\"pp-62IQFT-100\"]")
	//public
	//WebElement radiobutton;
	
	
	@FindBy(xpath = "//input[@name=\"ppw-widgetEvent:SetPaymentPlanSelectContinueEvent\"]")
	public
	WebElement usethispaymentmethod;
	
	@FindBy(xpath = "//input[@name=\"placeYourOrder1\"]")
	public
	WebElement placeorder;
	
	public AmazonHomePage(WebDriver driver) {

//initilize webelement by initelement method from pagefactory class
	
	PageFactory.initElements(driver, this);

}
}

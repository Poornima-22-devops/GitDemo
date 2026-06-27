package Poornimaacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import Poornimaacademy.Abstractcomponents.AbstractClass;

public class CheckoutPagedetails extends AbstractClass {
	WebDriver driver;
	//whenever we execute the class,first constructor will get executed and it immediately takes the driver and
	//assigned to the local variable and at the same time it trigger the initialized elements
	//constructor name is same as class name
	public  CheckoutPagedetails(WebDriver driver)
	{
		super(driver);//from child to parent we are sending a variable, i,e driver
		this.driver =driver;
		//we are initializing and calling the elements here
		PageFactory.initElements(driver, this);
	}
	
	//pagefactorty
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement countryClick;	
	
	By taresults = By.cssSelector(".ta-results");
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	
	
	public void chooseCountry(String countryname)
	{
		Actions a = new Actions(driver);
		//now we are sending keys to the editbox to select the country
		a.sendKeys(country, countryname).build().perform();
		//applying explicit wait to load the countries
		waitForElementToAppear(taresults);//By.cssSelector(".ta-results")));
		//selecting India by writing the css locator parent to child traverse index
		countryClick.click();//driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	}
	public ThankYouPage placeOrder()
	{
		//after that we need to click on PLACEONORDER
		placeorder.click()	;	//driver.findElement(By.cssSelector(".action__submit")).click();
		ThankYouPage thankyoupage = new ThankYouPage(driver);
		return thankyoupage;
	}
}

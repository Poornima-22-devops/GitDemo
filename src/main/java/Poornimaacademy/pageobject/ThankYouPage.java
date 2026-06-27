package Poornimaacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Poornimaacademy.Abstractcomponents.AbstractClass;

public class ThankYouPage extends AbstractClass {
    WebDriver driver;
	public ThankYouPage(WebDriver driver) {
		super(driver);//from child to parent we are sending a variable, i,e driver
		this.driver =driver;
		//we are initializing and calling the elements here
		PageFactory.initElements(driver, this);
	}
		
	//pagefactory
	@FindBy(css=".hero-primary")
	WebElement text;
	public String  ConfirmMessage()
	{
		//after clicking on placeorder, we are navigating to Thankyou page
		//we are doing validation that thank you page is opened.
		//first we need to get the thank You text and store it in a variable and validate
		//return text.getText();
		
		//Looks like "Thankyou for the order."  is small letter in HTML web and THANK YOU FOR ORDER in the actual page
		//so instead of using this "Assert.assertEquals(confirmMessage, "Thankyou for the order." )"
		//we are using equaksIgnoreCase
		//Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//close the browser
		
		//driver.quit();declare this in reusable code
		return text.getText();
	}
	

	
	
	
}

package Poornimaacademy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Poornimaacademy.Abstractcomponents.AbstractClass;

//this contains the details of the landingpage 
public class LandingPage extends AbstractClass{
	WebDriver driver;
	//whenever we execute the class,first constructor will get executed and it immediately takes the driver and
	//assigned to the local variable and at the same time it trigger the initialized elements
	//constructor name is same as class name
	public  LandingPage(WebDriver driver)
	{
		super(driver);//from child to parent we are sending a variable, i,e driver
		this.driver =driver;
		//we are initializing and calling the elements here
		PageFactory.initElements(driver, this);
	}
	
	//WebElement emailid = driver.findElement(By.id("userEmail"));
	//we can write the above locator using pagefactory 
	//PageFactory
	
	@FindBy(id="userEmail")
	WebElement emailId;//userEmail will be stored in the email variable.
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(id ="login")
	WebElement submit;
	
	//errorvalidation
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	//if you carefully observe your test. So here, you are performing one action, that means login.
	//So these three steps constitutes a login, right? For that you are entering user, password, and login.
    //So instead of writing them in three steps,you can write one action method,you can push all these three lines of code into that method.
    //now creating a action method
	public ProductCatalog loginApplication(String email, String password)//these are the arguments from the actual test//these email and password are coming from the test.this shouldnot be hardcoded.
	                                                           //because every test have diff email id.
	{
		//we are sending email to editbox i,e sendKeys("poornimacs22@gmail.com");//this email will directly come from the test.
		//we can write it as
		emailId.sendKeys(email);;//passing the email here
		passwordele.sendKeys(password);
		submit.click();
		//so after you click submit,you definitely know that you are landing on product catalog page, right?
        //So this submit click will take you to the product catalog page, which is this. If you know that this action will trigger youto land on new page,
		//that new page object creation,let's do inside this method only.
		ProductCatalog productCatalog = new ProductCatalog(driver);//driver object creation in POM classes enscapsulating it from the tests
		return productCatalog;//Now in the login application,what it is returning now? It is returning product catalog object.
		/*//for every page creation,we are ending up creating one object also.Now if I want to use landing page,
      //I'm creating one object. And again if I want to use product catalog page, one object, for cart page, one object.

//And now, next we will land

on the final checkout page.

For that also you will create one object, right?

So is that not overhead?

Is there any smart way to handle it?*/
	}
	//creating a method to invoke the chrome url
	public void  goToUrl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String ErrorMessage()
	{
		waitForElementsToAppear(errormessage);
		 return errormessage.getText();
	}
	
	
}
	

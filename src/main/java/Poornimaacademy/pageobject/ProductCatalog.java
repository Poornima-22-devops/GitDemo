package Poornimaacademy.pageobject;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;

import Poornimaacademy.Abstractcomponents.AbstractClass;

//this contains the details of the landingpage 
public class ProductCatalog extends AbstractClass {
	WebDriver driver;
	//whenever we execute the class,first constructor will get executed and it immediately takes the driver and
	//assigned to the local variable and at the same time it trigger the initialized elements
	//constructor name is same as class name
	public  ProductCatalog(WebDriver driver)
	{
		super(driver);//from child to parent we are sending a variable i,e driver
		this.driver =driver;
		//we are initializing and calling the elements here
		PageFactory.initElements(driver, this);
	}
	
	
	//we can write the above locator using pagefactory 
	//PageFactory
	//List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));

	@FindBy(css=".mb-3")
	List<WebElement> products ; //we are storing the products in the list
	
	//@FindBy(css=".ng-animating")
	//WebElement spinner ; //we are storing the products in the list
	
	@FindBy(css="ngx-spinner-overlay")
	WebElement spinner ;// ngx-spinner-overlay
	
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	
	 //you cannot use PageFactory,PageFactory is exclusively for driver.findElement construction.
    // But in this case, you just have By element.
	
	By productsBy = By.cssSelector(".mb-3");
	By toasted = By.cssSelector("#toast-container");
	//we just created one action method ,which will simply get the product list,
    //For that, first, we are waiting for products to appear on page, after products are appearing,
	//then we are calling this web element and returning all the products.
	
	public List<WebElement> getProductsList()//get me the productslist.it will list down all the products displayed on the page
	{
		waitForElementToAppear(productsBy);//it was expecting a By element
		return products;
		
	}
	
	//we need to create a action method to  finding the product based upon the product name, 
	public void getProductByNameAndAddToCart(String  productName) 
	{
		for (int i = 0; i < products.size(); i++)
		{
			//gives you one specific product card and searches only inside that card.
		    String currentProduct = products.get(i)
		                                 .findElement(By.cssSelector("b"))
		                                 .getText();

		    if (currentProduct.equals(productName))
		    {
		    	//add to cart
		    	//driver.findElement() → searches the entire page
		    	//product.findElement() → searches inside a specific product card
		    	 //waitForElementToDisappear(spinner);
		        products.get(i)
		                .findElement(By.cssSelector(".card-body button:last-of-type"))//add to cart
		                .click();
		        
		       waitForElementToAppear(toasted);
		        waitForElementToDisappear(spinner);

		        break;
		    }
		}
	}
	
	
	

	public CheckoutPagedetails Checkout() {
		// TODO Auto-generated method stub
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		checkout.click();
		CheckoutPagedetails checkOut = new CheckoutPagedetails(driver);
		return checkOut;
	}
	
	
}
	

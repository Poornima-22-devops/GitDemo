package Poornimaacademy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Poornimaacademy.Abstractcomponents.AbstractClass;

public class OrderPage extends AbstractClass {
	
	WebDriver driver;
	
	
	public OrderPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);//from child to parent we are sending a variable, i,e driver
		this.driver =driver;
		//we are initializing and calling the elements here
		PageFactory.initElements(driver, this);
		
	}

	//pagefactory
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ProductNamesinOrder;
	
	public Boolean VerifyorderPageProducts(String CartZProduct)
	{
		
		//List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = false;
		//again iterate through each and every product in a list and verify that product name is Zara coat, if its matched then good
		for ( int j =0; j<ProductNamesinOrder.size();j++)
		{
			String zProduct = ProductNamesinOrder.get(j).getText();
			if( zProduct.equals(CartZProduct)) {
				//set a boolean flag when a match is found
				
				match = true;
				
				break;
			}
			
		}
		return match;
	
		
	}

}

package Poornimaacademy.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Poornimaacademy.TestComponents.BaseTest;
import Poornimaacademy.TestComponents.Retry;
import Poornimaacademy.pageobject.CartPageItems;
import Poornimaacademy.pageobject.ProductCatalog;

public class ErrorValidationTest extends BaseTest {
	//if i want to run only this test method then we use groups
	@Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)//As long as you keep this retryAnalyzer attribute for each and every test
                                                              //so the only those will be picked for rerun.
	public void loginerrorvalidation()
	{
	
    landingpage.loginApplication("poornimacs22@gmail.com", "Poorni@22");
    AssertJUnit.assertEquals("Incorrect email or password.",landingpage.ErrorMessage());
	//pass or fail
	

}
	@Test
	public void productordervalidation() //throws InterruptedException
	{
	
		String zaraProduct = "ZARA COAT 3";
		ProductCatalog productCatalog =landingpage.loginApplication("poornimaclk22@gmail.com", "Poornima@22");
		List<WebElement> products = productCatalog.getProductsList();
		productCatalog.getProductByNameAndAddToCart(zaraProduct);
		CartPageItems cartPageitems=productCatalog.getCartPage();
		Boolean match = cartPageitems.cartPageProducts("ZARA COAT 33");
		Assert.assertFalse(match);
		
	
		
	}
	
}

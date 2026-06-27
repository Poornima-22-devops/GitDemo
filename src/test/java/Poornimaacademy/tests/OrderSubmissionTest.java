package Poornimaacademy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Poornimaacademy.TestComponents.BaseTest;
import Poornimaacademy.pageobject.CartPageItems;
import Poornimaacademy.pageobject.CheckoutPagedetails;
import Poornimaacademy.pageobject.LandingPage;
import Poornimaacademy.pageobject.OrderPage;
import Poornimaacademy.pageobject.ProductCatalog;
import Poornimaacademy.pageobject.ThankYouPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderSubmissionTest extends BaseTest {
	String zaraProduct = "ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"purchase"})


	public void OrderSubmitTest(HashMap<String,String> input) throws IOException, InterruptedException {
		//dataset has come as hashmap 
		// TODO Auto-generated method stub
		
		
		//launching the browser
		//we can also write the below URL in the LandingPage class
		//driver.get("https://rahulshettyacademy.com/client");
		//creating object for LandingPage class 
		
		//calling the goToUrl to invoke the Url
		
		//instead of using the 3lines of code, we created a action method i,e LoginApplication and calling here
		//now we are calling the methods of the LandingPage using the object landingpage
		ProductCatalog productCatalog =landingpage.loginApplication(input.get("email"), input.get("password"));//here we are passing the email and password
		//enter the email id
		//driver.findElement(By.id("userEmail")).sendKeys("poornimacs22@gmail.com");
		//enter the password
		//driver.findElement(By.id("userPassword")).sendKeys("Poornima@22");
		//click on login
		//driver.findElement(By.id("login")).click();
		//now first you need to get all these products list
        //and then you iterate through each and every item in the list
        //and verify for which product this title is displayed
		//and then capture that product and click on Add to Cart.
		//if you can write any locator which can commonly retrieve and highlight all these cards
        //now we are writing css locator by taking the class name and storing in a list
		//List <WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		//Now I have to iterate each and every product and check for which product this title is displayed.
		
        //we are using java streams below
		//now the stream will help you to iterate through each and every item present in the products.
		//the first product will be retrieved simply by calling stream method.
		//once first product is retrieved,again, I will apply filter to check one condition here.
		//Whatever the stream gave me in the first iteration,that particular single product(product is a variable here) we have here,
      	//when you do driver.findElement,then it will scan an entire page.
        //But now what I will do?Because my actual card title is somewhere in this section,
		//I would apply like this product.findElement. it will search only in this block.In this block, there is only one b here,
        //and it will exactly go there.

		//WebElement prod = products.stream().filter(product -> 
		//product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);

		//add to cart
		//parent to child traverse cssSelector ".card-body button:last-of-type"
		//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		
        
		// Get all product names
        //List<WebElement> products =
               // driver.findElements(By.cssSelector(".mb-3"));
        //for(int i =0; i<products.size(); i ++)
       // {
        	 //String AddToCart= products.get(i).getText();
        	 //
        	 
        	// if(AddToCart.equals("ZARA COAT 3"))
        	 //{
        		//we are clicking in  add to cart element, we are using parent to child Xpath
				// driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        //}


		

	//}
		//list of products
		//we are applying explicit wait to laod the page
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		//List<WebElement> products =
		        //driver.findElements(By.cssSelector(".mb-3"));
        //we dont want above 3 lines of code
		//creating a class and object of the ProductCatalogpage
		//= new ProductCatalog(driver);
		List<WebElement> products = productCatalog.getProductsList();
		productCatalog.getProductByNameAndAddToCart(input.get("product"));
		/*for (int i = 0; i < products.size(); i++)
		{
			//gives you one specific product card.and searches only inside that card.
		    String productName = products.get(i)
		                                 .findElement(By.cssSelector("b"))
		                                 .getText();

		    if (productName.equals(zaraProduct))
		    {
		    	//add to cart
		    	//driver.findElement() → searches the entire page
		    	//product.findElement() → searches inside a specific product card
		        products.get(i)
		                .findElement(By.cssSelector(".card-body button:last-of-type"))
		                .click();

		        break;
		    }
		}*/
		
	   // we need to wait untill the toast message is shpwing up on screen(i,e product added to cart)
	   // and also we need to wait till the animating(buffer) icon disappers
	   // we are using explicit wait here
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating: this is a class helps u to load that we have to wait till the animating(buffer) icon disappears
		//to improves the here we are giving full webelements to improve the performance
		//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//click in cart button
		//css locator using RE
		//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		/*you can access this cartpage method from either of these classes,
        because it is extending parent class.i,e productCatalog.getCartPage */
		
		CartPageItems cartPageitems=productCatalog.getCartPage();//see the abstract class 
	
		//CartPageItems cartPageitems = new CartPageItems(driver);
		Boolean match = cartPageitems.cartPageProducts(input.get("product"));
		 
		
		//now items added to cart,those will be storing in the list
		//we need to create a css or xapth locator to identify the common names of the prodcuts in the cart
		/*List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = false;
		//again iterate through each and every product in a list and verify that product name is Zara coat, if its matched then good
		for ( int j =0; j<cartProducts.size();j++)
		{
			String zProduct = cartProducts.get(j).getText();
			if( zProduct.equals(zaraProduct)) {
				//set a boolean flag when a match is found
				
				match = true;
		        break;
				
			}
			
		}*/
		//Assert.assertTrue(match) to validate that the product exists in the cart."
		
		Assert.assertTrue(match);
		
		//after verify the productName
		//we need to checkout (css locator parent to child traverse by using classname)
		
		//driver.findElement(By.cssSelector(".totalRow button")).click();
		CheckoutPagedetails checkOut = productCatalog.Checkout();
		//after clicking on checkout, we need to fill all the required details
		//CheckoutPagedetails checkOut = new CheckoutPagedetails(driver);
		checkOut.chooseCountry("India");
		
		//we are achieving it by Action Class
		/*Actions a = new Actions(driver);
		//now we are sending keys to the editbox to select the country
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		//applying explicit wait to load the countries
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		//selecting India by writing the css locator parent to child traverse index
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();*/
		//after that we need to click on PLACEONORDER
		//driver.findElement(By.cssSelector(".action__submit")).click();
		ThankYouPage thankyoupage = checkOut.placeOrder();
		//after clicking on placeonorder, we are navigating to Thankyou page
		//ThankYouPage thankyoupage = new ThankYouPage(driver);
		String confirmMessage = thankyoupage.ConfirmMessage();
		//we are doing validation that thank you page is opened.
		//first we need to get the thank You text and store it in a variable and validate
		//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		//Looks like "Thankyou for the order."  is small letter in HTML web and THANK YOU FOR ORDER in the actual page
		//so instead of using this "Assert.assertEquals(confirmMessage, "Thankyou for the order." )"
		//we are using equaksIgnoreCase
		AssertJUnit.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//close the browser
		System.out.println("closing the browsersss");
		
}
  //using dependency attributes tests

	//verifying the ZARA COAT 3 is displayed on the orders page
	//writing the code to verification of the previous test results
	@Test(dependsOnMethods= {"OrderSubmitTest"}) //it will run the OrderHistoryTest after running the orderSumit
	public void OrderHistoryTest()
	{
		ProductCatalog productCatalog =landingpage.loginApplication("poornimacs22@gmail.com", "Poornima@22");//here we are passing the email and password
		//from any page we can go to orderspage
		OrderPage orderpage = productCatalog.gottoOrdersPage();
		//once we go the orderpage it returns object of orderpage
		Boolean match = orderpage.VerifyorderPageProducts(zaraProduct);
		Assert.assertTrue(match);
		//Assert.assertTrue(orderpage.VerifyorderPageProducts(zaraProduct));
		
	}

	//now will use Dataprovider : @DataProvider is a TestNG annotation used to run the same test method multiple times with different sets of data.
	
	/*@DataProvider
	public Object[][]  getData()
	{
		//we wan use the HashMap here
		HashMap <String,String> map = new HashMap <String ,String>();
		map.put("email","poornimacs22@gmail.com");
		map.put("password", "Poornima@22");
		map.put("Product", "ZARA COAT 3");
		
		HashMap <String,String> map1 = new HashMap <String ,String>();
		map1.put("email","poornimaclk22@gmail.com");
		map1.put("password", "Poornima@22");
		map1.put("Product", "ADIDAS ORIGINAL");
		return new Object [][] {{map},{map1}};-
	}*/
	//@Dataprovider
	//public Object[][]  getData()
	//return new Object [][] {{"poornimacs22@gmail.com","Poornima@22","ZARA COAT 3"},{"poornimaclk22@gmail.com","Poornima@22","ADIDAS ORIGINAL"}};
	
	@DataProvider
	public Object[][]  getData() throws IOException
	{
		//we can  write the DataReader i,e getJsonDataToHashMap method in BaseTest
		List<HashMap<String,String>>data = getJsonDataToHashMap(System.getProperty("user.dir")+"//src//test//java//Poornimaacademy//data//Purchaseorder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};
	}
	
	}




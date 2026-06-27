/*package Poornimaacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Poornimaacademy.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String zaraProduct = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//launching the browser
		driver.get("https://rahulshettyacademy.com/client");
		//creating object for LandingPage class 
		LandingPage landingpage = new LandingPage(driver);
		//enter the email id
		driver.findElement(By.id("userEmail")).sendKeys("poornimacs22@gmail.com");
		//enter the password
		driver.findElement(By.id("userPassword")).sendKeys("Poornima@22");
		//click on login
		driver.findElement(By.id("login")).click();
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
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> products =
		        driver.findElements(By.cssSelector(".mb-3"));

		for (int i = 0; i < products.size(); i++)
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
		}
		
	   // we need to wait untill the toast message is shpwing up on screen(i,e product added to cart)
	   // and also we need to wait till the animating(buffer) icon disappers
	   // we are using explicit wait here
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		//ng-animating: this is a class helps u to load that we have to wait till the animating(buffer) icon disappears
		//to improves that here we are giving full webelements to improve the performance
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		//click in cart button
		//css locator using RE
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		//now items added to cart,those will be storing in the list
		//we need to create a css or xapth locator to identify the common names of the prodcuts in the cart
		List <WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
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
			
		}
		//Assert.assertTrue(match) to validate that the product exists in the cart."
		Assert.assertTrue(match);
		
		//after verify the productName
		//we need to checkout (css locator parent to child traverse by using classname)
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		//after clicking on checkout, we need to fill all the required details
		//we are achieving it by Action Class
		Actions a = new Actions(driver);
		//now we are sending keys to the editbox to select the country
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		//applying ecplicit wait to load the countries
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		//selecting India by writing the css locator parent to child traverse index
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		//after that we need to click on PLACEONORDER
		driver.findElement(By.cssSelector(".action__submit")).click();
		//after clicking on placeonorder, we are navigating to Thankyou page
		//we are doing validation that thank you page is opened.
		//first we need to get the thank You text and store it in a variable and validate
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		//Looks like "Thankyou for the order."  is small letter in HTML web and THANK YOU FOR ORDER in the actual page
		//so instead of using this "Assert.assertEquals(confirmMessage, "Thankyou for the order." )"
		//we are using equaksIgnoreCase
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//close the browser
		System.out.println("closing the browser");
		driver.quit();
}
}*/




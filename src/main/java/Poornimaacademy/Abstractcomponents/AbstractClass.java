package Poornimaacademy.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Poornimaacademy.pageobject.CartPageItems;
import Poornimaacademy.pageobject.OrderPage;

//here we are writing the reusable codes in every test
public class AbstractClass {
	WebDriver driver;
	//constructor
	public AbstractClass(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement Headercart;
	
	//@FindBy(css="[routerlink*='cart']")
	//WebElement elem;
	
	By spinner = By.cssSelector(".ngx-spinner-overlay");
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement Headerorder;

	//we are creating a method i,e generic for all the tests
	//applying explicit wait if the we have a By Locator
	public void waitForElementToAppear(By FindBy) {//here By is return type of the By locator and FindBy is variable
		
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));//(By.cssSelector(".mb-3")//you cannot hard-code your locator here.so we are passing the argument
	}
	
	public void waitForElementToDisappear(WebElement ele)  {
		//Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	public void waitForElementsToDisappear(By Findby)  {
		//Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(Findby));
		
	}
	//applying explicit wait if the we have a webelement
	public void waitForElementsToAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	public void quitTheBrowser()
	{
		driver.quit();
	}
	//we are writing the cartpage in the Abstract class. It's because the header, what you see on top,is common for all pages./
	//So I don't want to restrict for this page.
	//this is  reusable 
	public CartPageItems getCartPage() 
	{
		waitForElementsToDisappear(spinner);
		Headercart.click();
		/*Now here you see go to cart page.

So you are clicking on the header cart

and you are very sure that it takes you

to cart page, right?

In that case,

let's encapsulate this object creation

inside this method only.

I'll cut it from here.

Go to this cart page.

Here itself, write it

and finally return this object to me.

That's all I need.

And hover your cursor, change method return type

to cart page.*/
		CartPageItems cartPageitems = new CartPageItems(driver);
		return cartPageitems;
	}
	
	public OrderPage gottoOrdersPage()
	{
		waitForElementsToDisappear(spinner);
		Headerorder.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
		
	}
}

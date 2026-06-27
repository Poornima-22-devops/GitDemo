package Poornimaacademy.TestComponents;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Poornimaacademy.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	//declare the driver globally
	public WebDriver driver;
	public LandingPage landingpage;//declare globally so that other class can call this 
	

	//Now I'll create one method here called initializeDriver. So basically all initialization of driver,what you need for your test
@Test
	public WebDriver IntializeDriver() throws IOException

{
//in Java there is one class called properties.So that properties class can read the global properties.
//load is a method.So here where you have to load file.Which file?Your global data .properties file,you have to load here, that's it.
 //When you load,this method will automatically parse that properties file and extract all key value pairs from it.
    Properties prop = new Properties();
    //that file needs to be sent as a input stream,how you can send this file as an input stream.
//So for that again in Java there is another class i,e FileInputStream class,which can convert your file into input stream object,
//dynamically generate the path.System.getProperty("user.dir") this will automatically get the project.
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Poornimaacademy//resources//GlobalData.properties");//path of the GlobalData.properties file

    prop.load(fis);//fis is the InputStream
    //below we have used java ternary operators
    String browserName = System.getProperty("browser")!=null? System.getProperty("browser"):prop.getProperty("browser");//we declared browser in the GlobalData.properties file
    //prop.getProperty("browser");
    //if(browserName.equalsIgnoreCase("chrome"))
     if(browserName.contains("chrome"))
    {
    	ChromeOptions options = new ChromeOptions();
    	WebDriverManager.chromedriver().setup();
    	if(browserName.contains("headless"))
    	{
    	options.addArguments("headless");
    }
	driver = new ChromeDriver(options);
	driver.manage().window().setSize(new Dimension(1440,900));//full screen
	//implicit wait
    }

   else if(browserName.equalsIgnoreCase("Firefox"))
{
	   System.setProperty("webdriver.gecko.driver","/Users/poornimacs/Downloads/geckodriver");
	   driver =new  FirefoxDriver();
	   
}
   else if(browserName.equalsIgnoreCase("edge"))
   {
	   System.setProperty("webdriver.edge.driver","/Users/poornimacs/Downloads/edgedriver_mac64/msedgedriver");
	    driver = new EdgeDriver();
   }
		
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
return driver;
}
//we are writing this DataReader method
public List<HashMap<String, String>> getJsonDataToHashMap(String Filepath) throws IOException
{
/*
* 
In Java there is one method which will read file.i,e FileUtils

That means if you just pass JSON file,

it will scan the entire content of your JSON

and convert that into one string variable.
*/
	//read json to string
	//So basically in the new method as a second argument we have to give the encoding on how to convert it into string.So this is standard way of converting UTF 8.
	String JsonContent = FileUtils.readFileToString(new File(Filepath),StandardCharsets.UTF_8);
	
	/*Some external utilities are there,

which can convert your JSON content to hash map. i,e new dependency called "Jackson data bind".

This is the one of the dependency which can help

you to convert the jsoncontent into hash map.*/
	//string to HashMap using JacksonDataBind \. we have to get it in mvn repo and stored on POM.xml

	ObjectMapper mapper = new ObjectMapper();
	//we created object of this class called object mapper, right? So in this class there is
    //a method called read value which can read the string and convert that to hash map.
	List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
	//{map,map}
	return data;
}

//screenshot
public  String Screenshot(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File (System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	FileUtils.copyFile(source,file);
	//return file;
	return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
}

@BeforeMethod(alwaysRun=true) //this method will execute first i,e launching an application.
public LandingPage LaunchApplication() throws IOException
{
	driver=IntializeDriver();
	landingpage = new LandingPage(driver);
	landingpage.goToUrl();
	return landingpage;
}

@AfterMethod(alwaysRun=true)
public void teardown()
{
	driver.quit();
}

}


/*
So this is for Chrome browser,

but technically when you're developing a framework,

you could have worked in multiple browsers, right?

So what you can do,

you can maintain one global properties file,

where you store which browser you want to execute,

based upon the global property you set.
Let's say if you set Chrome, then code browser,

Chrome browser related code will get execute.

If you set global property to Firefox,

then the whole framework will run in Firefox browser.*/


/*when you are working on an app,

now in our case you are working

on this particular e-commerce app.

So that means no matter what test you run,

you have to first get onto this page, right?

So for that, what we can do,

we will simply create one method in our base test.

Launch application.*/




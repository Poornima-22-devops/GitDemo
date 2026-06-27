package Poornimaacademy.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Poornimaacademy.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
    
	ExtentTest test;//this will holds the entry of the test
	ExtentReports extent =  ExtentReporterNG.getReportObject();//class and their  method
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();//Thread safe
	@Override
	public void onTestStart(ITestResult result) {//result variable holds the details of the test which is going to execute.
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		test = extent.createTest(result.getMethod().getMethodName());//same result variable is used here,setting an entry for the test case loginerrorvalidation() in ErrorvalidationTest class
	    extentTest.set(test);//assign a unique thread Id(ErrorValodationTest)->test
	    
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS,"Test Passed");//logs the info when the test got executed
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		//test.log(Status.FAIL,"Test fail");//it just logs the info
		
		extentTest.get().fail(result.getThrowable());//it prints the error message in the report.
		/*
		 * two things here.

When you say get test class, it will first go in the testng.xml 

and get that class what this test is referring.

And when you say real class, from this test,

it will actually go to the actual real class, right?
So there we are saying get the field of driver, simple,

from that class whatever the field

that driver is using, get it.

So now, if you are running this error validation test,

now, one driver is using this class.
		 */
				
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		//takes screenshot if test fails,and attach screenshot to the report
		//we are calling the method from the baseTest
		String filePath = null;
		try {
			filePath = Screenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//we are giving the testcasename to take the screenshot
	    //So this below method takes the filepath from your local system and attach to your extent report.
		extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
		extent.flush();//it will make sure reports are generated
	}

}

/*
 * our testNg.xm shpuld regonize where our listeners are. so we have to declare listeners in testNG.xml
 */

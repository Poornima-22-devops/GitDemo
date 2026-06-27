package Poornimaacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//will do some configuration 
		reporter.config().setReportName("web Automation");
		reporter.config().setDocumentTitle("Test Results");
		//now above reporter object is created and that object holds some details
		//now will create a another class, this is responsible for drive all our reporting executions
		
	  ExtentReports  extent = new ExtentReports();
		extent.attachReporter(reporter);//attach the object of the ExtentSparkerReporter
		extent.setSystemInfo("Tester", "poornima");//tester name
		return extent;
	}
	
	

}

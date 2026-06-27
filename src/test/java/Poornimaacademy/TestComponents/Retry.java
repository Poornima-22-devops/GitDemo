package Poornimaacademy.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	/*
	 * But after completing those listeners,

if it failed, it'll come here to check and ask us,

do I need to rerun again

just to make sure I might be flaky test.

Do you want me to rerun?

That is the question it'll ask

once it comes this block, 
also asks how want u want me to run.
	 */
	
	int count =0;
	int maxTry =1;//depends on how many time we want to run the test
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxTry)
		{
			count++;
			return true;//if condition is true then it keep on running the tests
		}
		return false;//if condition is false it stops retry the test.
	}

}

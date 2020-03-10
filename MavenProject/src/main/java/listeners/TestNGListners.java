package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListners implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Start method of ITestListners: "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("After test ran successfull for ITestListners: "+result.getName());
	}
}

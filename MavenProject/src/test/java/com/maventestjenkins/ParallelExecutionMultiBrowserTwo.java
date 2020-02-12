package com.maventestjenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionMultiBrowserTwo {

	WebDriver driver = null;
	static String prjPath = System.getProperty("user.dir");

	
	@Parameters("browserName")
	@BeforeTest
	public void multiBrowserSetup(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("This is Chrome");
			System.out.println("Thread : "+Thread.currentThread().getId());
		}
		else if(browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("This is Firefox");
			System.out.println("Thread : "+Thread.currentThread().getId());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("This is IE");
			System.out.println("Thread : "+Thread.currentThread().getId());
		}
		
	}

	@Test
	public void multiBrowserDemo() {
		
		driver.get("http://demo.automationtesting.in");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		System.out.println("Test ran successfully");
		//driver.close();
		driver.quit();
	}
	
}

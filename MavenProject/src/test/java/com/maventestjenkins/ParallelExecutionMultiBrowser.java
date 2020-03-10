package com.maventestjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParallelExecutionMultiBrowser {

	WebDriver driver = null;
	String prjPath = System.getProperty("user.dir");

	@Test(priority = 1)  //priority is optional
	public void chromeBroweser() {

		try {

			WebDriverManager.chromedriver().setup();
			System.out.println("chrome method | "+Thread.currentThread().getId());
			//System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe"); //Line is commented as we are using WebDriver Manager
			driver = new ChromeDriver();
			driver.get("https://google.co.in");
			Thread.sleep(3000);
			driver.close();
		}
		catch (Exception e) {	
			System.out.println("Error occurred");;
		}
	}

	@Test(priority = 2)
	public void firefoxBroweser() {

		try {
			WebDriverManager.firefoxdriver().setup();
			//Thread.sleep(3000);
			System.out.println("Firefox method | "+Thread.currentThread().getId());
			driver = new FirefoxDriver();
			//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver.get("https://selenium.dev/");
			Thread.sleep(6000);

		} 

		catch (Exception e) {
			System.out.println("Exception occurred");
		}
		finally {
			driver.quit();

		}
	}
}

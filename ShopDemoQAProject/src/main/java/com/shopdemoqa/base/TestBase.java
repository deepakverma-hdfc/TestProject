package com.shopdemoqa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.shopdemoqa.pages.HomePage;
import com.shopdemoqa.utils.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver = null;
	public static Properties prop;
	

	public TestBase() {

		prop = new Properties();
		//String prjPath = System.getProperty("user.dir");
		try {
			FileInputStream ip = new FileInputStream("/Users/Deepak/eclipse-workspace/ShopDemoQAProject/src/main/java/com/shopdemoqa/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No driver is defined in config");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}

	public static void searchItemByKeyword(String keyword) {
		HomePage home = new HomePage();
		Actions action = new Actions(driver);
		home.click_SearchIcon(); 
		home.input_SearchTxt(keyword);
		action.sendKeys(Keys.ENTER).perform(); 
		home.ShowingResultPage();	 
	}

}

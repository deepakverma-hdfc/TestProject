package com.shopdemoqa.teststeps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import com.shopdemoqa.base.TestBase;
import com.shopdemoqa.pages.HomePage;
import com.shopdemoqa.pages.SearchResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Steps_SearchResultPage extends TestBase {

	HomePage home = new HomePage();
	SearchResultPage resultPage = new SearchResultPage();
	Actions act = new Actions(driver);
	
	public Steps_SearchResultPage() {
		super();
		//initialization();
	}
	
	@Given("^User is on search result page$")
	public void user_is_on_search_result_page(){
		
		searchItemByKeyword(prop.getProperty("searchItem"));
		String title = resultPage.resultPageTitle();
		Assert.assertEquals("Search Results for “Shirt” – ToolsQA Demo Site", title);
		
	}

	@When("^Scroll down the page$")
	public void scroll_down_the_page(){	
		
		act.sendKeys(Keys.PAGE_DOWN).perform();
		act.sendKeys(Keys.PAGE_UP).perform();

		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)","");

		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		js.executeScript("window.scrollBy(0,-500)","");

		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);	
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	@Then("^List of product item shows on the page$")
	public void list_of_product_item_shows_on_the_page() {
	}

	@Then("^Count of matching product displayed on the page$")
	public void count_of_matching_product_displayed_on_the_page(){
		
		//String resultTxt = resultPage.resultItemCount();
		//Assert.assertTrue(resultTxt !=null);
		
		driver.quit();
	}
	
}

package com.shopdemoqa.teststeps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import com.shopdemoqa.base.TestBase;
import com.shopdemoqa.pages.HomePage;
import com.shopdemoqa.pages.SearchResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps_HomePage extends TestBase{

	public Steps_HomePage() {
		super();
	}

	HomePage home = new HomePage();
	SearchResultPage searchRsltPage;
	SearchResultPage resultPageStps;
	Actions action = new Actions(driver);
	
	@Given("^user is on Home Page$")
	public void user_is_on_Home_Page(){		
		Assert.assertEquals("ToolsQA Demo Site – ToolsQA – Demo E-Commerce Site", home.pageTitileTest());
	}

	@Given("^click on search icon$")
	public void click_on_search_icon(){
		home.click_SearchIcon();
	}

	@When("^he enter product in search field$")
	public void he_enter_product_in_search_field(){
		home.input_SearchTxt(prop.getProperty("searchItem"));
	}

	@When("^hits ENTER key$")
	public void hits_ENTER_key(){		
		action.sendKeys(Keys.ENTER).perform();
	}

	@Then("^result page is displayed$")
	public void result_page_is_displayed(){
		
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);	
		searchRsltPage = home.ShowingResultPage();
		String title = searchRsltPage.resultPageTitle();
		Assert.assertEquals("Search Results for “Shirt” – ToolsQA Demo Site", title);
		
		driver.quit();
	}

}

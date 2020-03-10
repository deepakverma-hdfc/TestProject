package com.shopdemoqa.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.shopdemoqa.base.TestBase;

public class HomePage extends TestBase{

	SearchResultPage resultPage;
	public String rsltText = "Showing all";

	@FindBy(how = How.XPATH, using="*//a[contains(@class,'noo-search')]")
	private WebElement searchBoxKey;

	@FindBy(how = How.XPATH, using="//input[contains(@class,'form-control')]")
	private WebElement txtInput;

	@FindBy(how = How.XPATH, using="//p[contains(@class,'woocommerce-result-count')]")
	private WebElement txt_ShowingRslt;

	public HomePage() {
		initialization();
		PageFactory.initElements(driver, this);	//'this' represents here current page object class HomePage.class
	}

	public String pageTitileTest() {	
		return driver.getTitle();
	}

	public void click_SearchIcon() {
		searchBoxKey.click();
	}

	public void input_SearchTxt(String searchKey){
		txtInput.sendKeys(searchKey);
	}

	public SearchResultPage ShowingResultPage() {	

		boolean flag = txt_ShowingRslt.isDisplayed();
		Assert.assertTrue("Search result page is diasplayed", flag);

		return new SearchResultPage();
	}

}

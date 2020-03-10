package com.shopdemoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.shopdemoqa.base.TestBase;

public class SearchResultPage extends TestBase{


	@FindBy(how = How.XPATH, using="//p[contains(@class,'woocommerce-result-count')]")
	private WebElement resultCount;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}

	public String resultPageTitle() {		
		return driver.getTitle();
	}	

	public String resultItemCount() {
		
		return resultCount.getText();
	}


}

package com.alation.testsuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.alation.library.*;
import com.alation.locators.HomePageLocators;
import com.alation.locators.ProductDetailPageLocators;
import com.alation.testcase.HomePage;
import com.alation.testcase.ProductDetailPage;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AmazonTest {

	WebElement element;
	public static Utils utils = new Utils();
	public static HomePage homepage = new HomePage();
	public static ProductDetailPage pdp = new ProductDetailPage();

	@BeforeClass
	public static void launchBrowser() throws Exception {
		try {
			utils.openBrowser();
			utils.setTrueResult("Launched the Browser");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	@Before
	public void openSite() throws Exception {
		try {
			homepage.openApp(DataInput.url);
			if (utils.checkElement(HomePageLocators.signInLink)) {
				utils.setTrueResult("Amazon Webpage is launched Successfully.");
			} else {
				utils.setFalseResult("Amazon Webpage is NOT launched.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	// Test Suite for Searching a Product & Select First Test Result
	// Get the Product details like Title, Price & Edition details
	// Write them to a file
	@Test
	public void TestSuite_1() throws Exception {
		try {
			searchProduct();
			homepage.selectFromSearchResultsByNumber(1);
			utils.switchTabInBrowswer(1);
			utils.waitPageLoadTimeOutBySecond(5);
			pdp.getProductTitle();
			pdp.getProductPrice();
			if (utils.checkElement(ProductDetailPageLocators.lnkShowEditions)) {
				utils.click(ProductDetailPageLocators.lnkShowEditions);
				pdp.getProductEditions();
			} else {
				utils.logInfo("No Editions available");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	// Test Suite for Searching a product & Selecting the appropriate product from
	// the Results list
	// Get the Product details like Title, Price & Edition details
	// Write them to a file
	 @Test
	public void TestSuite_2() throws Exception {
		try {
			searchProduct();
			homepage.selectFromSearchResultsByName(DataInput.productName);
			utils.switchTabInBrowswer(1);
			utils.waitPageLoadTimeOutBySecond(5);
			pdp.getProductTitle();
			pdp.getProductPrice();
			if (utils.checkElement(ProductDetailPageLocators.lnkShowEditions)) {
				utils.click(ProductDetailPageLocators.lnkShowEditions);
				pdp.getProductEditions();
			} else {
				utils.logInfo("No Editions available");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	@After
	public void closeBrowser() throws Exception {
		try {
			Thread.sleep(5000);
			utils.closeBrowser();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	@AfterClass
	public static void quitBrowser() throws Exception {
		try {
			utils.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	// Method for Selecting the Category from Search Dropdown, searching product
	// using a keyword
	public void searchProduct() throws Exception {
		try {
			homepage.click(HomePageLocators.selectCategoryDD);
			homepage.selectCategory(DataInput.CategoryName);
			homepage.type(HomePageLocators.searchTextBox, DataInput.searchKeyword);
			homepage.click(HomePageLocators.searchButton);
			homepage.waitPageLoadTimeOutBySecond(5);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}
}

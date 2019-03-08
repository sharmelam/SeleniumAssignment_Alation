package com.alation.testcase;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.alation.library.*;
import com.alation.locators.HomePageLocators;

public class HomePage extends Utils {

	public static Utils utils = new Utils();

	public void openApp(final String url) throws Exception {
		try {
			webdriver.get(url);
			webdriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void selectCategory(final String categoryName) throws Exception {
		try {
			String xpath = HomePageLocators.selectCategory + DataInput.CategoryName + "')]]";
			click(xpath);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void selectFromSearchResultsByNumber(final int resultNumber) throws Exception {
		try {
			String resultxpath = HomePageLocators.searchResultList + "/li[" + resultNumber
					+ "]/div/div/div/div[2]/div[1]/div[1]/a/h2";
			click(resultxpath);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void selectFromSearchResultsByName(final String productName) throws Exception {
		try {
			final WebElement element = webdriver.findElement(By.xpath(HomePageLocators.searchResultList));
			final List<WebElement> resultList = element.findElements(By.tagName("li"));
			for (int i = 0; i < resultList.size(); i++) {
				int temp = i + 1;
				String resultTextxpath = HomePageLocators.searchResultList + "/li[" + temp
						+ "]/div/div/div/div[2]/div[1]/div[1]/a/h2";
				String text = getText(resultTextxpath);
				if (text.contains(productName)) {
					click(resultTextxpath);
					break;
				}
			}
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

}

package com.alation.testcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.alation.library.Utils;
import com.alation.locators.*;

public class ProductDetailPage extends Utils {

	public static HomePage homepage = new HomePage();

	public void getProductTitle() throws Exception {
		try {
			String title = "";
			title = getText(ProductDetailPageLocators.lblTitle);
			write("******Product Details*******");
			write("Product Title: " + title);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void getProductPrice() throws Exception {
		try {
			String price = "";
			price = getText(ProductDetailPageLocators.lblPrice);
			write("Product Price: " + price);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void getProductEditions() throws Exception {
		try {
			final List<WebElement> editionList = webdriver
					.findElements(By.xpath(ProductDetailPageLocators.editionTable));
			if (editionList.size() != 0) {
				write("**Edition Details**");
			}
			for (int i = 1; i <= editionList.size(); i++) {
				String xpathTitle = "(" + ProductDetailPageLocators.editionTable
						+ ProductDetailPageLocators.editionTitle + ")[" + i + "]";
				String xpathprice = "(" + ProductDetailPageLocators.editionTable
						+ ProductDetailPageLocators.editionPrice + ")[" + i + "]";
				write(i + ": " + getText(xpathTitle) + "   " + getText(xpathprice));
			}

			write("*******End of Product Details*******");
			write("**************************************");
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}
}

package com.alation.locators;

public class ProductDetailPageLocators {

	//Locators for Product Detail page
	public static String lblPrice = "//div[@id='soldByThirdParty']/span";
	public static String lblCurrency = "//div[@id='soldByThirdParty']/span/span";
	public static String lblTitle = "//span[@id='productTitle']";
	public static String lnkShowEditions = "//a[@class='a-link-expander a-spacing-top-micro a-spacing-small a-size-small']/span[@id='showMoreFormatsPrompt']";
	public static String lnkHideEditions = "//a[@class='a-link-expander a-spacing-top-micro a-spacing-small a-size-small']/span[@id='hideMoreFormatsPrompt']";
	public static String editionTable = "//span[@data-action='tmm-see-more-editions-click' and @class='a-declarative']";
	public static String editionTitle = "/table/tbody/tr/td[1]";
	public static String editionPrice = "/table/tbody/tr/td[2]";
	public static String editionNewFrom = "/table/tbody/tr/td[3]";

}

package com.alation.library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alation.locators.HomePageLocators;
import com.alation.library.*;

public class Utils {
	public static String driverPath;
	public static String ResultPath;
	public static WebDriver webdriver;

	public WebDriver getDriver() {
		return webdriver;
	}

	public String getText(final String xpath) throws Exception {
		try {
			String text = webdriver.findElement(By.xpath(xpath)).getText().toString();
			return text;
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void switchTabInBrowswer(int tabNumber) throws Exception {
		try {
			ArrayList<String> tabs2 = new ArrayList<String>(webdriver.getWindowHandles());
			webdriver.switchTo().window(tabs2.get(tabNumber));
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void openBrowser() throws Exception {
		try {
			if (DataInput.browserName.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", getDriverPath() + "chromedriver.exe");
				webdriver = new ChromeDriver();
				webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webdriver.manage().window().maximize();
			} else if (DataInput.browserName.contains("firefox")) {
				System.setProperty("webdriver.gecko.driver", getDriverPath() + "geckodriver.exe");
				webdriver = new FirefoxDriver();
				webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				webdriver.manage().window().maximize();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void waitPageLoadTimeOutBySecond(final long sec) throws Exception {
		try {
			webdriver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void type(final String xpath, final String value) throws Exception {
		try {
			webdriver.findElement(By.xpath(xpath)).sendKeys(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void click(final String xpath) throws Exception {
		try {
			webdriver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void select(final String xpath, final String value) throws Exception {
		try {
			final WebElement object = webdriver.findElement(By.xpath(xpath));
			final Select obj = new Select(object);
			obj.selectByVisibleText(value);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public boolean checkElement(final String xpath) throws Exception {

		WebElement returnObj = null;
		try {
			returnObj = webdriver.findElement(By.xpath(xpath));
			if (!returnObj.isDisplayed()) {
				new WebDriverWait(webdriver, 25).until(ExpectedConditions.presenceOfElementLocated(By.name(xpath)));
				returnObj = webdriver.findElement(By.name(xpath));
			}

			if (returnObj == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	public void closeBrowser() throws Exception {
		try {			
			webdriver.close();
			switchTabInBrowswer(0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void quit() throws Exception {
		try {
			webdriver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public String datetimeStamp() throws Exception {
		try {
			final DateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
			final Date date = new Date();
			return dateFormat.format(date);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void setTrueResult(final String actual) throws Exception {
		try {
			System.out.println("PASSED: " + actual);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void setFalseResult(final String reason) throws Exception {
		try {
			System.out.println("FAILED: " + reason);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public void logInfo(final String info) throws Exception {
		try {
			System.out.println("INFO: " + info);
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

	public String getDriverPath() {
		String projectPath = new File("").getAbsolutePath();
		projectPath = projectPath.replace("\\", "/");

		driverPath = projectPath + "/" + GlobalVariables.DRIVER_FOLDER + "/";
		return driverPath;
	}

	public String getResultPath() {
		String projectPath = new File("").getAbsolutePath();
		projectPath = projectPath.replace("\\", "/");

		ResultPath = projectPath + "/" + GlobalVariables.RESULTS_FOLDER + "/";
		return ResultPath;
	}

	public void write(String text) throws Exception {
		try {
			File file = new File(getResultPath() + GlobalVariables.ResultFileName+datetimeStamp()+".txt");
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(text);
			setTrueResult("Writen to the File : " + text);
			br.newLine();
			br.close();
		} catch (final Exception e) {
			System.out.println(e.getMessage());
			throw new Exception();
		}
	}

}

package common;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.xml.DOMConfigurator;

import Interfaces.AbstractPage;

public class BrowserManager{
	
//	public BrowserManager(WebDriver driver){
//		this.driver = driver;
//	}
	/**
	 * Open Browser
	 * @param driver
	 * @param browser
	 * @return driver
	 */
	public WebDriver openBrowser(String browser) {
		try {
			if (browser.toString().toLowerCase().contains("chrome")) {
				startChromeDriver();
				driver = new ChromeDriver();
			} else if (browser.toString().toLowerCase().contains("ie")) {
				startIEDriver();
				driver = new InternetExplorerDriver();
			} else if (browser.toString().toLowerCase().contains("firefox")) {
				startFFDriver();
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			System.out.println("No browser was found");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		try {
			Robot rb = new Robot();
			rb.mouseMove(0, 0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.focus();");
		navigateToURL(Constant.URL);
		System.out.println(driver);
		return driver;
	}
	/**
	 * Open URL
	 * @param driver
	 * @param URL
	 */
	public void navigateToURL(String URL) {
		driver.navigate().to(URL);
	}
	/**
	 * Go to Homepage
	 * @param driver
	 */
	public void goToHomePage(){
		driver.navigate().to(Constant.URL);
	}
	
	/**
	 * Navigate Back
	 * @param driver
	 */
	public void navigateBack(){
		driver.navigate().back();
	}

	public void startChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "..\\PresDemo\\src\\test\\resources\\chromedriver228.exe");
	}

	public void startIEDriver() {
		System.setProperty("webdriver.ie.driver", "..\\PresDemo\\src\\test\\resources\\IEDriverServer.exe");
	}
	

	public void startFFDriver() {
		System.setProperty("webdriver.gecko.driver", "..\\PresDemo\\src\\test\\resources\\geckodriver.exe");
	}

	public void closeBrowser() {
		driver.quit();
	}
	public BrowserManager(){

		log = LogFactory.getLog(getClass());
	}
	
	protected boolean verifyTrue(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertTrue(condition);
				log.info("==Verify condition is PASSED==");
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
				log.info("==Verify condition is FAILED==");
			}
		} else {
			Assert.assertTrue(condition);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return verifyTrue(condition, false);
	}

	protected boolean verifyFalse(boolean condition, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertFalse(condition);
				log.info("==Verify condition is PASSED==");
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
				log.info("==Verify condition is FAILED==");
			}
		} else {
			Assert.assertFalse(condition);
		}
		return pass;

	}

	protected boolean verifyFalse(boolean condition) {
		return verifyFalse(condition, false);
	}

	protected boolean verifyEquals(Object actual, Object expected, boolean halt) {
		boolean pass = true;
		if (halt == false) {
			try {
				Assert.assertEquals(actual, expected);
				log.info("==Verify condition is PASSED==");
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
				log.info("==Verify condition is FAILED==");
			}
		} else {
			Assert.assertEquals(actual, expected);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return verifyEquals(actual, expected, false);
	}


	public WebDriver driver;
	protected Log log;
}

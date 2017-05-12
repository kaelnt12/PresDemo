package TestPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BrowserManager;
import common.Constant;
import page.AbstractPage;
import page.TransactionPage;

public class TestStore extends BrowserManager {
	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional("chrome") String browser) {
		driver = openBrowser(browser);
		abs = new AbstractPage(driver);
		str = new TransactionPage(driver);
		storeUsername = Constant.STORE_USERNAME;
		storePassword = Constant.STORE_PASSWORD;
		
	}

	@Test (description = "TC_001 - Create New Transaction")
	public void TC_001_CreateNewTransaction() {

		log.info("Step 01: Login as Lender");
		abs.loginAsStoreLender(storeUsername, storePassword);
		
		log.info("VP 01: Verify that 'New' button is displayed");
		verifyTrue(str.isNewTransactionButtonPresent());
		
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		closeBrowser();
	}

	public WebDriver driver;
	public String storeUsername, storePassword;
	public AbstractPage abs;
	public TransactionPage str;
	public String URL;
	
}

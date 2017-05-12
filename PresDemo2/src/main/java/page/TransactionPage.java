package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.AutomationAction;

public class TransactionPage extends AutomationAction{

	public TransactionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isNewTransactionButtonPresent(){
		WebElement element = findElement(driver, Interfaces.Store.DYNAMIC_MENU_BUTTON, "New");
		return element.isDisplayed();
	}
WebDriver driver;
}

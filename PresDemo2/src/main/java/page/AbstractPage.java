package page;

import org.openqa.selenium.WebDriver;

import common.AutomationAction;

public class AbstractPage extends AutomationAction{
	public AbstractPage(WebDriver driver){
		this.driver = driver;
	}
	
	/**
	 * Login As Lender
	 * @param usname
	 * @param pwd
	 */
	public void loginAsStoreLender(String usname, String pwd){
		waitForControl(driver, Interfaces.AbstractPage.USERNAME_TEXTBOX, time);
		type(driver, Interfaces.AbstractPage.USERNAME_TEXTBOX, usname);
		type(driver, Interfaces.AbstractPage.PASSWORD_TEXTBOX, pwd);
		click(driver, Interfaces.AbstractPage.SIGN_IN_BUTTON);
	}
	
	
	WebDriver driver;
}

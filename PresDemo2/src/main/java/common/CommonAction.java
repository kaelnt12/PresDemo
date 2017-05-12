package common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import Interfaces.AbstractPage;

public class CommonAction {
	public static int getRandomNumber() {
		Random rd = new Random();
		int i = rd.nextInt(10000) + 1;
		return i;
	}

	public static void pressEnterKey() {
		try {
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {

		}
	}
	public static String getDynamicXpath(String yourXpath,String yourText){
		String xpath = String.format(yourXpath, yourText);
		return xpath;
	}
}

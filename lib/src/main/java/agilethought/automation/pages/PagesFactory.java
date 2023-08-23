package agilethought.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PagesFactory {

	public static MicrosoftPage getMicrosoftPage(WebDriver driver) {
		return PageFactory.initElements(driver, MicrosoftPage.class);
	}
	
	public static WindowsPage getWindowsPage(WebDriver driver) {
		return PageFactory.initElements(driver, WindowsPage.class);
	}
	
	public static VSEnterprisePage getVSEnterpricePage(WebDriver driver) {
		return PageFactory.initElements(driver, VSEnterprisePage.class);
	}
	
	public static CartPage getCartPage(WebDriver driver) {
		return PageFactory.initElements(driver, CartPage.class);
	}
}

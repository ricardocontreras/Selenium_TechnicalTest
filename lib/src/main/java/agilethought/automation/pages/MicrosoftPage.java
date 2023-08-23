package agilethought.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MicrosoftPage {

	final WebDriver driver;
	
	public MicrosoftPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.CSS, using = "li > a.c-uhf-nav-link")
	List<WebElement> menuList;
	
	@FindBy(how = How.CSS, using = "li a#shellmenu_2")
	WebElement windowsOption;
	
	public List<WebElement> getMenuLists(){
		return menuList;
	}
	
	public void clickWindowsOption() {
		windowsOption.click();
	}
}

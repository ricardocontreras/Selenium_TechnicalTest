package agilethought.automation.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public WindowsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
	}
	
	@FindBy(how = How.CSS, using = "a#uhfCatLogo")
	WebElement buttonWindows;
	
	@FindBy(how = How.CSS, using = "button#c-shellmenu_56")
	WebElement buttonAboutWindows;
	
	@FindBy(how = How.CSS, using = "button#search")
	WebElement buttonSearch;
	
	@FindBy(how = How.CSS, using = "input#cli_shellHeaderSearchInput")
	WebElement inputSearch;
	
	@FindBy(how = How.CSS, using = "#uhf-g-nav > ul > li:nth-child(2) > div > ul > li a")
	List<WebElement> listOfAboutWindows;
	
	@FindBy(how = How.CSS, using = "#universal-header-search-auto-suggest-ul > li > a > div > span:nth-child(1)")
	List<WebElement> listOfSearch;
	
	public void clickOnAboutWindows() {
		wait.until(ExpectedConditions.visibilityOf(buttonWindows));
		buttonAboutWindows.click();
	}
	
	public void clickOnSearch() {
		wait.until(ExpectedConditions.visibilityOf(buttonSearch));
		buttonSearch.click();
	}
	
	public void fieldSearch() {
		wait.until(ExpectedConditions.visibilityOf(inputSearch));
		inputSearch.sendKeys("Visual Studio");
	}
	
	public List<String> getListAboutWindows(){
		wait.until(ExpectedConditions.visibilityOfAllElements(buttonWindows));
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfAboutWindows));
		return listOfAboutWindows.stream().map(WebElement::getText).toList();
	}
	
	public void getListSearch(String value){
		wait.until(ExpectedConditions.visibilityOfAllElements(inputSearch));
		wait.until(ExpectedConditions.visibilityOfAllElements(listOfSearch));
		
		List<WebElement> option = new ArrayList<WebElement>();
		
		listOfSearch.stream().forEach(element -> {
			wait.until(ExpectedConditions.visibilityOf(element));
			if(element.getText().equalsIgnoreCase(value)) {
				option.add(element);
			}
		});
		
		option.get(0).click();
	}
}

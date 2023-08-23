package agilethought.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import agilethought.automation.utils.UtilPages;

public class VSEnterprisePage {
	
	WebDriver driver;
	WebDriverWait wait;

	public VSEnterprisePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
	}
	
	@FindBy(how = How.CSS, using = "#geo-selector-modal > div > div")
	WebElement modalLanguage;
	
	@FindBy(how = How.CSS, using = "div.modal-header > button.close.geo-selector-localized-copy.preferred-redirect-cancel")
	WebElement buttonCloseModalLanguage;
	
	@FindBy(how = How.CSS, using = "#rootContainer_BuyBox > section > div p > span")
	WebElement labelPrice;
	
	@FindBy(how = How.CSS, using = "div.col-lg-3.buy-box-right-col > div > fieldset > div:nth-child(3) > label")
	WebElement radioButtonPrice;
	
	@FindBy(how = How.CSS, using = "div #buybox-cta-proper")
	WebElement buttonCar;
	
	public void waitModalLanguage() {
		wait.until(ExpectedConditions.visibilityOf(modalLanguage));
	}
	
	public void clickOnButtonCloseModalLanguage() {
		wait.until(ExpectedConditions.visibilityOf(modalLanguage));
		buttonCloseModalLanguage.click();
	}
	
	public double getLabelPrice() {
		String price = labelPrice.getText().replaceAll("[^0-9.]", "");
		return Double.parseDouble(price);
	}
	
	public void radioButtonPrice() {
		UtilPages.scrollWebElement(driver, radioButtonPrice);
		radioButtonPrice.click();
	}
	
	public void buttonCar() {
		wait.until(ExpectedConditions.visibilityOf(buttonCar));
		buttonCar.click();
	}
}

package agilethought.automation.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
	}
	
	@FindBy(how = How.CSS, using = "div.headerContainerNew--TUgf1iFq > h1")
	WebElement labelTitle;
	
	@FindBy(how = How.CSS, using = "span.c-price > span.totalListPrice--xsXwCqf0 > span")
	WebElement labelPrincipalPrice;
	
	@FindBy(how = How.CSS, using = "section span.textAlign--jsUpELxB span.c-price > span:nth-child(3) span")
	WebElement labelSubTotal;
	
	@FindBy(how = How.CSS, using = "span.textAlign--jsUpELxB > strong > span")
	WebElement labelTotalPrice;
	
	@FindBy(how = How.CSS, using = "div.actionItemsClassNew--SfejM4Ig.dropdown-wrapper > select")
	WebElement dropdown;
	
	public void waitTitlePage() {
		wait.until(ExpectedConditions.visibilityOf(labelTitle));
	}
	
	public double getlabelPrincipalPrice() {
		String price = labelPrincipalPrice.getText().replaceAll("[^0-9.]", "");
		return Double.parseDouble(price);
	}
	
	public double getlabelSubTotal() {
		String price = labelSubTotal.getText().replaceAll("[^0-9.]", "");
		return Double.parseDouble(price);
	}
	
	public double getlabelTotalPrice() {
		String price = labelTotalPrice.getText().replaceAll("[^0-9.]", "");
		return Double.parseDouble(price);
	}
	
	public void clickOnDropdown(String value) {
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByValue(value);		
		try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
}

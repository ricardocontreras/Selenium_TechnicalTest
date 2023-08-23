package agilethought.automation;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import agilethought.automation.test.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootTest(classes = TestConfig.class)
@ActiveProfiles(value = "dev")
public class BaseTest {
	
	@Value("${test.url}")
    public String testProperty;
	
	WebDriver driver;

	@BeforeTest
	public void BeforeTest() {
		setDriver(WebDriverManager.chromedriver().create());
		getDriver().manage().window().maximize();
	}
	
	@AfterTest
	public void AfterTest() {
		getDriver().quit();
	}
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}

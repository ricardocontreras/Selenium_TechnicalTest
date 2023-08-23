package agilethought.automation.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import agilethought.automation.BaseTest;
import agilethought.automation.data.TestData;
import agilethought.automation.pages.PagesFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MicrosoftTest extends BaseTest{

	@Test
	public void Test() {
		log.info("Step 1.- Navigate to Microsoft");
		getDriver().get("https://www.microsoft.com/en-us/");
		
		log.info("Step 2.- Validate that exist options in the Page");
		TestData.getExpectedMenuItems().stream().forEach(item -> {
			boolean itemFound = PagesFactory.getMicrosoftPage(getDriver()).getMenuLists().stream().anyMatch(element -> element.getText().equalsIgnoreCase(item));
			assertThat(itemFound).as("The %s option doesn't exist in the Microsoft Page menu.", item).isTrue();
		});
		log.info("Step Result.- Sussesful!, The all options exist.");
		
		log.info("Step 3.- navigate to Windows Page.");
		PagesFactory.getMicrosoftPage(getDriver()).clickWindowsOption();
		
		log.info("Step 4.- Open About Windows options list.");
		PagesFactory.getWindowsPage(getDriver()).clickOnAboutWindows();
		
		log.info("Step 5.- Print About Windows options list.");
		PagesFactory.getWindowsPage(getDriver()).getListAboutWindows().forEach(element -> System.out.println(element));
		assertThat(PagesFactory.getWindowsPage(getDriver()).getListAboutWindows()).size().isGreaterThan(0);
		log.info("Step Result.- All items in the list have been printed.");
		
		log.info("Step 6.- Click en el Search button.");
		PagesFactory.getWindowsPage(getDriver()).clickOnSearch();
		
		log.info("Step 7.- Search 'Visual Studio'.");
		PagesFactory.getWindowsPage(getDriver()).fieldSearch();
		
		log.info("Step 8.- Select a option.");
		PagesFactory.getWindowsPage(getDriver()).getListSearch("Visual Studio Enterprise Subscription");
		
		log.info("Step 9.- Navigate to VS Enterprise Page.");
		PagesFactory.getVSEnterpricePage(getDriver()).waitModalLanguage();
		
		log.info("Step 10.- Close Modal.");
		PagesFactory.getVSEnterpricePage(getDriver()).clickOnButtonCloseModalLanguage();
		
		log.info("Step 11.- Print the current price.");
		double newLicense = PagesFactory.getVSEnterpricePage(getDriver()).getLabelPrice();
		
		log.info("Step 12.- Change de license type.");
		PagesFactory.getVSEnterpricePage(getDriver()).radioButtonPrice();
		
		log.info("Step 13.- Print the current price.");
		double renewal = PagesFactory.getVSEnterpricePage(getDriver()).getLabelPrice();
		
		log.info("Step Result.- Validate that license prices are different.");
		assertThat(newLicense).isNotEqualTo(renewal);
		
		log.info("Step 14.- Navigate to Cart Page.");
		PagesFactory.getVSEnterpricePage(getDriver()).buttonCar();
		PagesFactory.getCartPage(getDriver()).waitTitlePage();
		
		log.info("Step 15.- Get Prices to validate.");
		double principalPrice = PagesFactory.getCartPage(getDriver()).getlabelPrincipalPrice();
		double subTotalPrice = PagesFactory.getCartPage(getDriver()).getlabelSubTotal();
		double TotalPrice = PagesFactory.getCartPage(getDriver()).getlabelTotalPrice();
		
		assertThat(principalPrice).isEqualTo(subTotalPrice).isEqualTo(TotalPrice);
		log.info("Step Result.- The label prices are same.");
		
		log.info("Step 16.- Change the Dropdown to 20.");
		PagesFactory.getCartPage(getDriver()).clickOnDropdown("20");
		
		log.info("Step 17.- Get the new Price.");
		double newTotalPrice = PagesFactory.getCartPage(getDriver()).getlabelTotalPrice();
		
		log.info("Step 18.- Validate the new Price.");
		assertThat(newTotalPrice).isEqualTo(TotalPrice*20);
		log.info("Step Result.- The new prices is correct.");
		
		log.info("Step 6.- End Test!.");
	}
}

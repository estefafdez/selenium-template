package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import configuration.BasePageObjectConfig;
import constant.HomeConst;

public class HomePage extends BasePageObjectConfig{
	
	/**
	 * Class constructor.
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
	
	/***
	 * Method to close the popup on the main page
	 */
	public void closePopup() {
		
		if(waitForElementIsVisible(HomeConst.popupCloseButton)) { // Si aparece el pop up lo cerramos
			executeJsScript("window.document.getElementById('at-cv-lightbox-close').click();");
		}
		else {
			LOGGER.info("[INFO] - The PopUp doesn't appear");
		}
	}
	
	
	/**
	 * Navigate to the Selenium web
	 */
	public void navigateToSeleniumWeb() {
		navigateTo("https://www.seleniumeasy.com/test/");
	}
	
	/**
	 * Method to click on the input forms option 
	 */
	public void clickOnInputFormsOption () {
		clickOnElement(HomeConst.inputFormsOption);
	}

}

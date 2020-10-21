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
	 * Method to close the popup
	 */
//	public static void closePopup() {
//		// Controlar si aparece el popup
//		WebDriverWait wait = new WebDriverWait(driver, 40); 
//		
//		if(wait.until(ExpectedConditions.presenceOfElementLocated(ById.id("at-cv-lightbox-header"))) != null) { // Si aparece el pop up lo cerramos
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			LOGGER.info("[INFO] - Closing the PopUp.");
//			js.executeScript("window.document.getElementById('at-cv-lightbox-close').click();");
//		}
//		else {
//			LOGGER.info("[INFO] - The PopUp doesn't appear");
//		}
//	}
	
	
	/**
	 * Navigate to the web
	 */
	public void navigate() {
		navigateTo("https://www.seleniumeasy.com/test/");
	}
	
	/**
	 * Method to click on the input forms option 
	 */
	public void clickOnInputFormsOption () {
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		clickOnElement(HomeConst.inputFormsOption);
	}

}

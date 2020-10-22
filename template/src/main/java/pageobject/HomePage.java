package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import configuration.BasePageObjectConfig;
import constant.HomeConst;

public class HomePage extends BasePageObjectConfig{
	
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

	/**
	 * Class constructor.
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		super(driver);
	}

	/*--------------------------------------------------------------------*
	|      POPUP METHODS                                            
	*---------------------------------------------------------------------*/
	
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
	
	/*--------------------------------------------------------------------*
	|      NAVIGATION METHODS                                      
	*---------------------------------------------------------------------*/
	
	/**
	 * Navigate to the Selenium web
	 */
	public void navigateToSeleniumWeb() {
		navigateTo("https://www.seleniumeasy.com/test/");
	}
	
	/*--------------------------------------------------------------------*
	|      CHECK METHODS                                    
	*---------------------------------------------------------------------*/
	
	/*-----------------------------HEADER---------------------------------*/
	
	/**
	 * Check that the Selenium Easy Logo is visible. 
	 */
	public boolean checkSeleniumEasyLogoIsVisible() {
		return isElementVisible(HomeConst.seleniumEasyLogo);
	}
	
	/**
	 * Check that the CrossBrowserTesting Logo is visible. 
	 */
	public boolean checkCrossBrowserTestingLogoIsVisible() {
		return isElementVisible(HomeConst.crossBrowserTestingLogo);
	}
	
	/*---------------------------MENU LIST--------------------------------*/
	
	/**
	 * Check that the All examples menu option is visible. 
	 */
	public boolean checkAllExamplesMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuAllExamplesOption);
	}
	
	/**
	 * Check that the Input Form menu option is visible. 
	 */
	public boolean checkInputFormMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuInputFormsOption);
	}
	
	/**
	 * Check that the Date Pickers menu option is visible. 
	 */
	public boolean checkDatePickersMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuDatePickersOption);
	}
	
	/**
	 * Check that the Table menu option is visible. 
	 */
	public boolean checkTableMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuTableOption);
	}
	
	/**
	 * Check that the Progress Bars & Sliders menu option is visible. 
	 */
	public boolean checkProgressBarsSlidersMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuProgressBarsSlidersOption);
	}
	
	/**
	 * Check that the Alerts & Modals menu option is visible. 
	 */
	public boolean checkAlertsModalsmMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuAlertsAndModalsOption);
	}
	
	/**
	 * Check that the List Box menu option is visible. 
	 */
	public boolean checkListBoxMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuListBoxOption);
	}
	
	/**
	 * Check that the Others menu option is visible. 
	 */
	public boolean checkOthersMenuOptionIsVisible() {
		return isElementVisible(HomeConst.menuInputFormsOption);
	}
	
	/*--------------------------------------------------------------------*
	|      ACTIONS METHODS                                         
	*---------------------------------------------------------------------*/
	
	/**
	 * Method to click on the input forms option 
	 */
	public void clickOnInputFormsOption () {
		clickOnElement(HomeConst.menuInputFormsOption);
	}
	
	/**
	 * Method to click on the Simple Form Demo forms option 
	 */
	public void clickOnSimpleFormsOption () {
		clickOnElement(HomeConst.navBarSimpleFormDemoLink);
	}
	
	// TODO: Complete the rest of click actions on the different menu options

}

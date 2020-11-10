package pageobject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import configuration.BasePageObjectConfig;
import constant.GoogleExampleConst;

public class GoogleExamplePage extends BasePageObjectConfig{

	/**
	 * Class constructor.
	 * @param driver
	 */
	public GoogleExamplePage(WebDriver driver) {
		super(driver);
	}

	
	/*--------------------------------------------------------------------*
	|      NAVIGATION METHODS                                      
	*---------------------------------------------------------------------*/
	
	/**
	 * Navigate to Google
	 */
	public void navigateToGoogle() {
		navigateTo("https://www.google.es");
	}
	
	/*--------------------------------------------------------------------*
	|      ACTIONS METHODS                                      
	*---------------------------------------------------------------------*/
	
	/**
	 * Method to write something on the google search box. 
	 * @param text
	 */
	public void writeOnGoogle(String text) {
		sendTextToElement(GoogleExampleConst.searchField, text);
	}
	
	/**
	 * Method to switch to the google popup iframe
	 */
	public void switchToGooglePopupIframe() {
		switchToIframe(0);
	}

	/**
	 * Method to click on the accept popup from google. 
	 */
	public void clickOnAcceptGooglePopupIframe() {
		executeJsScript("window.document.getElementById('introAgreeButton').click();");
	}
	
	/**
	 * Method to send a key to an element, in this case the ENTER key.
	 */
	public void clickOnEnter() {
		sendKeyToElement(GoogleExampleConst.searchField, Keys.ENTER);
	}
	
	/**
	 * Method to click on the second result from the google search. 
	 */
	public void clickOnSecondResult() {
		clickOnElement(GoogleExampleConst.secondElementGoogleSearch);
	}
	
	/**
	 * Method to get the page URL
	 * @return the page URL
	 */
	public String getPageURL() {
		return getCurrentPageURL();
	}
	
	/**
	 * Method to get the page title
	 * @return the page title
	 */
	public String getPageTitle() {
		return getCurrentPageTitle();
	}
	
	/*--------------------------------------------------------------------*
	|      CHECKING METHODS                                      
	*---------------------------------------------------------------------*/
	
	/**
	 * Method to check that the second result in the google search is visible. 
	 * @return
	 */
	public boolean checkSecondResultIsVisible() {
		return isElementVisible(GoogleExampleConst.secondElementGoogleSearch);
	}
}

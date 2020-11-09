package pageobject;

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
	
	public void writeOnGoogle(String text) {
		sendTextToElement(GoogleExampleConst.searchField, text);
	}
	
	public void switchToGooglePopupIframe() {
		switchToIframe(0);
	}

	public void clickOnAcceptGooglePopupIframe() {
		executeJsScript("window.document.getElementById('introAgreeButton').click();");
	}

}

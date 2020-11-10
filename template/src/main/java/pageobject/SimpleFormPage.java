package pageobject;

import org.openqa.selenium.WebDriver;

import configuration.BasePageObjectConfig;
import constant.SimpleFormConst;

public class SimpleFormPage extends BasePageObjectConfig{

	/**
	 * Class constructor.
	 * @param driver
	 */
	public SimpleFormPage(WebDriver driver) {
		super(driver);
	}
	
	/*--------------------------------------------------------------------*
	|      CHECK METHODS                                    
	*---------------------------------------------------------------------*/
	
	/**
	 * Check that the title of the page section is visible. 
	 */
	public boolean checkSimpleFormDemoTitleSectionIsVisible() {
		return isElementVisible(SimpleFormConst.simpleFormPageTitle);
	}
	
	/**
	 * Check that the subtitle of the page section is visible. 
	 */
	public boolean checkSimpleFormDemoSubtitleSectionIsVisible() {
		return isElementVisible(SimpleFormConst.simpleFormPageSubtitle);
	}
	
	public String getYourMessageResponse() {
		return getTextFromElement(SimpleFormConst.yourMessage);
	}

	/*--------------------------------------------------------------------*
	|      ACTIONS METHODS                                         
	*---------------------------------------------------------------------*/
	
	/**
	 * Send text to the enter your message input field. 
	 * @param text to send
	 */
	public void sendTextToTheEnterYourMessageInput(String text) {
		clickOnElement(SimpleFormConst.userMessageInput);
		clearTextFromElement(SimpleFormConst.userMessageInput);
		sendTextToElement(SimpleFormConst.userMessageInput, text);
	}
	
	/**
	 * Method to click on the Show Message button.
	 */
	public void clickOnTheShowMessageButton() {
		clickOnElement(SimpleFormConst.showMessageButton);
	}
	
}

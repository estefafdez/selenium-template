package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.TestSetConfig;
import pageobject.HomePage;
import pageobject.SimpleFormPage;

/**
 * On this page we are going to create the tests that correspond to the actions 
 * that we could do on the Simple Form Page
 * 
 * @author estefafdez and @isabelaliaga
 *
 */
public class SimpleFormDemoTest extends TestSetConfig{

	/**
	 * Test to click on enter a message on a simple input field 
	 * and check that the message is correct. 
	 */
	@Test
	public void testSingleInputField(){
		// Create a new instance of the HomePage with the Driver
		HomePage home = new HomePage(getDriver());
		
		// Use that instance to call the methods defined on the Home Page class. 
		home.navigateToSeleniumWeb();
		
		home.closePopup();
		
		home.clickOnInputFormsOption();
		
		home.clickOnSimpleFormsOption();
		
		// When we click on the Simple form option from the menu, we change to a new page and we need to create a new instance. 
		SimpleFormPage simpleForm = new SimpleFormPage(getDriver());
		
		// To check that we are on the correct page, we check that the title and the subtitle of the new page is displayed properly
		Assert.assertTrue(simpleForm.checkSimpleFormDemoTitleSectionIsVisible(), "The title of the Simple Form page is not displayed");
		Assert.assertTrue(simpleForm.checkSimpleFormDemoSubtitleSectionIsVisible(), "The subtitle of the Simple Form page is not displayed");
		
		simpleForm.sendTextToTheEnterYourMessageInput("First Message");
		
		simpleForm.clickOnTheShowMessageButton();
		
		String message = simpleForm.getYourMessageResponse();
		
		Assert.assertTrue(message.equals("First Message"), "The message is not displayed properly");
	}
	
	
	/*
	 * TODO:
	 * 
	 * Do the rest of the tests on this page.
	 */

}

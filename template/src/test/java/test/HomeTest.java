package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.TestSetConfig;
import pageobject.HomePage;
import pageobject.SimpleFormPage;

/**
 * On this page we are going to create the tests that correspond to the actions 
 * that we could do on the homepage: click on the different options on the menu and on the header. 
 * 
 * @author estefafdez and @isabelaliaga
 *
 */
public class HomeTest extends TestSetConfig{
	
	/**
	 * Test to check if the header is displayed properly. 
	 */
	@Test
	public void testCheckHeader() {
		// Create a new instance of the HomePage with the Driver
		HomePage home = new HomePage(getDriver());
				
		// Use that instance to call the methods defined on the Home Page class. 
		home.navigateToSeleniumWeb();
		
		Assert.assertTrue(home.checkSeleniumEasyLogoIsVisible(), "The Selenium Easy Logo is not displayed");
		Assert.assertTrue(home.checkCrossBrowserTestingLogoIsVisible(), "The CrossBrowserTesting Logo is not displayed");
	}
	
	/**
	 * Test to check if the menu is displayed properly. 
	 */
	@Test
	public void testCheckMenu() {
		// Create a new instance of the HomePage with the Driver
		HomePage home = new HomePage(getDriver());
				
		// Use that instance to call the methods defined on the Home Page class. 
		home.navigateToSeleniumWeb();
		
		Assert.assertTrue(home.checkAllExamplesMenuOptionIsVisible(), "The option All examples is not displayed");
		Assert.assertTrue(home.checkInputFormMenuOptionIsVisible(), "The option Input Form is not displayed");
		Assert.assertTrue(home.checkDatePickersMenuOptionIsVisible(), "The option Date Pickers is not displayed");
		Assert.assertTrue(home.checkTableMenuOptionIsVisible(), "The option Table is not displayed");
		Assert.assertTrue(home.checkProgressBarsSlidersMenuOptionIsVisible(), "The option Progress Bars & Sliders is not displayed");
		Assert.assertTrue(home.checkAlertsModalsmMenuOptionIsVisible(), "The option Alerts & Modals is not displayed");
		Assert.assertTrue(home.checkListBoxMenuOptionIsVisible(), "The option List Box is not displayed");
		Assert.assertTrue(home.checkOthersMenuOptionIsVisible(), "The option Others is not displayed");
	}
	
	/**
	 * Test to click on the Simple Form Demo and check that 
	 * you are redirected to the correct page. 
	 */
	@Test
	public void testGoToSimpleFormDemoPage(){
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
	}
	
	/*
	 * TODO:
	 * 
	 * Do the rest of the tests from the menu:
	 * 
	 * - Click on the Checkbox demo option and see that you are redirected to the correct page
	 * - Radio buttons...
	 */

}

package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.TestSetConfig;
import pageobject.GoogleExamplePage;

/**
 * 
 * This is a very basic example of searching in Google. This page won't use the POM to navigate between different pages. 
 * Every method and action will be defined on the GoogleExamplePage class. 
 * 
 * @author estefafdez and @isabelaliaga
 *
 */
public class GoogleExampleTest extends TestSetConfig{
	
	/**
	 * Test to search for a word on Google. 
	 */
	@Test
	public void testNavigateToGoogle() {
		
		
		// Create a new instance of the HomePage with the Driver
		GoogleExamplePage googlePage = new GoogleExamplePage(getDriver());
						
		// Use that instance to call the methods defined on the Home Page class. 
		googlePage.navigateToGoogle();
		
		googlePage.writeOnGoogle("hola");
	}
	
	/**
	 * Search in Google "Selenium Webdriver", click on the correct URL and check that you're on the correct page. 
	 */
	@Test
	public void testNavigateAndSearchOnGoogle() {
		// Create a new instance of the HomePage with the Driver
		GoogleExamplePage googlePage = new GoogleExamplePage(getDriver());
						
		// Use that instance to call the methods defined on the Home Page class. 
		googlePage.navigateToGoogle();
		
		googlePage.switchToGooglePopupIframe();

		googlePage.clickOnAcceptGooglePopupIframe();
	
		googlePage.writeOnGoogle("Selenium Webdriver");
		
		googlePage.clickOnEnter();
		
		Assert.assertTrue(googlePage.checkSecondResultIsVisible(), "The second result is not visible");
		
		googlePage.clickOnSecondResult();
		
		Assert.assertTrue(googlePage.getPageURL().equals("https://www.selenium.dev/documentation/en/webdriver/"), "The URL is not correct");		
		
		Assert.assertTrue(googlePage.getPageTitle().equals("WebDriver :: Documentation for Selenium"), "The title is not correct");		
	}
}

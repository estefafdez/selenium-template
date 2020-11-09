package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import configuration.TestSetConfig;
import pageobject.GoogleExamplePage;

/**
 * On this page we are going to create the tests that correspond to the actions 
 * that we could do on the homepage: click on the different options on the menu and on the header. 
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
		

//		inputGoogle.sendKeys(Keys.ENTER);
//		
//		WebElement secondResult = driver.findElement(By.xpath("//span[contains(text(),'WebDriver :: Documentation for Selenium')]"));
//		
//		secondResult.click();
//				
//		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/documentation/en/webdriver/"), "La URL no es correcta");		
//		Assert.assertTrue(driver.getTitle().equals("WebDriver :: Documentation for Selenium"), "El título no es correcto");		
	}
}

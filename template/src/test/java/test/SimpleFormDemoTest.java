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
	 * Migrate:
	 */
	
	/**
	 * Introducir dos valores en el formulario y comprobar al pulsar el botón que el resultado de la operación es el correcto
	 */
//	@Test
//	public void testTwoFilledInputFields(){
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		
//		WebElement simpleFormDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]"));
//		simpleFormDemoOption.click();
//		
//		WebElement inputA = driver.findElement(ById.id("sum1"));
//		inputA.click();
//		inputA.clear();
//		inputA.sendKeys("5");
//		
//		WebElement inputB = driver.findElement(ById.id("sum2"));
//		inputB.click();
//		inputB.clear();
//		inputB.sendKeys("3");
//		
//		WebElement getTotalButton = driver.findElement(By.xpath("//button[contains(text(),'Get Total')]"));
//		getTotalButton.click();
//		
//		WebElement totalResult = driver.findElement(By.xpath("//span[@id='displayvalue']"));
//			
//		Assert.assertTrue(totalResult.getText().equals("8"), "El resultado no es correcto");
//	}
//	
//	/**
//	 * Dejar vacíos los campos del formulario y comprobar al pulsar el botón que el resultado se muestra en blanco
//	 */
//	@Test
//	public void testTwoEmptyInputFieldsEmpty(){
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		
//		WebElement simpleFormDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]"));
//		simpleFormDemoOption.click();
//		
//		WebElement inputA = driver.findElement(ById.id("sum1"));
//		inputA.click();
//		inputA.clear();
//		
//		WebElement inputB = driver.findElement(ById.id("sum2"));
//		inputB.click();
//		inputB.clear();
//		
//		WebElement getTotalButton = driver.findElement(By.xpath("//button[contains(text(),'Get Total')]"));
//		getTotalButton.click();
//		
//		WebElement totalResult = driver.findElement(By.xpath("//span[@id='displayvalue']"));
//			
//		Assert.assertTrue(totalResult.getText().equals("NaN"), "El resultado no es correcto");
//	}

}

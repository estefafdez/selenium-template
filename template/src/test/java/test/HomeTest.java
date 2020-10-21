package test;

import org.testng.annotations.Test;

import configuration.TestSetConfig;
import pageobject.HomePage;

public class HomeTest extends TestSetConfig{
	
	/**
	 * Introducir un mensaje en un formulario y comprobar que se muestra correctamente al pulsar el botón
	 */
	@Test
	public void testSingleInputField(){
		
		
		// Create a new instance of the HomePage with the Driver
		HomePage home = new HomePage(getDriver());
		
		// Use that instance to call the methods defined on the Home Page class. 
		home.navigateToSeleniumWeb();
		
		home.closePopup();
		
		home.clickOnInputFormsOption();
	}

}

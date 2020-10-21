package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import configuration.TestSetConfig;
import pageobject.HomePage;

public class HomeTest extends TestSetConfig{
	
	private static final Logger LOGGER = LogManager.getLogger(HomeTest.class);
	
	/**
	 * Introducir un mensaje en un formulario y comprobar que se muestra correctamente al pulsar el botón
	 */
	@Test
	public void testSingleInputField(){
		
		HomePage home = new HomePage(getDriver());
		
		// This method is defined on the TestSetup class.
		//HomePage.closePopup();
		
		home.navigate();
		
		home.clickOnInputFormsOption();
		

	}

}

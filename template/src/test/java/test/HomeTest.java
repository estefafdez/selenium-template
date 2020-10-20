package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageobject.HomePage;
import selenium.template.TestSetup;

public class HomeTest extends TestSetup{
	
	private static final Logger LOGGER = LogManager.getLogger(HomeTest.class);
	
	/**
	 * Introducir un mensaje en un formulario y comprobar que se muestra correctamente al pulsar el botón
	 * @throws InterruptedException 
	 */
	@Test
	public void testSingleInputField(){
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
		
		HomePage.clickOnInputFormsOption();
		

	}

}

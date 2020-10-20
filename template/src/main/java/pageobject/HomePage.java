package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import constant.HomeConst;
import selenium.template.TestSetup;

public class HomePage extends TestSetup{
	
	private static final Logger LOGGER = LogManager.getLogger(HomePage.class);
	
	/**
	 * Method to click on the input forms option 
	 */
	public static void clickOnInputFormsOption () {
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		LOGGER.info("[ELEMENTO] - " + HomeConst.inputFormsOption);
		HomeConst.inputFormsOption.click();
	}

}

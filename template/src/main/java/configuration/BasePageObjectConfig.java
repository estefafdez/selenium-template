package configuration;

import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObjectConfig {
	
	/** Logger class initialization. */
	private static final Logger LOGGER = LogManager.getLogger(BasePageObjectConfig.class);
	
	private WebDriver driver;

	/** Provides the ability to wait for an arbitrary condition during test execution. */
	protected WebDriverWait wait;
	
	/** Provides the event of the keys*/
	protected KeyEvent keyEvent;

	/** TIMEOUT for wait elements. (In seconds) */
	protected long waitElementTimeout = 20;
	
	/*--------------------------------------------------------------------* 
	|	CONSTRUCTOR
	*---------------------------------------------------------------------*/

	/**
	 * Construct to sets the Page's Driver. The Page structure is being used within
	 * this test in order to separate the page actions from the tests.
	 *
	 * @param driver the Selenium Driver created.
	 */
	protected BasePageObjectConfig(WebDriver driver) {
		this.driver = driver;
	}
    
    /*--------------------------------------------------------------------* 
	|	LOGIC TO CHECK ELEMENT STATE
	*---------------------------------------------------------------------*/
    
    /**
	 * Method to check if an element is visible
	 * 
	 * @param web element to check
	 * @return true|false if the element is visible
	 */
	protected boolean isElementVisible(WebElement element) {
		try {
			LOGGER.info("Checking if the element is visible: [" + element + "]");
			return element.isDisplayed();
		} catch (NoSuchElementException ex) {
			LOGGER.error("The element is not visible: [" + element + "]", ex);
			return false;
		}
	}
	
	/**
	 * Method to check if an element is selected
	 * 
	 * @param element to check
	 * @return true|false if the element is selected
	 */
	protected boolean isElementSelected(WebElement element) {
		try {
			LOGGER.info("Checking if the element is selected: [" + element + "]");
			return element.isSelected();
		} catch (NoSuchElementException ex) {
			LOGGER.error("The element is not selected: [" + element + "]", ex);
			return false;
		} 
	}
	
	/**
	 * Method to check if an element is enabled
	 * 
	 * @param element to check
	 * @return true|false if the element is enabled
	 */
	protected boolean isElementEnabled(WebElement element) {
		try {
			LOGGER.info("Checking if the element is enabled: [" + element + "]");
			return element.isEnabled();
		} catch (NoSuchElementException ex) {
			LOGGER.error("The element is not enabled: [" + element + "]", ex);
			return false;
		} 
	}
	
	/**
	 * Method to check if an element is not present
	 * 
	 * @param element to check
	 * @return true|false if the element is not present
	 */
	protected boolean isElementNotPresent(WebElement element) {
		try {
			LOGGER.info("Checking if the element is not present: [" + element + "]");
			element.isDisplayed();
			return false;
		} catch (NoSuchElementException ex) {
			LOGGER.error("The element is present: [" + element + "]", ex);
			return true;
		} 
	}
	
	/*--------------------------------------------------------------------* 
	|	LOGIC TO WAIT FOR ELEMENTS
	*---------------------------------------------------------------------*/
	
	
	/**
	 * Method to wait a number of seconds. 
	 * Important Note: PLEASE, do NOT use this method unless is a LIFE or DEATH situation.
	 * @param seconds: number of seconds to wait. 
	 */
	protected void sleep (int seconds) {
		LOGGER.info("Waiting " + seconds + " seconds. PLEASE avoid using this Method.");
		
		long numberOfMiliseconds=seconds * 1000L;
		
		try {
			Thread.sleep(numberOfMiliseconds);
		} catch (InterruptedException ex) {
			LOGGER.error("The sleep method failed.", ex);
			/** Restore interrupted state...*/
		    Thread.currentThread().interrupt();
		}
	}
	
	protected void navigateTo(String URL) {
		driver.navigate().to(URL);
	}
	
	protected void clickOnElement(By element) {
		try {
			LOGGER.info("Clicking on the element: [" + element + "]");
			driver.findElement(element).click();
		} catch (NoSuchElementException ex) {
			LOGGER.error("The element is not clickable: [" + element + "]", ex);
		} 
	}

}

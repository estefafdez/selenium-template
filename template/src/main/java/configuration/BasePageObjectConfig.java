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
	
	/** Driver instance. */
	protected final WebDriver driver;

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
	 * @param driver the Appium Driver created.
	 */
	protected BasePageObjectConfig(WebDriver driver) {
		this.driver = driver;
		//loadPageProperties();
	}
	
	/*--------------------------------------------------------------------* 
	|	LOGIC TO CONSTRUCT THE ELEMENTS SELECTORS
	*---------------------------------------------------------------------*/
	
	   /**
     * Get the complete element with a selected type and key.
     */
    public static By elementConstructor(String type, String selector) {
        By result;
        
        switch (type) {
            case "className":
                result = By.className(selector);
                break;
            case "cssSelector":
                result = By.cssSelector(selector);
                break;
            case "id":
                result = By.id(selector);
                break;
            case "linkText":
                result = By.linkText(selector);
                break;
            case "name":
                result = By.name(selector);
                break;
            case "partialLinkText":
                result = By.partialLinkText(selector);
                break;
            case "tagName":
                result = By.tagName(selector);
                break;
            case "xpath":
                result = By.xpath(selector);
                break;
            default:
                throw new IllegalArgumentException("By type " + type + " is not found.");
        }
        return result;
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
	
	
	

}

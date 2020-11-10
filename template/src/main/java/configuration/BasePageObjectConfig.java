package configuration;

import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePageObjectConfig {
	
	/** Logger class initialization. */
	private static final Logger LOGGER = LogManager.getLogger(BasePageObjectConfig.class);
	
	/** New WebDriver instance*/
	protected final WebDriver driver;

	/** Provides the ability to wait for an arbitrary condition during test execution. */
	protected WebDriverWait wait;
	
	/** Provides the event of the keys*/
	protected KeyEvent keyEvent;

	/** TIMEOUT for wait elements. (In seconds) */
	protected static long waitElementTimeout = 20;
	
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
	|	LOGIC TO NAVIGATE
	*---------------------------------------------------------------------*/

	/***
	 * Method to navigate to a certain URL
	 * 
	 * @param URL to navigate to
	 */
	protected void navigateTo(String URL) {
		LOGGER.info("Navigating to: [" + URL + "]");
		driver.navigate().to(URL);
	}
    
    /*--------------------------------------------------------------------* 
	|	LOGIC TO CHECK ELEMENT STATE
	*---------------------------------------------------------------------*/
    
    /**
	 * Method to check if an element is visible
	 * 
	 * @param element to check
	 * @return true|false if the element is visible
	 */
	protected boolean isElementVisible(By element) {
		try {
			LOGGER.info("Checking if the element is visible: [" + element + "]");
			return driver.findElement(element).isDisplayed();
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
	protected boolean isElementSelected(By element) {
		try {
			LOGGER.info("Checking if the element is selected: [" + element + "]");
			return driver.findElement(element).isSelected();
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
	protected boolean isElementEnabled(By element) {
		try {
			LOGGER.info("Checking if the element is enabled: [" + element + "]");
			return driver.findElement(element).isEnabled();
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
	protected boolean isElementNotPresent(By element) {
		try {
			LOGGER.info("Checking if the element is not present: [" + element + "]");
			driver.findElement(element).isDisplayed();
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
	 * 
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
	
	/**
	 * Method to wait until an element is present in the DOM
	 * 
	 * @param element to check
	 * @return true|false if the element is present before the timeout is finished
	 */
	protected boolean waitForElementIsPresent(By element) {
		try {
			LOGGER.info("Waiting for the element is present: [" + element + "]");
			wait = new WebDriverWait(driver, waitElementTimeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(element)) != null;
		} catch (TimeoutException ex) {
			LOGGER.error("The element is not present: [" + element + "]", ex);
			return false;
		} 
	}
	
	/**
	 * Method to wait until an element is visible
	 * 
	 * @param element to check
	 * @return true|false if the element is visible before the timeout is finished
	 */
	protected boolean waitForElementIsVisible(By element) {
		try {
			LOGGER.info("Waiting for the element to be visible: [" + element + "]");
			wait = new WebDriverWait(driver, waitElementTimeout);
			return wait.until(ExpectedConditions.visibilityOfElementLocated(element)) != null;
		} catch (TimeoutException ex) {
			LOGGER.error("The element is not visible: [" + element + "]", ex);
			return false;
		}
	}
	
	/**
	 * Method to wait until an element is not visible
	 * 
	 * @param element to check
	 * @return true|false if the element is visible before the timeout is finished
	 */
	protected boolean waitForElementIsNotVisible(By element) {
		try {
			LOGGER.info("Waiting for the element not to be visible: [" + element + "]");
			wait = new WebDriverWait(driver, waitElementTimeout);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(element)) != null;
		} catch (TimeoutException ex) {
			LOGGER.error("The element is visible: [" + element + "]", ex);
			return false;
		}
	}
	
	/**
	 * Method to wait until the element is selected
	 * 
	 * @param element to check
	 * @return true|false if the element is selected before the timeout is finished
	 */
	protected boolean waitForElementIsSelected(By element) {
		try {
			LOGGER.info("Waiting for the element to be selected: [" + element + "]");
			wait = new WebDriverWait(driver, waitElementTimeout);
			return wait.until(ExpectedConditions.elementToBeSelected(element)) != null;
		} catch (TimeoutException ex) {
			LOGGER.error("The element is not selected: [" + element + "]", ex);
			return false;
		}
	}
	
	/**
	 * Method to wait until the element is enabled and clickable
	 * 
	 * @param element to check
	 * @return true|false if the element is enabled and clickable before the timeout is finished. 
	 */
	protected boolean waitForElementIsEnabledAndClickable(By element) {
		try {
			LOGGER.info("Waiting for the element to be enabled and clickable: [" + element + "]");
			wait = new WebDriverWait(driver, waitElementTimeout);
			return wait.until(ExpectedConditions.elementToBeClickable(element)) != null;
		} catch (TimeoutException ex) {
			LOGGER.error("The element is not enabled and clickable: [" + element + "]", ex);
			return false;
		} 
	}
	
	/*--------------------------------------------------------------------* 
	|	LOGIC TO DO ACTIONS ON THE SCREEN
	*---------------------------------------------------------------------*/
	
    /**
     * This function emulates a scroll to see an element, using JavaScript.
     * @param element to search.
     */
    public void scrollToElement(By element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
        } catch (Exception ex) {
        	LOGGER.error("Cannot Scroll to the element: [" + element + "] by JavaScript: " , ex);
        }
    }
    
    /**
     * This function emulates a scroll Top action, using JavaScript.
     */
    public void scrollToTheTop() {
        try {
        	executeJsScript("window.scrollTo(0, 0)");
        } catch (Exception ex) {
        	LOGGER.error("Cannot ScrollTop the page, by JavaScript: " + ex);
        }
    }

    /**
     * This function emulates a Scroll Bottom action, using JavaScript.
     */
    public void scrollToTheBottom() {
        try {
        	executeJsScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception ex) {
        	LOGGER.error("Cannot ScrollBottom the page, by JavaScript: " +ex);
        }
    }
    
	/*--------------------------------------------------------------------* 
	|	LOGIC TO DO ACTIONS ON AN ELEMENT
	*---------------------------------------------------------------------*/
    
    /** 
     * Method to execute a JavaScript script. 
     * 
     * @param script to run
     */
    protected void executeJsScript(String script) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		LOGGER.info("[INFO] -Executing the following JavaScript Script: " + script);
		js.executeScript(script);	
    }
    

	/**
	 * Method to click on an element
	 * 
	 * @param element to click
	 */
	protected void clickOnElement(By element) {

		try {
			LOGGER.info("Clicking on element: [" + element + "]");
			this.driver.findElement(element).click();
		} catch (NoSuchElementException ex) {
			LOGGER.error("Trying to click on the element [" + element + "] but it was not found.", ex);
		}
	}
	
	/**
	 * Method double click on an element
	 * 
	 * @param element to click
	 */
	protected void doubleClickOnElement(By element) {
		try {
			LOGGER.info("Performing double click on the element: [" + element + "]");
			Actions actions = new Actions(driver);
			actions.doubleClick(driver.findElement(element)).perform();	
		} catch (NoSuchElementException ex) {
			LOGGER.error("Cannot double click on to the element: [" + element + "]" , ex);
		}
	}
	
	/**
	 * Method right click on an element
	 * 
	 * @param element to click
	 */
	protected void rightClickOnElement(By element, int time) {
		try {
			LOGGER.info("Performing right click on the element: [" + element + "]");
			Actions actions = new Actions(driver);
			actions.contextClick(driver.findElement(element)).perform();
		} catch (NoSuchElementException ex) {
			LOGGER.error("Cannot Right Click on to the element: [" + element + "]" , ex);
		}
	}
	
	/**
	 * Method to send a key into an element (ENTER, BACK...)
	 * 
	 * @param element to find
	 * @param key to send
	 */
	protected void sendKeyToElement(By element, Keys key) {
		try {
			LOGGER.info("Sending a key action to the element: [" + element + "]");
			this.driver.findElement(element).sendKeys(key);
		} catch (NoSuchElementException ex) {
			LOGGER.error("Is not possible to send the key into the element because this is was not found: ["+ element + "]", ex);
		}
	}
	
	/**
	 * Method to send a text into an element
	 * 
	 * @param element to find
	 * @param text to send
	 */
	protected void sendTextToElement(By element, String text) {
		try {
			LOGGER.info("Sending the text: [" + text + "] to the element: [" + element + "]");
			this.driver.findElement(element).sendKeys(text);
		} catch (NoSuchElementException ex) {
			LOGGER.error("Is not possible to send the text into the element because this is was not found: ["+ element + "]", ex);
		}
	}
	
	/**
	 * Method to send letter by letter a text into an element.
	 * Important Note: send special characters (in Unicode) is not available with this method. 
	 * Use sendTextToElement instead
	 * 
	 * @param element to find
	 * @param text to send
	 */
	protected void sendTextCharByCharToElement(By element, String text) {
		try {
			LOGGER.info("Sending the text: [" + text + "] char by char to the element: [" + element + "]");
			if (text != null) {
				for (char c : text.toCharArray()) {
					this.driver.findElement(element).sendKeys(Character.toString(c));
					LOGGER.debug(Character.toString(c));
				}
			}
		} catch (NoSuchElementException ex) {
			LOGGER.error("Is not possible to send the text letter by letter to the element because this was not found: ["+ element + "]", ex);
		}
	}
	
	/**
	 * Method to clear an element
	 * 
	 * @param element to find
	 */
	protected void clearTextFromElement(By element) {
		try {
			LOGGER.info("Clearing text from element: [" + element + "]");
			this.driver.findElement(element).clear();
		} catch (NoSuchElementException ex) {
			LOGGER.error("Is not possible to clear the text from the element because this was not found: [" + element + "]", ex);
		}
	}
	
	/*--------------------------------------------------------------------* 
	|	LOGIC TO GET ATTRIBUTES FOR ELEMENTS
	*---------------------------------------------------------------------*/
	
	/**
	 * Method get the text from an element
	 * 
	 * @param element to find
	 * @return text
	 */
	protected String getTextFromElement(By element) {
		String value = null;
		try {
			LOGGER.info("Getting text from element: [" + element + "]");
			value = this.driver.findElement(element).getText();
		} catch (NoSuchElementException ex) {
			LOGGER.error("Is not possible to get the text from the element because this was not found: [" + element + "]", ex);
		}
		return value;
	}
	
	/**
	 * Method to get the value of the attribute from an element using its selector.
	 * 
	 * <pre>
	 * <b>Attributes for Web</b>
	 * - id
	 * - text
	 * - name
	 * - title
	 * - action
	 * - placeholder
	 * </pre>
	 * 
	 * @param element to get attribute
	 * @param attribute name of the attribute to find
	 * @return the value of the attribute
	 */
	protected String getValueOfElementAttribute(By element, String attribute) {
		String value = null;
		try {
			LOGGER.debug("Getting attribute [" + attribute + "] from element: [" + element + "]");
			value = this.driver.findElement(element).getAttribute(attribute);
		} catch (NoSuchElementException ex) {
			LOGGER.error("Trying to get the attribute [" + attribute + "] but the element does not contain this or the selector is missing.", ex);
		}
		
		return value;
	}
	
	/**
	 * Get the source of the last loaded page. If the page has been modified after
	 * loading (for example, by Javascript) there is no guarantee that the returned
	 * text is that of the modified page. The page source returned is a
	 * representation of the underlying DOM.
	 * 
	 * @return The source of the current page.
	 */
	protected String getPageDOM() {
		LOGGER.info("Getting DOM from: " + this.getClass().getSimpleName());
		return this.driver.getPageSource();
	}
	
	/**
	 * Method to get the current URL from a page. 
	 * @return the page URL
	 */
	protected String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	/**
	 * Method to get the title from a page. 
	 * @return the page title
	 */
	protected String getCurrentPageTitle() {
		return driver.getTitle();				
	}
	
	/*--------------------------------------------------------------------* 
	|	LOGIC TO INTERACT WITH IFRAMES
	*---------------------------------------------------------------------*/
	
    /**
	 * Method switch to an iFrame
	 * 
	 * @param iframe number to switch to.
	 */
	protected void switchToIframe(int iframeNumber) {

		try {
			LOGGER.info("Switching to the iFrame: [" + iframeNumber + "]");
			driver.switchTo().frame(iframeNumber);
		} catch (Exception ex) {
			LOGGER.error("Trying to switch to iFrame [" + iframeNumber + "] but it was not possible.", ex);
		}
	}
}

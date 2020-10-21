package selenium.template;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestSetup {
	/** Logger class initialization. */
	Level logLevelDefault = Level.DEBUG;

	private static final Logger LOGGER = LogManager.getLogger(TestSetup.class);
	
	/**
	 * New WebDriver instance
	 */
	public static WebDriver driver;
	String resourceFolder = "src/main/resources/drivers/";
	String os = "LINUX";
	String browser = "CHROME";
	String log = "INFO";
	
	/**
	 * This method runs before any other method.
	 */
	@BeforeSuite
	protected void setup() {
		setUpDriver(browser, os);
		Configurator.setRootLevel(logLevelDefault);
	}
	
	/**
	 * 
	 * @param browser
	 * @param os
	 * @return
	 */
	protected WebDriver setUpDriver(String browser, String os) {
		LOGGER.info("[ Setup Configuration ] - Initializing Setup Configuration");

				
			 /******** The driver selected is Local: Firefox  ********/    	
			 if ("FIREFOX".equalsIgnoreCase(browser)) {
				 if("WINDOWS".equalsIgnoreCase(os)){
					 System.setProperty("webdriver.gecko.driver", resourceFolder+os+"/geckodriver.exe");    
				 }
				 else{
					 System.setProperty("webdriver.gecko.driver", resourceFolder+os+"/geckodriver");    
				 }
			     driver = new FirefoxDriver();	
			 }
						        
			 /******** The driver selected is Chrome  ********/
						   
		     else if ("CHROME".equalsIgnoreCase(browser)) {
		    	 if("WINDOWS".equalsIgnoreCase(os)){
		    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver.exe");            
		    	 }
		    	 else if("LINUX".equalsIgnoreCase(os)){
		    		 // This is only to run on the Raspberry pi
		    		 //https://www.reddit.com/r/selenium/comments/7341wt/success_how_to_run_selenium_chrome_webdriver_on/
					// System.setProperty("webdriver.gecko.driver", "/usr/lib/chromium-browser/chromedriver");   
		    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver"); 
				 }
		    	 else{
		    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver");        		 
		    	 }
		    	
		    	 driver = new ChromeDriver();
			
		     }  

			 /******** The driver is not selected  ********/
		     else {
		    	 LOGGER.error("The Driver is not selected properly, invalid name: " + browser + ", " + os);
				 return null;
			 }
			 
        /******** Clean Cookies, maxinize and declare Timeout on the Driver *******/
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
				    	    
		return driver;
	}

	@BeforeMethod
	protected void beforeMethod(Method method) {
		LOGGER.info("[ Test Status ] - Running Test: " + method.getName());
	}


	@AfterMethod
	protected void afterMethod(ITestResult result) throws IOException {
		String testName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			LOGGER.info("[ Test Status ] - The execution of the Test " + testName + " was FAILURE");
			this.takeScreenShots(result);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			LOGGER.info("[ Test Status ] - The execution of the Test " + testName + " was SUCCESS");
		}
	}

	@AfterSuite
	protected void tearDown() {
		LOGGER.info("[ Driver Configuration ] - Quit this Driver, closing every instance associated");
		driver.close(); //Cierra la ventana que actualmente se está ejecutando
		driver.quit(); //Cierra las ventanas que el driver ha abierto
	}
	
	private void takeScreenShots(ITestResult result) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
    	String screenShotName = "resources/screenshot/" + dateFormat.format(GregorianCalendar.getInstance().getTime());		
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	LOGGER.info("Screenshot saved as:" + screenShotName);
    	FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenShotName)));   
	}
	
	public void closePopup() {
		// Controlar si aparece el popup
		WebDriverWait wait = new WebDriverWait(driver, 40); 
		
		if(wait.until(ExpectedConditions.presenceOfElementLocated(ById.id("at-cv-lightbox-header"))) != null) { // Si aparece el pop up lo cerramos
			JavascriptExecutor js = (JavascriptExecutor) driver;
			LOGGER.info("[INFO] - Closing the PopUp.");
			js.executeScript("window.document.getElementById('at-cv-lightbox-close').click();");
		}
		else {
			LOGGER.info("[INFO] - The PopUp doesn't appear");
		}
	}

}

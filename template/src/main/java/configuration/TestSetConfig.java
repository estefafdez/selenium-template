package configuration;

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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class TestSetConfig {
	
	/** Logger class initialization. */
	private static final Logger LOGGER = LogManager.getLogger(TestSetConfig.class);
	
	/** Driver instance. */
	private WebDriver driver;
	
	String os = "mac";
	String browser = "CHROME";
	
	/** Logger class initialization. */
	Level logLevelDefault = Level.DEBUG;
	
	/*--------------------------------------------------------------------* 
	|		LIFE CYCLE												
	*---------------------------------------------------------------------*/

	/**
	 * This method runs before any other method.
	 */
	@BeforeSuite
	protected void setUpConfiguration() {
		LOGGER.info(ConstantConfig.LOG_SEPARATOR);
		LOGGER.info("[ Setup Configuration ] - Initializing Setup Configuration");
		try {
			Configurator.setRootLevel(logLevelDefault);
			setUpDriver();
			cleanCookiesMaxBrowser();
		} catch (Exception ex) {
			LOGGER.error("[ Setup Configuration ] - Error on Setup Configuration", ex);
		}
	}

	@BeforeMethod
	protected void beforeAllConfiguration(Method method) {
		LOGGER.info(ConstantConfig.LOG_SEPARATOR);
		LOGGER.info("[ Test Status ] - Running Test: " + method.getName());
		LOGGER.info(ConstantConfig.LOG_SEPARATOR);
	}

	/**
	 * Method to add/remove from the Failed Suite using the Test Status
	 * 
	 * @param result the test result
	 */
	@AfterMethod
	protected void afterMethod(ITestResult result) throws IOException {
		LOGGER.info(ConstantConfig.LOG_SEPARATOR);
		String testName = result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE) {
			LOGGER.info("[ Test Status ] - The execution of the Test " + testName + " was FAILURE");
			this.takeScreenShots(result);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			LOGGER.info("[ Test Status ] - The execution of the Test " + testName + " was SUCCESS");
		}
		LOGGER.info(ConstantConfig.LOG_SEPARATOR);
	}

	/**
	 * Method to quit Selenium. Always remember to quit.
	 */
	@AfterSuite
	protected void tearDown() {
		LOGGER.info("[ Driver Configuration ] - Quit this Driver, closing every instance associated");
		driver.close(); //Cierra la ventana que actualmente se está ejecutando
		driver.quit(); //Cierra las ventanas que el driver ha abierto
	}
	
	/*--------------------------------------------------------------------* 
	|		SETUPS												
	*---------------------------------------------------------------------*/
	
	/**
	 * Method to setUp the Driver.
	 * 
	 * @throws CustomErrorException
	 */
	void setUpDriver() {
		driver = DriverConfig.buildInstance(browser, os);
	}
	
	
	/*--------------------------------------------------------------------* 
	|		PRIVATE METHODS									
	*---------------------------------------------------------------------*/
	
	/*
	 * Private Method to take screenshots if the tests failed
	 */
	private void takeScreenShots(ITestResult result) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
    	String screenShotName = "resources/screenshot/" + dateFormat.format(GregorianCalendar.getInstance().getTime());		
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	LOGGER.info("Screenshot saved as:" + screenShotName);
    	FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenShotName)));   
	}
	
	/**
	 * Private method to clean cookies and maximize the browser
	 */
	private void cleanCookiesMaxBrowser() {
        /******** Clean Cookies, maxinize and declare Timeout on the Driver *******/
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
	}
	
	/*--------------------------------------------------------------------* 
	|		PUBLIC METHODS									
	*---------------------------------------------------------------------*/
	public WebDriver getDriver() {
		return driver;
	}
	
}

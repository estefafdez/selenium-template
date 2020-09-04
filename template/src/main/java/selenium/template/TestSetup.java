package selenium.template;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class TestSetup {
	/** Logger class initialization. */
	private static final Logger LOGGER = LogManager.getLogger(TestSetup.class);
	
	WebDriver driver;
	String resourceFolder = "src/main/resources/drivers";
	String os = "mac";
	String browser = "CHROME";
	
	/**
	 * This method runs before any other method.
	 */
	@BeforeSuite
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
		driver.close();
		driver.quit();
	}
	
	private void takeScreenShots(ITestResult result) throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmm");
    	String screenShotName = "resources/screenshot/" + dateFormat.format(GregorianCalendar.getInstance().getTime());		
    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	LOGGER.info("Screenshot saved as:" + screenShotName);
    	FileUtils.copyFile(scrFile, new File(String.format("%s.png", screenShotName)));   
	}

}

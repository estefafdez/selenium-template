package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfig {
	
	/** Logger class initialization. */
	private static final Logger LOGGER = LogManager.getLogger(DriverConfig.class);
	
	/** Private constructor not used. */
	private DriverConfig() {}
	
	/** Generic Driver to build the selected platform */
	protected static WebDriver driver = null;
	static String resourceFolder = "src/main/resources/drivers/";
	String log = "INFO";
	
	/**
	 * Method to build a new Selenium Driver instance 
	 * @param browser and os
	 * @return the instance of the Driver
	 */
	public static WebDriver buildInstance(String browser, String os){	
		
		try {

			LOGGER.info("[ Driver Configuration ] - Set Up the Driver intance");
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
		    		 driver = new ChromeDriver();
		    	 }
		    	 else if("LINUX".equalsIgnoreCase(os)){
		    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver"); 
		    		 ChromeOptions options = new ChromeOptions().setHeadless(true); 
		    		 driver = new ChromeDriver(options);
				 }
		    	 else{
		    		 System.setProperty("webdriver.chrome.driver", resourceFolder+os+"/chromedriver");       
		    		 driver = new ChromeDriver();
		    	 }
		     }  
		     else {
				LOGGER.error("The Driver is not selected properly, invalid name: " + browser + ", " + os);
				 return null;
			}

		} catch (NullPointerException ex) {
			/** The driver instance is null cause by any capability, check this */
			LOGGER.error("The driver is malformed", ex);
		} catch (Exception ex) {
			LOGGER.error("Unexpected problem", ex);
		}
		
		return driver;
	}

}

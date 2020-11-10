package constant;

import org.openqa.selenium.By;

public class GoogleExampleConst {
	
	public static final By searchField = By.xpath("//input[@name='q']");
	
	public static final By secondElementGoogleSearch = By.xpath("//span[contains(text(),'WebDriver :: Documentation for Selenium')]");

}

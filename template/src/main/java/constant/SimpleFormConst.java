package constant;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;

public class SimpleFormConst {
	
	/*--------------------------------------------------------------------*
	|      HEADER ELEMENTS                                            
	*---------------------------------------------------------------------*/
	public static final By simpleFormPageTitle = By.xpath("//h3[contains(text(),'This would be your first example to start with Selenium')]");
	public static final By simpleFormPageSubtitle = By.xpath("//p[contains(., 'The tag input specifies an input field where the user can enter data.')]");
	
	/*--------------------------------------------------------------------*
	|      SIMPLE INPUT FIELD ELEMENTS                                            
	*---------------------------------------------------------------------*/
	
	public static final By userMessageInput = ById.id("user-message");
	public static final By showMessageButton = By.xpath("//button[contains(text(),'Show Message')]");
	public static final By yourMessage = By.xpath("//span[@id='display']");
	

	
	/*--------------------------------------------------------------------*
	|      TWO INPUT FIELDS ELEMENTS                                            
	*---------------------------------------------------------------------*/
	
	
}

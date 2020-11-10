package test;

import configuration.TestSetConfig;


/**
 * On this page we are going to create the tests that correspond to the actions 
 * that we could do on the homepage: click on the different options on the menu and on the header. 
 * 
 * @author estefafdez and @isabelaliaga
 *
 */
public class SelectDropdownTest extends TestSetConfig{
	
	//private static final Logger LOGGER = LogManager.getLogger(RadioButtonsTest.class);
	
//	/**
//	 * Select the day "Monday" from the list on "Select List Demo" and check that the correct message is shown
//	 */
//	@Test
//	
//	public void testSelectOneOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		
//		WebElement selectDropdownListOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Select Dropdown List')]"));
//		LOGGER.info("[INFO] - Clicking on the element selectDropdownListOption");
//		selectDropdownListOption.click();
//		
//		WebElement selectList = driver.findElement(ById.id("select-demo"));
//		LOGGER.info("[INFO] - Clicking on the element selectList");
//		selectList.click();
//		
//		WebElement mondayOption = driver.findElement(By.xpath("//option[@value='Monday']"));
//		LOGGER.info("[INFO] - Clicking on the element mondayOption");
//		mondayOption.click();
//		
//		WebElement selectListDemoMessage = driver.findElement(By.xpath("//p[@class='selected-value' and contains(., 'Day selected :- Monday')]"));
//		
//		//No aparece el mensaje
//		Assert.assertTrue(selectListDemoMessage.getText().contains("Day selected :- Monday"), "The message of selected day is not correct");
//
//	}
//	
//	/**
//	 * Select the option "Florida" from the list on "Multi Select List Demo", click on "First selected" button and check that the correct message is shown
//	 */
//	@Test
//	
//	public void testMultiSelectOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		
//		WebElement selectDropdownListOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Select Dropdown List')]"));
//		LOGGER.info("[INFO] - Clicking on the element selectDropdownListOption");
//		selectDropdownListOption.click();
//			
//		WebElement floridaOption = driver.findElement(By.xpath("//option[@value='Florida']"));
//		LOGGER.info("[INFO] - Clicking on the element floridaOption");
//		floridaOption.click();
//		
//		WebElement firstSelectedButton = driver.findElement(ById.id("printMe"));
//		LOGGER.info("[INFO] - Clicking on the element firstSelectedButton");
//		firstSelectedButton.click();
//		
//		WebElement firstSelectedMessage = driver.findElement(By.xpath("//p[@class='getall-selected' and contains(., 'First selected option is : Florida')]"));
//		
//		//No aparece el mensaje
//		Assert.assertTrue(firstSelectedMessage.getText().contains("First selected option is : Florida"), "The message of selected option is not correct");
//		
//	}
//	
//	/**
//	 * Don't select any option from the list on "Multi Select List Demo", click on "First selected" button and check that the correct message is shown
//	 */
//	@Test
//	
//	public void testMultiSelectNoOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		
//		WebElement selectDropdownListOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Select Dropdown List')]"));
//		LOGGER.info("[INFO] - Clicking on the element selectDropdownListOption");
//		selectDropdownListOption.click();
//			
//		WebElement firstSelectedButton = driver.findElement(ById.id("printMe"));
//		LOGGER.info("[INFO] - Clicking on the element firstSelectedButton");
//		firstSelectedButton.click();
//		
//		WebElement firstSelectedUndefinedMessage = driver.findElement(By.xpath("//p[@class='getall-selected' and contains(., 'First selected option is : undefined')]"));
//		
//		//No aparece el mensaje
//		Assert.assertTrue(firstSelectedUndefinedMessage.getText().contains("First selected option is : undefined"), "The message of undefined is not correct");
//		
//	}
//	
//	/**
//	 * Select two options "New Jersey" and "Ohio" from the list on "Multi Select List Demo", click on "First selected" button and check that the correct message is shown
//	 */
//	@Test
//	
//	public void testMultiSelectTwoOptionsFirst() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		
//		WebElement selectDropdownListOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Select Dropdown List')]"));
//		LOGGER.info("[INFO] - Clicking on the element selectDropdownListOption");
//		selectDropdownListOption.click();
//			
//		WebElement NewJerseyOption = driver.findElement(By.xpath("//option[@value='New Jersey']"));
//		LOGGER.info("[INFO] - Clicking on the element NewJerseyOption");
//		NewJerseyOption.click();
//		
//		WebElement OhioOption = driver.findElement(By.xpath("//option[@value='Ohio']"));
//		LOGGER.info("[INFO] - Clicking on the element OhioOption");
//		OhioOption.click();
//		
//		WebElement firstSelectedButton = driver.findElement(ById.id("printMe"));
//		LOGGER.info("[INFO] - Clicking on the element firstSelectedButton");
//		firstSelectedButton.click();
//		
//		WebElement firstSelectedMessage = driver.findElement(By.xpath("//p[@class='getall-selected' and contains(., 'First selected option is : New Jersey')]"));
//		
//		//No aparece el mensaje
//		Assert.assertTrue(firstSelectedMessage.getText().contains("First selected option is : New Jersey"), "The message of first selected is not correct");
//		
//	}
//	
//	/**
//	 * Select three options "California", "Texas" and "Washington" from the list on "Multi Select List Demo", click on "Get All Selected" button and check that the correct message is shown
//	 */
//	@Test
//	
//	public void testMultiSelectThreeOptionsGetAll() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		
//		WebElement selectDropdownListOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Select Dropdown List')]"));
//		LOGGER.info("[INFO] - Clicking on the element selectDropdownListOption");
//		selectDropdownListOption.click();
//			
//		WebElement CaliforniaOption = driver.findElement(By.xpath("//option[@value='California']"));
//		LOGGER.info("[INFO] - Clicking on the element CaliforniaOption");
//		CaliforniaOption.click();
//		
//		WebElement TexasOption = driver.findElement(By.xpath("//option[@value='Texas']"));
//		LOGGER.info("[INFO] - Clicking on the element TexasOption");
//		TexasOption.click();
//		
//		WebElement WashingtonOption = driver.findElement(By.xpath("//option[@value='Washington']"));
//		LOGGER.info("[INFO] - Clicking on the element WashingtonOption");
//		WashingtonOption.click();
//		
//		WebElement getAllSelectedButton = driver.findElement(ById.id("printAll"));
//		LOGGER.info("[INFO] - Clicking on the element getAllSelectedButton");
//		getAllSelectedButton.click();
//		
//		WebElement allSelectedMessage = driver.findElement(By.xpath("//p[@class='getall-selected' and contains(., 'Options selected are : California,Texas,Washington')]"));
//		
//		//No aparece el mensaje
//		Assert.assertTrue(allSelectedMessage.getText().contains("Options selected are : California,Texas,Washington"), "The message of all selected is not correct");
//		
//	}
//	
//	/**
//	 * Don't select any option from the list on "Multi Select List Demo", click on "Get All Selected" button and check that the correct message is shown
//	 */
//	@Test
//	
//	public void testMultiSelectAllNoOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//		
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		
//		WebElement selectDropdownListOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Select Dropdown List')]"));
//		LOGGER.info("[INFO] - Clicking on the element selectDropdownListOption");
//		selectDropdownListOption.click();
//			
//		WebElement getAllSelectedButton = driver.findElement(ById.id("printAll"));
//		LOGGER.info("[INFO] - Clicking on the element getAllSelectedButton");
//		getAllSelectedButton.click();
//		
//		WebElement allNoSelectedMessage = driver.findElement(By.xpath("//p[@class='getall-selected' and contains(., 'Options selected are : ')]"));
//		
//		//No aparece el mensaje
//		Assert.assertTrue(allNoSelectedMessage.getText().contains("Options selected are : "), "The message of no options selected is not correct");
//		
//	}

}

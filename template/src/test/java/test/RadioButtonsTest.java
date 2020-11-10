package test;

import configuration.TestSetConfig;

	
/**
 * On this page we are going to create the tests that correspond to the actions 
 * that we could do on the homepage: click on the different options on the menu and on the header. 
 * 
 * @author estefafdez and @isabelaliaga
 *
 */
public class RadioButtonsTest extends TestSetConfig{
	
//	private static final Logger LOGGER = LogManager.getLogger(TestsRadioButtons.class);
//	
//	/**
//	 * Select the option "Male" on "Radio Button Demo" and check that the message shows the selected option
//	 */
//	@Test	
//	
//	public void testRadioButtonMale() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		radioButtonsDemoOption.click();
//		
//		WebElement maleOption = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='Male']"));
//		maleOption.click();
//		
//		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
//		getCheckedValueButton.click();
//		
//		WebElement maleSelectedMessage = driver.findElement(By.xpath("//p[@class='radiobutton' and contains(., \"Radio button 'Male' is checked\")]"));
//		
//		Assert.assertTrue(maleSelectedMessage.getText().equals("Radio button 'Male' is checked"), "The selected option doesn't show correctly");
//
//	}
//	
//	/**
//	 * Select the option "Female" on "Radio Button Demo" and check that the message shows the selected option
//	 */
//	@Test
//		
//	public void testRadioButtonFemale() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		radioButtonsDemoOption.click();
//		
//		WebElement femaleOption = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='Female']"));
//		femaleOption.click();
//		
//		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
//		getCheckedValueButton.click();
//		
//		WebElement femaleSelectedMessage = driver.findElement(By.xpath("//p[@class='radiobutton' and contains(., \"Radio button 'Female' is checked\")]"));
//		
//		Assert.assertTrue(femaleSelectedMessage.getText().equals("Radio button 'Female' is checked"), "The selected option doesn't show correctly");
//	}
//	
//	/**
//	 * Don't select any option on "Radio Button Demo" and check that the correct message is shown
//	 */
//	@Test
//		
//	public void testRadioButtonNoOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		radioButtonsDemoOption.click();
//
//		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
//		getCheckedValueButton.click();
//		
//		WebElement radioButtonNotCheckedMessage = driver.findElement(By.xpath("//p[@class='radiobutton' and contains(., 'Radio button is Not checked')]"));
//		
//		Assert.assertTrue(radioButtonNotCheckedMessage.getText().equals("Radio button is Not checked"), "The message is not correct");
//	}
//	
//	/**
//	 * Select the options "Male" and "0 to 5" on "Group Buttons Demo" and check that the message is correct when clicking on the button
//	 */
//	@Test	
//	
//	public void testGroupRadioButtonMaleFirstOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
//		radioButtonsDemoOption.click();
//		
//		WebElement maleGroupOption = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
//		LOGGER.info("[INFO] - Clicking on the element maleGroupOption");
//		maleGroupOption.click();
//		
//		WebElement firstOptionAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='0 - 5']"));
//		LOGGER.info("[INFO] - Clicking on the element firstOptionAge");
//		firstOptionAge.click();
//
//		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
//		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
//		getValuesButton.click();
//		
//		WebElement sexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : Male')]"));
//		WebElement ageMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: 0 - 5')]"));
//		
//		Assert.assertTrue(sexMessage.getText().contains("Sex : Male"), "The message of sex is not correct");
//		Assert.assertTrue(ageMessage.getText().contains("Age group: 0 - 5"), "The message of age is not correct");
//	}
//	
//	/**
//	 * Select the options "Male" and "5 to 5" on "Group Buttons Demo" and check that the message is correct when clicking on the button
//	 */
//	@Test
//		
//	public void testGroupRadioButtonMaleSecondOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
//		radioButtonsDemoOption.click();
//		
//		WebElement maleGroupOption = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
//		LOGGER.info("[INFO] - Clicking on the element maleGroupOption");
//		maleGroupOption.click();
//		
//		WebElement firstOptionAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='5 - 15']"));
//		LOGGER.info("[INFO] - Clicking on the element firstOptionAge");
//		firstOptionAge.click();
//
//		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
//		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
//		getValuesButton.click();
//		
//		WebElement sexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : Male')]"));
//		WebElement ageMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: 5 - 15')]"));
//		
//		Assert.assertTrue(sexMessage.getText().contains("Sex : Male"), "The message of sex is not correct");
//		Assert.assertTrue(ageMessage.getText().contains("Age group: 5 - 15"), "The message of age is not correct");
//	}
//	
//	/**
//	 * Select the options "Female" and "15 to 50" on "Group Buttons Demo" and check that the message is correct when clicking on the button
//	 */
//	@Test
//		
//	public void testGroupRadioButtonFemaleThirdOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
//		radioButtonsDemoOption.click();
//		
//		WebElement femaleGroupOption = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
//		LOGGER.info("[INFO] - Clicking on the element femaleGroupOption");
//		femaleGroupOption.click();
//		
//		WebElement firstOptionAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='15 - 50']"));
//		LOGGER.info("[INFO] - Clicking on the element firstOptionAge");
//		firstOptionAge.click();
//
//		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
//		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
//		getValuesButton.click();
//		
//		WebElement sexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : Female')]"));
//		WebElement ageMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: 15 - 50')]"));
//		
//		Assert.assertTrue(sexMessage.getText().contains("Sex : Female"), "The message of sex is not correct");
//		Assert.assertTrue(ageMessage.getText().contains("Age group: 15 - 50"), "The message of age is not correct");
//	}
//	
//	/**
//	 * Don't select any option on "Group Buttons Demo" and check that the message is correct when clicking on the button
//	 */
//	@Test
//		
//	public void testGroupRadioButtonNoOption() {
//		driver.navigate().to("https://www.seleniumeasy.com/test/");
//		
//		// This method is defined on the TestSetup class.
//		closePopup();
//			
//		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
//		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
//		inputFormsOption.click();
//			
//		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
//		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
//		radioButtonsDemoOption.click();
//		
//		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
//		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
//		getValuesButton.click();
//		
//		WebElement emptySexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : ')]"));
//		WebElement emptyAgeMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: ')]"));
//		
//		Assert.assertTrue(emptySexMessage.getText().contains("Sex :"), "The message of sex is not correct");
//		Assert.assertTrue(emptyAgeMessage.getText().contains("Age group:"), "The message of age is not correct");
//	}

}

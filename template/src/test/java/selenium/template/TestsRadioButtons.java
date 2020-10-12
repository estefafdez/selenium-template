package selenium.template;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsRadioButtons extends TestSetup {
	
	private static final Logger LOGGER = LogManager.getLogger(TestsRadioButtons.class);
	
	/**
	 * Marcar la opción "Male" en "Radio Button Demo" y comprobar que se muestra en el mensaje la opción elegida
	 */
	@Test
	
	
	public void testRadioButtonMale() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement maleOption = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='Male']"));
		maleOption.click();
		
		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
		getCheckedValueButton.click();
		
		// Acostumbrate siempre a usar la clase en los xpath para buscar el elemento con el contains. 
		// los \ antes de las " son para que el eclpse considere las comillas como tales y no como un cierre de la cadena, esto se llama escapar carácteres
		WebElement maleSelectedMessage = driver.findElement(By.xpath("//p[@class='radiobutton' and contains(., \"Radio button 'Male' is checked\")]"));
		
		Assert.assertTrue(maleSelectedMessage.getText().equals("Radio button 'Male' is checked"), "La opción elegida no se muestra correctamente");

	}
	
	/**
	 * Marcar la opción "Female" en "Radio Button Demo" y comprobar que se muestra en el mensaje la opción elegida
	 */
	@Test
	
	
	public void testRadioButtonFemale() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement femaleOption = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='Female']"));
		femaleOption.click();
		
		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
		getCheckedValueButton.click();
		
		WebElement femaleSelectedMessage = driver.findElement(By.xpath("//p[@class='radiobutton' and contains(., \"Radio button 'Female' is checked\")]"));
		
		Assert.assertTrue(femaleSelectedMessage.getText().equals("Radio button 'Female' is checked"), "La opción elegida no se muestra correctamente");
	}
	
	/**
	 * No marcar ninguna opción en "Radio Button Demo" y comprobar que se muestra el mensaje correcto
	 */
	@Test
	
	
	public void testRadioButtonNoOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();

		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
		getCheckedValueButton.click();
		
		WebElement radioButtonNotCheckedMessage = driver.findElement(By.xpath("//p[contains(text(),'Radio button is Not checked')]"));
		
		Assert.assertTrue(radioButtonNotCheckedMessage.getText().equals("Radio button is Not checked"), "El mensaje no es correcto");
	}
	
	/**
	 * Marcar las opciones "Male" y "0 to 5" en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonMaleFirstOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
		radioButtonsDemoOption.click();
		
		WebElement maleGroupOption = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
		LOGGER.info("[INFO] - Clicking on the element maleGroupOption");
		maleGroupOption.click();
		
		WebElement firstOptionAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='0 - 5']"));
		LOGGER.info("[INFO] - Clicking on the element firstOptionAge");
		firstOptionAge.click();

		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
		getValuesButton.click();
		
		WebElement sexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : Male')]"));
		WebElement ageMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: 0 - 5')]"));
		
		Assert.assertTrue(sexMessage.getText().contains("Sex : Male"), "El mensaje del sexo no es correcto");
		Assert.assertTrue(ageMessage.getText().contains("Age group: 0 - 5"), "El mensaje de la edad no es correcto");
	}
	
	/**
	 * Marcar las opciones "Male" y "5 to 5" en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonMaleSecondOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
		radioButtonsDemoOption.click();
		
		WebElement maleGroupOption = driver.findElement(By.xpath("//input[@name='gender' and @value='Male']"));
		LOGGER.info("[INFO] - Clicking on the element maleGroupOption");
		maleGroupOption.click();
		
		WebElement firstOptionAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='5 - 15']"));
		LOGGER.info("[INFO] - Clicking on the element firstOptionAge");
		firstOptionAge.click();

		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
		getValuesButton.click();
		
		WebElement sexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : Male')]"));
		WebElement ageMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: 5 - 15')]"));
		
		Assert.assertTrue(sexMessage.getText().contains("Sex : Male"), "El mensaje del sexo no es correcto");
		Assert.assertTrue(ageMessage.getText().contains("Age group: 5 - 15"), "El mensaje de la edad no es correcto");
	}
	
	/**
	 * Marcar las opciones "Female" y "15 to 50" en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonFemaleThirdOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
		radioButtonsDemoOption.click();
		
		WebElement femaleGroupOption = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
		LOGGER.info("[INFO] - Clicking on the element femaleGroupOption");
		femaleGroupOption.click();
		
		WebElement firstOptionAge = driver.findElement(By.xpath("//input[@name='ageGroup' and @value='15 - 50']"));
		LOGGER.info("[INFO] - Clicking on the element firstOptionAge");
		firstOptionAge.click();

		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
		getValuesButton.click();
		
		WebElement sexMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Sex : Female')]"));
		WebElement ageMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton' and contains(., 'Age group: 15 - 50')]"));
		
		Assert.assertTrue(sexMessage.getText().contains("Sex : Female"), "El mensaje del sexo no es correcto");
		Assert.assertTrue(ageMessage.getText().contains("Age group: 15 - 50"), "El mensaje de la edad no es correcto");
	}
	
	/**
	 * No marcar ninguna opción en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonNoOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		LOGGER.info("[INFO] - Clicking on the element radioButtonsDemoOption");
		radioButtonsDemoOption.click();
		
		WebElement getValuesButton = driver.findElement(By.xpath("//button[@class='btn btn-default' and contains(., 'Get values')]"));
		LOGGER.info("[INFO] - Clicking on the element getValuesButton");
		getValuesButton.click();
		
		WebElement emptyMessage = driver.findElement(By.xpath("//p[@class='groupradiobutton']"));
		
		Assert.assertTrue(emptyMessage.getText().contains("Sex :"), "El mensaje del sexo no es correcto");
		Assert.assertTrue(emptyMessage.getText().contains("Age group:"), "El mensaje de la edad no es correcto");
	}

}

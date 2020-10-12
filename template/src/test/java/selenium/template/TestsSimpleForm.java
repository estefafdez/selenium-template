package selenium.template;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsSimpleForm extends TestSetup {
	
	private static final Logger LOGGER = LogManager.getLogger(TestsSimpleForm.class);
	
	/**
	 * Introducir un mensaje en un formulario y comprobar que se muestra correctamente al pulsar el botón
	 * @throws InterruptedException 
	 */
	@Test
	public void testSingleInputField(){
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		LOGGER.info("[INFO] - Clicking on the element inputFormsOption");
		inputFormsOption.click();
			
		WebElement simpleFormDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]"));
		LOGGER.info("[INFO] - Clicking on the element simpleFormDemoOption");
		simpleFormDemoOption.click();
			
		WebElement singleInput = driver.findElement(ById.id("user-message"));
		LOGGER.info("[INFO] - Clicking on the element singleInput");
		singleInput.click();
		LOGGER.info("[INFO] - Clearing the input singleInput");
		singleInput.clear();
		LOGGER.info("[INFO] - Sending text to the element singleInput");
		singleInput.sendKeys("Primer mensaje");
			
		WebElement showMessageButton = driver.findElement(By.xpath("//button[contains(text(),'Show Message')]"));
		LOGGER.info("[INFO] - Clicking on the element showMessageButton");
		showMessageButton.click();
			
		WebElement yourMessage = driver.findElement(By.xpath("//span[@id='display']"));
		Assert.assertTrue(yourMessage.getText().equals("Primer mensaje"), "El mensaje no se muestra correctamente");
	}
	
	/**
	 * Introducir dos valores en el formulario y comprobar al pulsar el botón que el resultado de la operación es el correcto
	 */
	@Test
	public void testTwoFilledInputFields(){
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement simpleFormDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]"));
		simpleFormDemoOption.click();
		
		WebElement inputA = driver.findElement(ById.id("sum1"));
		inputA.click();
		inputA.clear();
		inputA.sendKeys("5");
		
		WebElement inputB = driver.findElement(ById.id("sum2"));
		inputB.click();
		inputB.clear();
		inputB.sendKeys("3");
		
		WebElement getTotalButton = driver.findElement(By.xpath("//button[contains(text(),'Get Total')]"));
		getTotalButton.click();
		
		WebElement totalResult = driver.findElement(By.xpath("//span[@id='displayvalue']"));
			
		Assert.assertTrue(totalResult.getText().equals("8"), "El resultado no es correcto");
	}
	
	/**
	 * Dejar vacíos los campos del formulario y comprobar al pulsar el botón que el resultado se muestra en blanco
	 */
	@Test
	public void testTwoEmptyInputFieldsEmpty(){
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// This method is defined on the TestSetup class.
		closePopup();
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement simpleFormDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]"));
		simpleFormDemoOption.click();
		
		WebElement inputA = driver.findElement(ById.id("sum1"));
		inputA.click();
		inputA.clear();
		
		WebElement inputB = driver.findElement(ById.id("sum2"));
		inputB.click();
		inputB.clear();
		
		WebElement getTotalButton = driver.findElement(By.xpath("//button[contains(text(),'Get Total')]"));
		getTotalButton.click();
		
		WebElement totalResult = driver.findElement(By.xpath("//span[@id='displayvalue']"));
			
		Assert.assertTrue(totalResult.getText().equals("NaN"), "El resultado no es correcto");
	}
	

}

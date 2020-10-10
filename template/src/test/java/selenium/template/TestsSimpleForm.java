package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsSimpleForm extends TestSetup {
	
	/**
	 * Introducir un mensaje en un formulario y comprobar que se muestra correctamente al pulsar el botón
	 */
	@Test
	public void testSingleInputField(){
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		// Controlar si aparece el popup
		
		WebElement popup = driver.findElement(By.xpath("//div[@id='at-cv-lightbox']"));
	
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		
		if(wait.until(ExpectedConditions.visibilityOf(popup)) != null) { // Si aparece el pop up lo cerramos
			driver.switchTo().frame(0);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.document.getElementById('at-cv-lightbox-close').click();");
			
		}else {
			WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
			inputFormsOption.click();
			
			WebElement simpleFormDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Simple Form Demo')]"));
			simpleFormDemoOption.click();
			
			WebElement singleInput = driver.findElement(ById.id("user-message"));
			singleInput.click();
			singleInput.clear();
			singleInput.sendKeys("Primer mensaje");
			
			WebElement showMessageButton = driver.findElement(By.xpath("//button[contains(text(),'Show Message')]"));
			showMessageButton.click();
			
			WebElement yourMessage = driver.findElement(By.xpath("//span[@id='display']"));
				
			Assert.assertTrue(yourMessage.getText().equals("Primer mensaje"), "El mensaje no se muestra correctamente");
			
		}
		
	}
	
	/**
	 * Introducir dos valores en el formulario y comprobar al pulsar el botón que el resultado de la operación es el correcto
	 */
	@Test
	public void testTwoFilledInputFields(){
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
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

package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestsInputForm extends TestSetup{
	
	/**
	 * Marcar el checkbox de Single Checkbox Demo y comprobar que se muestra el mensaje correcto
	 */
	@Test
	
	public void testSingleCheckboxDemo() {
		
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement checkboxDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Checkbox Demo')]"));
		checkboxDemoOption.click();
		
		WebElement singleCheckbox = driver.findElement(ById.id("isAgeSelected"));
		singleCheckbox.click();
		
		WebElement successMessage = driver.findElement(ById.id("txtAge"));
		
		//Modificar
		Assert.assertTrue(successMessage.isDisplayed(), "El mensaje no se muestra");
	}
	
	/**
	 * Marcar dos opciones de Multiple Checkbox Demo y comprobar que ambas están seleccionadas
	 */
	@Test
	
	public void testMultipleCheckboxDemoTwoOptions() {
		
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement checkboxDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Checkbox Demo')]"));
		checkboxDemoOption.click();
		
		WebElement option1Checkbox = driver.findElement(By.xpath("//input[contains(text(),'Option 1')]"));
		option1Checkbox.click();
		
		WebElement option3Checkbox = driver.findElement(By.xpath("//input[contains(text(),'Option 3')]"));
		option3Checkbox.click();
		
		//No funciona
		Assert.assertTrue(option1Checkbox.getAttribute("checked").equals("true"), "La opción 1 no está seleccionada");
		Assert.assertTrue(option3Checkbox.getAttribute("checked").equals("true"), "La opción 3 no está seleccionada");

	}
	
	/**
	 * Pulsar el botón "Check All" y comprobar que todas las opciones están seleccionadas
	 */
	@Test
	
	public void testMultipleCheckboxDemoAllOptionsSelecte() {
		
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement checkboxDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Checkbox Demo')]"));
		checkboxDemoOption.click();
		
		WebElement checkAllButton = driver.findElement(ById.id("check1"));
		checkAllButton.click();
		
		//Comprobar que todas las opciones están seleccionadas
		
	}
	
	/**
	 * Marcar todas las opciones pulsando en "Check All", pulsar de nuevo y comprobar que todas las opciones están deseleccionadas
	 */
	@Test
	
	public void testMultipleCheckboxDemoAllOptionsUnselect() {
		
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement checkboxDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Checkbox Demo')]"));
		checkboxDemoOption.click();
		
		WebElement checkAllButton = driver.findElement(ById.id("check1"));
		checkAllButton.click();
		
		//Comprobar que todas las opciones están seleccionadas
		
		
		checkAllButton.click();
		
		//Comprobar que todas las opciones están deseleccionadas
		
	}	
	
}

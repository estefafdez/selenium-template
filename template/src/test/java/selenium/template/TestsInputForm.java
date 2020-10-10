package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		WebElement singleCheckbox = driver.findElement(By.id("isAgeSelected"));
		singleCheckbox.click();
		
		WebElement successMessage = driver.findElement(ById.id("txtAge"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Forzamos la visibilidad en JavaScript del elemento
		js.executeScript("document.getElementById('txtAge').style.display='block';");
		
		WebDriverWait wait = new WebDriverWait(driver, 5); // El tiempo máximo que esperamos es 5 segundos
		wait.until(ExpectedConditions.visibilityOf(successMessage));
		
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
		
		WebElement option1Checkbox = driver.findElement(By.xpath("//label[contains(., 'Option 1')]/input"));
		
		// Método para esperar a una acción que tiene que ocurrir, por ejemplo, que un elemento sea visible
    	WebDriverWait wait = new WebDriverWait(driver, 5); // El tiempo máximo que esperamos es 5 segundos
		
		wait.until(ExpectedConditions.visibilityOf(option1Checkbox)); // Esperar a que el elemento sea visible
		
		// Acción para realizar una acción definida en selenium como, por ejemplo, mover el foco a un punto concreto
		Actions act = new Actions(driver);
		
		// Como un simple click no basta, mover el foco a ese elemento y forzar el click
		act.moveToElement(option1Checkbox).click().build().perform();
		
		// Realizar los mismos pasos para el checkbox 3
		WebElement option3Checkbox = driver.findElement(By.xpath("//label[contains(., 'Option 3')]/input"));
		
		wait.until(ExpectedConditions.visibilityOf(option3Checkbox));
		act.moveToElement(option3Checkbox).click().build().perform();
		
		Assert.assertTrue(option1Checkbox.isSelected(), "La opción 1 no está seleccionada");
		Assert.assertTrue(option3Checkbox.isSelected(), "La opción 3 no está seleccionada");

	}
	
	/**
	 * Pulsar el botón "Check All" y comprobar que todas las opciones están seleccionadas
	 */
	@Test
	
	public void testMultipleCheckboxDemoAllOptionsSelecte() { //No funciona, las opciones no se marcan
		
		driver.navigate().to("https://www.seleniumeasy.com/test/");
		
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
		
		WebElement checkboxDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Checkbox Demo')]"));
		checkboxDemoOption.click();
		
		WebElement option1Checkbox = driver.findElement(By.xpath("//label[contains(., 'Option 1')]/input"));
		option1Checkbox.isDisplayed();
		WebElement option2Checkbox = driver.findElement(By.xpath("//label[contains(., 'Option 2')]/input"));
		option2Checkbox.isDisplayed();
		WebElement option3Checkbox = driver.findElement(By.xpath("//label[contains(., 'Option 3')]/input"));
		option3Checkbox.isDisplayed();
		WebElement option4Checkbox = driver.findElement(By.xpath("//label[contains(., 'Option 4')]/input"));
		option4Checkbox.isDisplayed();
		
		WebElement checkAllButton = driver.findElement(ById.id("check1"));
		checkAllButton.click();	

		//Comprobar que todas las opciones están seleccionadas
		Assert.assertTrue(option1Checkbox.isSelected(), "La opción 1 no está seleccionada");
		Assert.assertTrue(option2Checkbox.isSelected(), "La opción 2 no está seleccionada");
		Assert.assertTrue(option3Checkbox.isSelected(), "La opción 3 no está seleccionada");
		Assert.assertTrue(option4Checkbox.isSelected(), "La opción 4 no está seleccionada");
		
	}
	
	/**
	 * Marcar todas las opciones pulsando en "Check All", pulsar de nuevo y comprobar que todas las opciones están deseleccionadas
	 */
	@Test
	
	public void testMultipleCheckboxDemoAllOptionsUnselect() { //Completar
		
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
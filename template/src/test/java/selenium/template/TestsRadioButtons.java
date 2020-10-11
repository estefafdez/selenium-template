package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestsRadioButtons extends TestSetup{
	
	/**
	 * Marcar la opción "Male" en "Radio Button Demo" y comprobar que se muestra en el mensaje la opción elegida
	 */
	@Test
	
	
	public void testRadioButtonMale() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement maleOption = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='Male']"));
		maleOption.click();
		
		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
		getCheckedValueButton.click();
		
		WebElement maleSelectedMessage = driver.findElement(By.xpath("//p[contains(text(),'Radio button 'Male' is checked')]"));
		
		Assert.assertTrue(maleSelectedMessage.getText().equals("Radio button 'Male' is checked"), "La opción elegida no se muestra correctamente");
		//Falla pero el mensaje correcto se muestra
	}
	
	/**
	 * Marcar la opción "Female" en "Radio Button Demo" y comprobar que se muestra en el mensaje la opción elegida
	 */
	@Test
	
	
	public void testRadioButtonFemale() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement femaleOption = driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='Female']"));
		femaleOption.click();
		
		WebElement getCheckedValueButton = driver.findElement(ById.id("buttoncheck"));
		getCheckedValueButton.click();
		
		WebElement femaleSelectedMessage = driver.findElement(By.xpath("//p[contains(text(),'Radio button 'Female' is checked')]"));
		
		Assert.assertTrue(femaleSelectedMessage.getText().equals("Radio button 'Female' is checked"), "La opción elegida no se muestra correctamente");
		//Falla pero el mensaje correcto se muestra
	}
	
	/**
	 * No marcar ninguna opción en "Radio Button Demo" y comprobar que se muestra el mensaje correcto
	 */
	@Test
	
	
	public void testRadioButtonNoOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
			
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
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement maleGroupOption = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[2]/div[2]/div[1]/label[1]/input[@value='Male']"));
		maleGroupOption.click();
		
		WebElement firstOptionAge = driver.findElement(By.xpath("//label[@class='radio-inline']/input[contains(text(), '0 to 5']"));
		firstOptionAge.click();

		WebElement getValuesButton = driver.findElement(By.xpath("//button[contains(text(),'Get values')]"));
		getValuesButton.click();
		
		WebElement sexAgeMessage = driver.findElement(By.xpath("//p[contains(text(),'Sex : Male')]"));
		
		//Modificar para que tenga en cuenta los dos mensajes (sexo y edad)
		Assert.assertTrue(sexAgeMessage.getText().equals("Sex : Male" + " Age group: 0 - 5"), "El mensaje no es correcto");
	}
	
	/**
	 * Marcar las opciones "Male" y "5 to 5" en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonMaleSecondOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement maleGroupOption = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[2]/div[2]/div[1]/label[1]/input[@value='Male']"));
		maleGroupOption.click();
		
		WebElement secondOptionAge = driver.findElement(By.xpath("//label[@class='radio-inline']/input[contains(text(), '5 to 15']"));
		secondOptionAge.click();

		WebElement getValuesButton = driver.findElement(By.xpath("//button[contains(text(),'Get values')]"));
		getValuesButton.click();
		
		WebElement sexAgeMessage = driver.findElement(By.xpath("//p[contains(text(),'Sex : Male')]"));
		
		//Modificar para que tenga en cuenta los dos mensajes (sexo y edad)
		//El mensaje aparece sin los datos seleccionados
		Assert.assertTrue(sexAgeMessage.getText().equals("Sex : Male" + " Age group: 5 - 15"), "El mensaje no es correcto");
	}
	
	/**
	 * Marcar las opciones "Female" y "15 to 50" en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonFemaleThirdOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement femaleGroupOption = driver.findElement(By.xpath("//div[@class='col-md-6 text-left']/div[2]/div[2]/div[1]/label[2]/input[@value='Female']"));
		femaleGroupOption.click();
		
		WebElement thirdOptionAge = driver.findElement(By.xpath("//label[@class='radio-inline']/input[contains(text(), '15 to 50']"));
		thirdOptionAge.click();

		WebElement getValuesButton = driver.findElement(By.xpath("//button[contains(text(),'Get values')]"));
		getValuesButton.click();
		
		WebElement sexAgeMessage = driver.findElement(By.xpath("//p[contains(text(),'Sex : Female')]"));
		
		//Modificar para que tenga en cuenta los dos mensajes (sexo y edad)
		//El mensaje aparece sin los datos seleccionados
		Assert.assertTrue(sexAgeMessage.getText().equals("Sex : Female" + " Age group: 15 - 50"), "El mensaje no es correcto");
	}
	
	/**
	 * No marcar ninguna opción en "Group Buttons Demo" y comprobar que se muestra el mensaje correcto al pulsar el botón
	 */
	@Test
	
	
	public void testGroupRadioButtonNoOption() {
		driver.navigate().to("https://www.seleniumeasy.com/test/");
			
		WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));
		inputFormsOption.click();
			
		WebElement radioButtonsDemoOption = driver.findElement(By.xpath("//li[@class='tree-branch']/ul/li/a[contains(text(),'Radio Buttons Demo')]"));
		radioButtonsDemoOption.click();
		
		WebElement getValuesButton = driver.findElement(By.xpath("//button[contains(text(),'Get values')]"));
		getValuesButton.click();
		
		WebElement sexAgeEmptyMessage = driver.findElement(By.xpath("//p[contains(text(),'Sex : Female')]"));
		
		//Modificar para que tenga en cuenta los dos mensajes vacíos (sexo y edad)
		Assert.assertTrue(sexAgeEmptyMessage.getText().equals("Sex : " + "Age group: "), "El mensaje no es correcto");
	}

}

package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyFirstTest extends TestSetup{

	/**
	 * Introducir un texto en el buscador de Google
	 */
	@Test
	public void testNavigateToGoogle() {
		driver.navigate().to("http://www.google.es");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hola");
		
	}
	
	/**
	 * Buscar en Google "Selenium Webdriver", acceder a la URL y comprobar que es la página correcta
	 */
	@Test
	public void testNavigateAndSearchOnGoogle() {
		driver.navigate().to("http://www.google.es");
		
		// Nos cambiamos al pop up para poder interaccionar con él. 
		driver.switchTo().frame(0);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Forzamos el click on JavaScript
		js.executeScript("window.document.getElementById('introAgreeButton').click();");
	
		
		WebElement inputGoogle = driver.findElement(By.name("q"));
		
		inputGoogle.click();
		inputGoogle.clear();
		inputGoogle.sendKeys("Selenium Webdriver");
		inputGoogle.sendKeys(Keys.ENTER);
		
		WebElement secondResult = driver.findElement(By.xpath("//span[contains(text(),'WebDriver :: Documentation for Selenium')]"));
		
		secondResult.click();
				
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev/documentation/en/webdriver/"), "La URL no es correcta");		
		Assert.assertTrue(driver.getTitle().equals("WebDriver :: Documentation for Selenium"), "El título no es correcto");		
	}
	
}

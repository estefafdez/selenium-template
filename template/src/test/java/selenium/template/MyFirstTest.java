package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyFirstTest extends TestSetup{

	
	@Test
	public void testNavigateToGoogle() {
		driver.navigate().to("http://www.google.es");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hola");
		
	}
	
	@Test
	public void testNavigateAndSearchOnGoogle() {
		driver.navigate().to("http://www.google.es");
		
		// Nos cambiamos al iframe de las cookies para poder interaccionar con él. 
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
				
		Assert.assertTrue(driver.getCurrentUrl().equals("https://www.selenium.dev"), "La URL no es correcta");		
		Assert.assertTrue(driver.getTitle().equals("SeleniumHQ Browser Automation"), "El título no es correcto");
		
	}
	

}

package selenium.template;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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
		WebElement inputGoogle = driver.findElement(By.name("q"));
		
		inputGoogle.click();
		inputGoogle.clear();
		inputGoogle.sendKeys("selenium");
		inputGoogle.sendKeys(Keys.ENTER);
		
	}


}

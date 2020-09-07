package selenium.template;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MyFirstTest extends TestSetup{
	
	@Test
	public void testNavigateToGoogle() {
		driver.navigate().to("http://www.google.es");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hola");
		
	}

}

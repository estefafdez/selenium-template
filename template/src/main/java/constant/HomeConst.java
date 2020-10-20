package constant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import selenium.template.TestSetup;

public class HomeConst extends TestSetup{
		
	/* Menu List Options */
	public static final WebElement inputFormsOption = driver.findElement(By.xpath("//li[@class='tree-branch']/a[contains(text(),'Input Forms')]"));

}

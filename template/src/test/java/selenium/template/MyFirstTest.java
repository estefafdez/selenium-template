package selenium.template;

import org.testng.annotations.Test;

public class MyFirstTest extends TestSetup{
	
	@Test
	public void testNavigateToGoogle() {
		driver.navigate().to("http://www.google.es");
	}

}

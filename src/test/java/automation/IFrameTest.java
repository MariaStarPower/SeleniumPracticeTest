package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IFrameTest extends BaseClass {
	
	@Test
	// Verify that I can work in the iFrame component
	public void validateIFrame() {
		
		WebElement iFrame = driver.findElement(By.id("courses-iframe"));
		
		driver.switchTo().frame(iFrame);
		
		WebElement header = driver.findElement(By.tagName("header"));
		List<WebElement> headerList = header.findElements(By.tagName("li"));
		
		String email = headerList.get(0).getText();
		System.out.println(email);
		
		driver.switchTo().defaultContent();
	}

}

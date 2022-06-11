package automation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IFrameTest extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeTest
	// Initialize the WebDriver
	public void initialize() throws IOException {
		
		driver = initializeWebDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
	}
	
	@AfterTest
	// Close the browser
	public void closeDown() {
		
		driver.quit();
	}
	
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

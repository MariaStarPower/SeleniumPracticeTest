package automation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavBarTest extends BaseClass {
	
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
	// Verify that the links in the nav section are working
	public void validateHeaderNavLinks() {
		
		WebElement logo = driver.findElement(By.cssSelector("header a img"));
		
		logo.click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		WebElement blinkingText = driver.findElement(By.cssSelector(".blinkingText"));
		
		blinkingText.click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		WebElement homeButton = driver.findElement(By.xpath("//button[contains(text(),'Home')]"));
		
		homeButton.click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

}

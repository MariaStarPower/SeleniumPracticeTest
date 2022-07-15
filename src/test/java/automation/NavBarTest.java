package automation;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class NavBarTest extends BaseClass {
	
	@Test
	// Verify that the clickable logo is working
	public void validateClickableLogo() {
		
		WebElement logo = driver.findElement(By.cssSelector("img.logoClass"));
		
		logo.click();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		assertEquals("Rahul Shetty Academy", title);
	}
	
	@Test
	// Verify that the link in the blinking text is working
	public void validateBlinkingText() {
		
		WebElement blinkingText = driver.findElement(By.linkText("Free Access to InterviewQues/ResumeAssistance/Material"));
		
		blinkingText.click();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		assertEquals("Rahul Shetty Academy", title);
	}
	
	@Test
	// Verify that the Home button is working
	public void validateHomeButton() {
		
		WebElement home = driver.findElement(By.xpath("//button[contains(text(),'Home')]"));
		
		home.click();
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		assertEquals("Rahul Shetty Academy", title);
	}
	
	@AfterMethod
	// Navigate back to the main page
	public void back() {
		
		driver.navigate().back();
	}
}

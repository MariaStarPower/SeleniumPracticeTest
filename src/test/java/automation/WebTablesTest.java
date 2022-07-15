package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseClass {
	
	@Test
	// Verify that I can extract and manipulate values from a web table
	public void webTableExample() {
		
		WebElement firstCourse = driver.findElement(By.cssSelector("[name='courses'] tr:nth-child(2) td:nth-child(2)"));
		String courseText = firstCourse.getText();
		
		System.out.println(courseText);
		
		List<WebElement> prices = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int total = 0;
		
		for(int i = 0; i < prices.size(); i++) {
			
			total += Integer.parseInt(prices.get(i).getText());
		}
		
		System.out.println(total);
		
		String totalAmountText = driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ")[1];
		
		int totalAmount = Integer.parseInt(totalAmountText);
		
		Assert.assertEquals(total, totalAmount);
	}

}

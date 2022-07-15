package automation;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FooterLinksTest extends BaseClass {
	
	@Test
	// Verify that all of the links in the first column of the footer section are working
	public void verifyFooterLinks() {
		
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
		int numFooterLinks = footerLinks.size();
		System.out.println("Number of links in footer: " + numFooterLinks);
		
		WebElement firstColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> firstColumnLinks = firstColumn.findElements(By.tagName("a"));
		int numFirstColumnLinks = firstColumnLinks.size();
		
		Platform platformName = ((HasCapabilities) driver).getCapabilities().getPlatformName();
		String clickOnLink = platformName.is(Platform.MAC) ? Keys.chord(Keys.COMMAND, Keys.RETURN) : Keys.chord(Keys.CONTROL, Keys.ENTER);
		
		// Click on each link in the column to check if the pages are opening
		for(int i = 1; i < numFirstColumnLinks; i++) {
			
			firstColumn.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			
		}  
		
		// Opens all of the tabs	
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> it = tabs.iterator();
			
		while(it.hasNext()) {  // hasNext() method lets us know if the next index is present
				
			driver.switchTo().window(it.next());  // next() method moves to the next index
			System.out.println(driver.getTitle());
		}
		
	}		

}

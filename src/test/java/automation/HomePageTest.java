package automation;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
	
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
	// Verify that the radio buttons are working
	public void radioButtonExample() {
		
		
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".radioButton"));
		List<WebElement> labels = driver.findElements(By.cssSelector("#radio-btn-example label"));
		
		String labelText;
		WebElement radioButton;
		
		for(int i = 0; i < labels.size(); i++) {
			
			for(int j = 0; j < radioButtons.size(); j++) {
				
				radioButton = radioButtons.get(j);
				radioButton.click();
				
				Assert.assertTrue(radioButton.isSelected());
			}
			labelText = labels.get(i).getText();
			System.out.println(labelText);
		}
		
	}
	
	@Test
	// Verify that the auto-suggestive drop-down is working
	public void suggestionClassExample() {
		
		WebElement suggestionBox = driver.findElement(By.id("autocomplete"));
		suggestionBox.sendKeys("usa");
		
		List<WebElement> suggestions = driver.findElements(By.cssSelector(".ui-menu-item"));
		
		String suggestionText;
		
		for(WebElement suggestion : suggestions) {
			
			suggestionText = suggestion.getText();
			
			if(suggestionText.equalsIgnoreCase("usa")) {
				
				suggestion.click();
				break;
			}
			System.out.println(suggestionText);
		}
		
	}
	
	@Test
	// Verify that the select box for the drop-down is working
	public void dropDownExample() {
				
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		
		List<WebElement> selectOptions = select.getOptions();
		
		String selectedOption;
		boolean isOptionSelected;
		
		for(int i = 0; i < selectOptions.size(); i++) {
			
			select.selectByIndex(i);
			selectedOption = select.getFirstSelectedOption().getText();
			System.out.println(selectedOption);
			
			isOptionSelected = selectOptions.get(i).isSelected();
			Assert.assertTrue(isOptionSelected);
		}
		
	}
	
	@Test
	// Verify that the check boxes are working
	public void checkBoxExample() {
		
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector("#checkbox-example input"));
		List<WebElement> checkBoxLabels = driver.findElements(By.cssSelector("#checkbox-example label"));
		
		WebElement checkBox;
		String checkBoxLabel;
		
		for(int i = 0; i < checkBoxLabels.size(); i++) {
			
			for(int j = 0; j < checkBoxes.size(); j++) {
				
				checkBox = checkBoxes.get(j);
				checkBox.click();
			}
			checkBoxLabel = checkBoxLabels.get(i).getText();
			System.out.println(checkBoxLabel);
		}
		checkBoxes.clear();
		
		boolean checkBoxesUnchecked = checkBoxes.isEmpty();
		Assert.assertTrue(checkBoxesUnchecked);
	}
	
	@Test
	// Verify that the alert boxes are working
	public void switchToAlertExample() {
		
		WebElement nameBox = driver.findElement(By.id("name"));
		WebElement alertBtn = driver.findElement(By.id("alertbtn"));
		WebElement confirmBtn = driver.findElement(By.id("confirmbtn"));
		
		String name = "Maria";
		String alertText;
		boolean containsName;
		
		nameBox.sendKeys(name);
		alertBtn.click();
		
		Alert alert = driver.switchTo().alert();
		
		alertText = alert.getText();
		System.out.println(alertText);
		
		containsName = alertText.contains(name);
		Assert.assertTrue(containsName);
		
		alert.accept();
		
		nameBox.sendKeys(name);
		confirmBtn.click();
		
		alertText = alert.getText();
		System.out.println(alertText);
		
		containsName = alertText.contains(name);
		Assert.assertTrue(containsName);
		
		alert.dismiss();
		
		nameBox.sendKeys(name);
		confirmBtn.click();
		
		alertText = alert.getText();
		System.out.println(alertText);
		
		containsName = alertText.contains(name);
		Assert.assertTrue(containsName);
		
		alert.accept();
	}
	
	@Test
	// Verify that the text box element is hidden when "Hide" is clicked, and visible when "Show" is clicked
	public void elementDisplayedExample() {
		
		WebElement hide = driver.findElement(By.id("hide-textbox"));
		WebElement show = driver.findElement(By.id("show-textbox"));
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		
		String text = "Hi";
		
		textBox.sendKeys(text);
		System.out.println(text);
		
		hide.click();
		Assert.assertFalse(textBox.isDisplayed());
		
		show.click();
		Assert.assertTrue(textBox.isDisplayed());
		
		String textBoxValue = textBox.getAttribute("value");
		System.out.println(textBoxValue);
		
		Assert.assertEquals(text, textBoxValue);
		
	}
	
	@Test
	// Verify that the Mouse Hover button is working
	public void mouseHoverExample() {
		
		WebElement mouseHover = driver.findElement(By.id("mousehover"));
		WebElement top = driver.findElement(By.cssSelector("[href='#top']"));
		WebElement reload = driver.findElement(By.cssSelector(".mouse-hover-content a:nth-child(2)"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseHover);
		actions.perform();
		
		top.click();
		
		actions.moveToElement(mouseHover);
		actions.perform();
		
		reload.click();
	}
}

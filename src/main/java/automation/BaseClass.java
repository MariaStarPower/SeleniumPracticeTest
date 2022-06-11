package automation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	// Declare a WebDriver object
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeWebDriver() throws IOException {
		
		// Create a Properties object to manipulate the properties of the data.properties file
		prop = new Properties();
		
		// Create a FileInputStream object to stream the data.properties file
		FileInputStream input = new FileInputStream(System.getProperty("user.dir") + "//src/main/java/resources/data.properties");
				
		// Load the input from the streamed file
		prop.load(input);
		
		// Set the browser name from the browser property in the data.properties file
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		// Set the URL from the URL property in the data.properties file
		String url = prop.getProperty("url");
		System.out.println(url);
		
		if(browserName.equals("chrome")) {
			
			// Execute in ChromeDriver
			System.setProperty("webdriver.chrome.driver", "/Users/maria/Downloads/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")){
			
			// Execute in FirefoxDriver
			System.setProperty("webdriver.gecko.driver", "/Users/maria/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		return driver;
		
	}

}

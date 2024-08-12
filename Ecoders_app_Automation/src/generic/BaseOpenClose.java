package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public abstract class BaseOpenClose implements Constants
{
	// create a global WebDriver varaible. 
	public WebDriver driver; 
	
	
	// function to open the application.
	@BeforeMethod
	public  void openApplication()
	{
		// open the chrome browser. 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// open the web page
		driver.get(urlOfApplication);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	// function to close the application. 
	public void closeApplication()
	{
		driver.quit();
	}
}

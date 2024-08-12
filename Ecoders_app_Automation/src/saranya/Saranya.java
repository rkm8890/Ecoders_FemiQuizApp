package saranya;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Saranya {

	
	
	
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.gecko.driver","./softwares/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://login.yahoo.com/account/create");
			driver.manage().window().maximize();
			Thread.sleep(2000);		
			System.out.println("Successfully launched firefox");
			System.out.println("hello world from saranya");
		}
		

	}
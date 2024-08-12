package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenshotClass implements Constants {
    public static WebDriver driver;
    
    // Constructor to initialize WebDriver
    public ScreenshotClass(WebDriver driver) {
        this.driver = driver;
    }
    
    static String rootfolder = System.getProperty("user.dir");
    static String screeshotFolder = rootfolder+"//screenshots//";

    public static void getScreenshot() {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            
            // Create a timestamp for the screenshot file name
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File destFile = new File(screeshotFolder + "screenshot"+"_" + timestamp + ".png");
            
            // Create the screenshot folder if it does not exist
            File directory = new File(screeshotFolder);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            
            // Copy the screenshot to the destination file
            Files.copy(srcFile, destFile);
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

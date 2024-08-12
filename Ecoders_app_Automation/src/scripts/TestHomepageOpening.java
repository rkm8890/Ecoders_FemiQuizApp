package scripts;

import org.testng.annotations.Test;

import generic.BaseOpenClose;
import generic.ExcelCode;
import pom.Homepage;

public class TestHomepageOpening extends BaseOpenClose
{
	
	
    @Test
    public void openHomepage()
    {
    	Homepage hp = new Homepage(driver);
    	
    	// get thetitle from excelsheet. 
    	String expectedTitle = (String) ExcelCode.getData("Sheet1", 1, 1);
    	
    	// actual title 
    	String actualTitle = driver.getTitle();
    	
    	System.out.println(actualTitle);
    	
    	hp.verifyHomepageTitle(expectedTitle);
    }
    
    @Test
    public void openHomepage3()
    {
    	Homepage hp = new Homepage(driver);
    	
    	// get thetitle from excelsheet. 
    	String expectedTitle = (String) ExcelCode.getData("Sheet1", 1, 3);
    	
    	// actual title 
    	String actualTitle = driver.getTitle();
    	
    	System.out.println(actualTitle);
    	
    	hp.verifyHomepageTitle(expectedTitle);
    }
    
    @Test
    public void openHomepage2()
    {
    	Homepage hp = new Homepage(driver);
    	
    	// get thetitle from excelsheet. 
    	String expectedTitle = (String) ExcelCode.getData("Sheet1", 1, 6);
    	
    	// actual title 
    	String actualTitle = driver.getTitle();
    	
    	System.out.println(actualTitle);
    	
    	hp.verifyHomepageTitle(expectedTitle);
    }
}
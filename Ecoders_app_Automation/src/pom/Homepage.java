package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.Verification;

public class Homepage extends Verification 
{
	public Homepage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
 
	// find all the elements 
	@FindBy(xpath = "")
	private WebElement ecoders_logo;
	
	@FindBy(xpath = "")
	private WebElement aboutLink;
	
	@FindBy(xpath = "")
	private WebElement contactLink;
	
	@FindBy(xpath = "")
	private WebElement projectsDropdown;
	
	@FindBy(xpath = "")
	private WebElement examsDropdown;
	
	@FindBy(xpath = "")
	private WebElement coursesDropdown;
	
	@FindBy(xpath = "")
	private WebElement loginLink;
	
	@FindBy(xpath = "")
	private WebElement registerLink;
	
	@FindBy(xpath = "")
	private WebElement avatarDropDown;
	
	@FindBy(xpath = "")
	private WebElement profileLink;
	
	@FindBy(xpath = "")
	private WebElement settingsLink;
	
	@FindBy(xpath = "")
	private WebElement signOutLink;
	
	
	// functions to perform actions on elements. 
	public void clickOnLogo()
	{
		ecoders_logo.click();
	}
	
	public void verifyHomepageTitle(String exceptedTitle)
	{
		verifyTitle(exceptedTitle);
	}
}

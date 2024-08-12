package generic;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class Verification {
    public WebDriver driver; 
    private SoftAssert softAssert;
    
    public Verification(WebDriver driver) {
        this.driver = driver;
        this.softAssert = new SoftAssert();  // Initialize SoftAssert
    }

    // Verify Page Title using Explicit Wait
    public void verifyTitle(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.titleIs(expectedTitle));
            softAssert.assertTrue(true, "Title matched: " + expectedTitle);
        } catch(Exception ex) {
            ex.printStackTrace();
            Reporter.log("Test case failed, title didn't match");
            takeScreenshot("TitleMismatch");
            softAssert.fail("Expected title: " + expectedTitle + " but was different.");
        } finally {
            softAssert.assertAll();
        }
    }

    // Verify Element Presence using Explicit Wait
    public void verifyElementPresence(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            softAssert.assertTrue(element.isDisplayed(), "Element is present and visible.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Reporter.log("Test case failed, element not visible");
            takeScreenshot("ElementNotVisible");
            softAssert.fail("Element was expected to be visible but was not.");
        } finally {
            softAssert.assertAll();
        }
    }

    // Verify Element is Clickable using Explicit Wait
    public void verifyElementClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            softAssert.assertTrue(true, "Element is clickable.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Reporter.log("Test case failed, element not clickable");
            takeScreenshot("ElementNotClickable");
            softAssert.fail("Element was expected to be clickable but was not.");
        } finally {
            softAssert.assertAll();
        }
    }

    // Verify Text Presence using Fluent Wait
    public void verifyTextPresence(final WebElement element, final String expectedText) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return element.getText().contains(expectedText);
                }
            });
            softAssert.assertTrue(element.getText().contains(expectedText), "Text is present: " + expectedText);
        } catch(Exception ex) {
            ex.printStackTrace();
            Reporter.log("Test case failed, text not found in element");
            takeScreenshot("TextNotFound");
            softAssert.fail("Expected text: " + expectedText + " was not found.");
        } finally {
            softAssert.assertAll();
        }
    }

    // Verify Element is Enabled using Fluent Wait
    public void verifyElementEnabled(final WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return element.isEnabled();
                }
            });
            softAssert.assertTrue(element.isEnabled(), "Element is enabled.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Reporter.log("Test case failed, element is not enabled");
            takeScreenshot("ElementNotEnabled");
            softAssert.fail("Element was expected to be enabled but was not.");
        } finally {
            softAssert.assertAll();
        }
    }

    // Verify Element is Selected using Fluent Wait
    public void verifyElementSelected(final WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(new Function<WebDriver, Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return element.isSelected();
                }
            });
            softAssert.assertTrue(element.isSelected(), "Element is selected.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Reporter.log("Test case failed, element is not selected");
            takeScreenshot("ElementNotSelected");
            softAssert.fail("Element was expected to be selected but was not.");
        } finally {
            softAssert.assertAll();
        }
    }

    // Method to capture screenshot
    private void takeScreenshot(String reason) {
        ScreenshotClass sc = new ScreenshotClass(driver);
        ScreenshotClass.getScreenshot();  // Assuming getScreenshot method now saves with a timestamp
        Reporter.log("Screenshot taken due to: " + reason);
    }
}

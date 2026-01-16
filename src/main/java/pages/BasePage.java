package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;






    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    protected WebElement waitVisible(By locator) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected  WebElement click(By locator) {
      return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    protected void scrollAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }



























}

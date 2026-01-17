package test;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.time.Duration;


public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeClass

    public static void beforeClass() throws Exception {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }


    @AfterClass
    public static void afterClass() throws Exception {
        driver.quit();
    }

    @Before
    public void setUp() throws Exception {
        driver.manage().deleteAllCookies();
        driver.get("https://www.thalia.at/");
        acceptCookiesIfPresent();
    }
    //Rijesenje za iframe- obavezno zapamtiti!!
    private void acceptCookiesIfPresent() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            shortWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fast-cmp-iframe")));
            shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(.,'Alle akzeptieren') or contains(.,'Accept')]")
            )).click();
        } catch (Exception ignored) {
            // ništa, nastavi dalje
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    @After

    public void tearDown(){
        driver.manage().deleteAllCookies();
    }


















}

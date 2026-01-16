package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;

import static org.junit.Assert.assertTrue;

public class HomePageTest extends BaseTest{


     @Test
     public void homePageTest() {
         HomePage home = new HomePage(driver);    //HomePage treba driver da bi otvorio url,nasao elemente

         home.open().searchFor("Harry Potter");

         assertTrue(driver.getCurrentUrl().contains("search"));

     }












 }
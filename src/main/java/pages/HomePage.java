package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage open() {
        navigateTo("https://www.thalia.at/");
        return this;
    }


    private By searchInput = By.xpath("//input[@type=\"search\"]");

    //Lokator za lupu:
    private By searchButton = By.xpath("/button[@type=\"submit\"]");
    //Lokator za korpu
    private By cartButton = By.xpath("//span[normalize-space()='Warenkorb']");

    //metoda za pretragu

    public HomePage searchFor(String text) {
        waitVisible(searchInput).sendKeys(text);
        click(searchButton);
        return this;
    }
    //Metoda za ovaranje Cart stranice i ostajemo na njoj
    //public CartPage openCard() {
     //  click(cartButton) ;
      // return  new CartPage();

   // }






















}

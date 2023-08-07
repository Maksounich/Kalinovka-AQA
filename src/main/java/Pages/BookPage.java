package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookPage extends BasePage{
    public BookPage(WebDriver driver){super(driver);}

   private By buyBtn = By.xpath("//a[text() = \"Купити\"]");

    public BasketPage clickBuy()
    {
        driver.findElement(buyBtn).click();

        return new BasketPage(driver);
    }
}

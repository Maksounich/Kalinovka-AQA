package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BookPage extends BasePage{
    public BookPage(WebDriver driver){super(driver);}

   private By buyBtn = By.xpath("//a[text() = \"Купити\"]");

    public BasketPage clickBuy()
    {
        waitElemClickable(driver.findElement(buyBtn));
        driver.findElement(buyBtn).click();

        return new BasketPage(driver);
    }

    public BookPage assertBookUrl()
    {
        String correctUrl = "https://book-ye.com.ua/catalog/zarubizhna-klasyka/1984/?q=1984";
        Assert.assertEquals(driver.getCurrentUrl(), correctUrl);
        return new BookPage(driver);
    }
}

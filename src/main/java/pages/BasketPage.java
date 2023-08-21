package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasketPage extends BasePage {
    public BasketPage(WebDriver driver){super(driver);}

    public By basketWindow = By.xpath("//span[@class=\"om-popup-close-x\"]");
    public By spinWindow = By.xpath("//span[@class=\"om-popup-close-x\"]");

    public By checkBook(String name)
    {
        By nameBook = By.xpath("//td/a[text() ='" + name + "']");
        return nameBook;
    }

    public WebElement windowBasket()
    {
        return driver.findElement(basketWindow);
    }

    public BasketPage assertCheckBasket(String name)
    {
        waitElemVisibility(By.xpath("//td/a[text() = '1984']"));
        Assert.assertTrue(driver.findElement(checkBook("1984")).isDisplayed());

        return new BasketPage(driver);
    }
}

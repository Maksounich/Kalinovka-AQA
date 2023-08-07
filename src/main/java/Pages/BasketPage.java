package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage{
    public BasketPage(WebDriver driver){super(driver);}

    public WebElement checkBook(String name)
    {
        return driver.findElement(By.xpath("//td/a[text() ='" + name + "']"));
    }
}

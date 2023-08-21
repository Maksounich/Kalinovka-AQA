package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WishListPage extends BasePage{
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public WishListPage assertCheckUrl(String url)
    {
        Assert.assertEquals(driver.getCurrentUrl(), url);

        return new WishListPage(driver);
    }
}

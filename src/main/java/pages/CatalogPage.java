package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CatalogPage extends BasePage{
    public CatalogPage(WebDriver driver){super(driver);}

    public CatalogPage assertCatalogUrl(String url)
    {
        Assert.assertEquals(driver.getCurrentUrl(), url);

        return new CatalogPage(driver);
    }
}

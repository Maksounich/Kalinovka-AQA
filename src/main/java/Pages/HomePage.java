package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){super(driver);}

    private By logo = By.xpath("//a[@class=\"header__logo-link\"]");
    private By catalogBtn = By.xpath("//div[@class=\"header__catalog-wrap\"]");
    private By searchField = By.xpath("//input[@name = 'q']");
    private By basketBtn = By.xpath("//a[contains(@class , \"header-bottom__basket\")]");
    private By wishlistBtn = By.xpath("//a[contains(@class , \"header-bottom__favorites\")]");
    private By loginBtn = By.xpath("//a[contains(@class , \"header-bottom__login\")]");
    private By usernameField = By.xpath("//input[@name=\"USER_LOGIN\"]");
    private By userpasswordField = By.xpath("//input[@name=\"USER_PASSWORD\"]");
    private By loginSubmitBtn = By.xpath("//input[@value=\"Увійти\"]");
    private By mainSearchField = By.xpath("//input[@id=\"q\"]");

    public HomePage clickLogo()
    {
        driver.findElement(logo).click();
        return new HomePage(driver);
    }
    public HomePage clickCatalog()
    {
        driver.findElement(catalogBtn).click();
        return new HomePage(driver);
    }
    public HomePage clickBasket()
    {
        driver.findElement(basketBtn).click();
        return new HomePage(driver);
    }
    public HomePage clickWishlist()
    {
        driver.findElement(wishlistBtn).click();
        return new HomePage(driver);
    }
    public HomePage clickLogin()
    {
        driver.findElement(loginBtn).click();
        return new HomePage(driver);
    }




    public BookPage findBook(String name)
    {
        driver.findElement(searchField).click();
        driver.findElement(mainSearchField).sendKeys(name);
        driver.findElement(By.xpath("//span[text() = '" + name + "']")).click();

        return new BookPage(driver);
    }
    public HomePage login(String name, String password)
    {
       clickLogin();
       driver.findElement(usernameField).sendKeys(name);
       driver.findElement(userpasswordField).sendKeys(password);
       driver.findElement(loginSubmitBtn).click();

       return new HomePage(driver);
    }

    public CatalogPage catalogChoose(String name)
    {
        driver.findElement(catalogBtn).click();
        driver.findElement(By.xpath("//a[contains(text(), '" + name + "')]")).click();
        
        return new CatalogPage(driver);
    }
}

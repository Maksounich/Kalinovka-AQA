import Pages.BasketPage;
import Pages.BookPage;
import Pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookYeTest extends TestInit{

    @Test
    public void findBookTest()
    {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        homePage.findBook("1984");
    }
    @Test
    public void loginTest()
    {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        homePage.login("380668768217","12345679");
    }

    @Test
    public void catalogTest()
    {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.catalogChoose("Дитяча література");
    }

    @Test
    public void basketTest()
    {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        BookPage bookPage = new BookPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        homePage.findBook("1984");
        js.executeScript("window.scrollBy(0, 300)");
        bookPage.clickBuy();
        try {
            Thread.sleep(1000);
            Assert.assertTrue(basketPage.checkBook("1984").isDisplayed());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void wishlistBtn()
    {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Assert.assertEquals(driver.getCurrentUrl(), "https://book-ye.com.ua/personal/wishlist/");
    }
    @Test
    public void logoTest()
    {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);

        homePage.clickWishlist();
        homePage.clickLogo();

        Assert.assertEquals(driver.getCurrentUrl(), "https://book-ye.com.ua/");
    }
}

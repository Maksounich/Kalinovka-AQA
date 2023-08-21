import pages.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class BookYeTest extends TestInit{

    @Test
    public void findBookTest()
    {
        HomePage homePage = new HomePage(driver);
        BookPage bookPage = new BookPage(driver);

        homePage.clickSearchField();
        homePage.findBook("1984");

        bookPage.assertBookUrl();


    }
    @Test
    public void loginTest()
    {
        HomePage homePage = new HomePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        homePage.login("380668768217","12345679");

        homePage.assertLoginCheck();

    }

    @Test
    public void catalogTest()
    {
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        homePage.clickCatalog();
        homePage.catalogChoose("Дитяча література");

        catalogPage.assertCatalogUrl("https://book-ye.com.ua/catalog/dytyacha-literatura/");
    }

    @Test
    public void basketTest()
    {
        HomePage homePage = new HomePage(driver);
        BookPage bookPage = new BookPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        SpinPage spinPage = new SpinPage(driver);

        homePage.clickSearchField();
        homePage.findBook("1984");
        spinPage.closePage();
        js.executeScript("window.scrollBy(0, 300)");
        bookPage.clickBuy();

        //Assert
        basketPage.assertCheckBasket("1984");

    }

    @Test
    public void wishlistBtn()
    {
        HomePage homePage = new HomePage(driver);
        WishListPage wishListPage = new WishListPage(driver);

        homePage.clickWishlist();

        wishListPage.assertCheckUrl("https://book-ye.com.ua/personal/wishlist/");



    }
    @Test
    public void logoTest()
    {
        HomePage homePage = new HomePage(driver);

        homePage.clickWishlist();
        homePage.clickLogo();

        homePage.assertCheckUrl("https://book-ye.com.ua/");
    }

}

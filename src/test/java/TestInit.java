import catalog.CatalogPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import goods.GoodsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import login_reg.LoginRegPage;
import main_bar.MainBarPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import search.SearchPage;

import javax.crypto.SealedObject;

public class TestInit {
    MainBarPage mainBarPage = new MainBarPage();
    CatalogPage catalogPage = new CatalogPage();
    SearchPage searchPage = new SearchPage();
    GoodsPage goodsPage = new GoodsPage();
    LoginRegPage loginRegPage = new LoginRegPage();

    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @BeforeMethod
    public void startTest()
    {
        setup();

    }

    @AfterMethod
    public void quit()
    {
        Selenide.closeWebDriver();
    }
}

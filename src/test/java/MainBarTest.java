import base.BasePage;
import com.codeborne.selenide.Selenide;
import main_bar.MainBarPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static base.BasePage.getCurUrl;
import static constants.Const.BASE_URL;

public class MainBarTest extends TestInit {
    @Test
    public void subMenuTest()
    {
        Selenide.open(BASE_URL);
        String subMensBtn = "Повсякденні";

        mainBarPage.subMens(subMensBtn);

        String expextedUrl = "https://gpsocks.com/category/cholovichi/cholovichi-povsiakdenni/";
        Assert.assertEquals(getCurUrl(), expextedUrl );
    }
}

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

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

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.Test;

import static base.BasePage.getCurUrl;
import static constants.Const.BASE_URL;

public class SearchTest extends TestInit{
    @Test
    public void SearchSocks()
    {
        Selenide.open(BASE_URL);
        String nameSocks = "fishing";

        mainBarPage
                .clickSearchBtn()
                .searchSocks(nameSocks);
        searchPage.clickFirstSame();

        Assert.assertTrue(getCurUrl().contains(nameSocks));
    }

}

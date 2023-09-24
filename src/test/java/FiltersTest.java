import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Test;

import static constants.Const.BASE_URL;

public class FiltersTest extends TestInit{
    @Test
    public void someFiltrTest()
    {
        Selenide.open(BASE_URL);
        String size = "38";
        String color = "Білі";
        String season = "Зимові";

        mainBarPage.clickCatalog();
        catalogPage
                .chooseSize(size)
                .chooseColor(color)
                .chooseSeason(season)
                .clickFirstGood();

        Assert.assertTrue(goodsPage.currentSize(size).isDisplayed());
        Assert.assertTrue(goodsPage.currentColor(color).isDisplayed());
        Assert.assertTrue(goodsPage.currentSeasone(season).isDisplayed());
    }
    @Test
    public void colorFilterTest()
    {
        Selenide.open(BASE_URL);
        String color = "Білі";

        mainBarPage.clickCatalog();
        catalogPage.chooseColor(color);

        org.testng.Assert.assertEquals(catalogPage.getElemSize(), catalogPage.getColorSize(color));
    }
}

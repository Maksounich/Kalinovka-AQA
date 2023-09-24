import com.codeborne.selenide.Selenide;
import org.junit.Test;
import org.testng.Assert;

import static constants.Const.BASE_URL;

public class CatalogTest extends TestInit{
    @Test
    public void numberOfElemTest()
    {
        Selenide.open(BASE_URL);
        int numOfGoods = 9;

        mainBarPage.clickCatalog();

        Assert.assertEquals(numOfGoods, catalogPage.getElemSize());
    }
}

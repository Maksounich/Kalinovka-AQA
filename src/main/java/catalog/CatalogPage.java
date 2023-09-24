package catalog;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import goods.GoodsPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage extends BasePage {
    protected SelenideElement size = $x("//h4[text() = 'Розмір']");
    private SelenideElement season = $x("//h4[text() = \"Сезон\"]");
    private SelenideElement use = $x("//h4[text() = \"Призначення\"]");
    private SelenideElement height = $x("//h4[text() = \"Висота шкарпетки\"]");
    private SelenideElement color = $x("//h4[text() = \"Колір\"]");
    private SelenideElement price = $x("//h4[text() = \"Ціна\"]");
    private  SelenideElement nextPage = $x("//ul[@class=\"page-numbers\"]/li[9]");
    private List<SelenideElement> elements = $$x("//ul[@class=\"products columns-3\"]/li");
    private SelenideElement firstGood = $x("//ul[@class=\"products columns-3\"]/li[1]");

    //Вибір кольору
    public CatalogPage chooseColor(String color)
    {
        SelenideElement selectedColor = $x("//ul//li//a[@data-title = '" + color + "']");
        this.color.click();
        selectedColor.click();
        return this;
    }

    //Отримання кількості товарів з конкретним кольором
    public int getColorSize(String color)
    {
        List<SelenideElement> colorList = $$x("//li[1]/ul/li[@title='" + color + "']");
        return colorList.size();
    }

    //Отримання кількості товарів на сторінці
    public int getElemSize()
    {
       return elements.size();
    }

    public CatalogPage chooseSize(String size)
    {
        SelenideElement curSize = $x("//a[contains(text(), '" + size + "')]");
        this.size.click();
        curSize.click();
        return this;
    }
    public CatalogPage chooseSeason(String season)
    {
        SelenideElement curSeason = $x("//a[contains(text(), '" + season + "')]");
        this.season.click();
        curSeason.click();
        return this;
    }
    public GoodsPage clickFirstGood()
    {
        firstGood.click();
        return new GoodsPage();
    }


}

package goods;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GoodsPage extends BasePage {
    public SelenideElement currentSize(String size)
    {
        return $x("//li[contains(@data-wvstooltip, '" + size + "') and @tabindex = '0']");

    }

    public SelenideElement currentColor(String color)
    {
        return $x("//li[@data-wvstooltip='" + color + "' and @tabindex = '0']");
    }

    public SelenideElement currentSeasone(String season)
    {
        return $x("//a[text()= '" + season + "']");
    }
}

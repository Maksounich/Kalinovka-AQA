package search;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {
    private List<SelenideElement> elements = $$x("//ul[@class=\"products\"]/li");

    public SearchPage clickFirstSame()
    {
        elements.get(0).click();
        return this;
    }
}

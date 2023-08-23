package utilities;

import com.codeborne.selenide.*;;
import org.testng.Assert;

public class Assertions {
    public Assertions urlContains(String txt) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, PropertyReader.getProp("url") + txt);
        return this;
    }

    public Assertions assertText(SelenideElement element, String expected) {
        String txt = element.getText();
        Assert.assertEquals(txt, expected);
        return this;
    }

    public Assertions assertBtn(SelenideElement element) {
        Assert.assertTrue(element.isDisplayed());
        return this;
    }
}

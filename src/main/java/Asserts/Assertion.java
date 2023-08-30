package Asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Assertion {
    public Assertion assertText(WebElement element, String expected) {
        String txt = element.getText();
        Assert.assertEquals(txt, expected);
        return this;
    }

    public Assertion assertBtn(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
        return this;
    }
}

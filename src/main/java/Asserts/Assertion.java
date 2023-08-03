package Asserts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.AccountPage;

public class Assertion {
    public Assertion assertText(WebElement element, String expected) {
        String txt = element.getText();
        Assert.assertEquals(txt, expected);
        return this;
    }
}

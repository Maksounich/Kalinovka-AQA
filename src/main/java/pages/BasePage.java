package pages;

import driver.DriverPoll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(DriverPoll.getDriver(), Duration.ofSeconds(15));
        PageFactory.initElements(DriverPoll.getDriver(), this);
    }

    protected void setValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    protected void click(WebElement element) {
        element.click();
    }
}

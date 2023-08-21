package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SpinPage extends BasePage {
    public SpinPage(WebDriver driver) {
        super(driver);
    }

    By closeBtn = By.xpath("//div[@class=\"om-global-close-button om-popup-close\"]");

    public BookPage closePage()
    {
        waitElemVisibility(closeBtn);
        driver.findElement(closeBtn).click();

        return new BookPage(driver);
    }
}

package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected static WebDriver driver;

    public BasePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
    }


}

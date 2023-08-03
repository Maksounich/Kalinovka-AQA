package core;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(ContainerDrv.getDriver(), this);
    }

    public void click(WebElement element) {
        elementToBeClickable(element).click();
    }

    public void sendKeys(WebElement element, String value){
        elementToBeClickable(element).sendKeys(value);
    }

    public void selectByText(WebElement element, String text){
        visibilityOf(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public WebElement elementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ContainerDrv.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ContainerDrv.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

}

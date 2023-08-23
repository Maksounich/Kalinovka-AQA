package core;

import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {
    public void click(SelenideElement element){
        element.click();
    }

    public void sendKeys(SelenideElement element, String text){
        element.sendKeys(text);
    }

    public void selectByText(SelenideElement element, String text){
        element.selectOptionContainingText(text);
    }
}



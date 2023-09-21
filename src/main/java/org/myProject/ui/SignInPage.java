package org.myProject.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.myProject.api.pojo.ChangedPassword;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SignInPage extends Page {

    By emailField = By.id("login");
    By passwordField = By.id("password2");
    By signInBtn = By.id("accessToken");
    By eyeBtn = By.xpath("//i[contains(@class, 'eye')]");


    public SignInPage open() {
        Selenide.open("/login");
        return this;
    }

    public SignInPage setEmail(String value) {
        setValue($(emailField), value);
        return this;
    }


    public SignInPage setPassword(String value) {
        $$(eyeBtn).find(Condition.visible).click();
        setValue($(passwordField), value);
        return this;
    }

    public HomePage clickSignInBtn() {
        Selenide.open("https://www.kidstaff.com.ua/");
        $(signInBtn).click();
        return new HomePage();
    }
}

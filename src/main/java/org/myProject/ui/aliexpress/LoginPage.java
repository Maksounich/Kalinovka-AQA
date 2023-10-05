package org.myProject.ui.aliexpress;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends Page {

    By emailField = By.xpath("//input [@id= 'fm-login-id']");
    By passwordField = By.id("fm-login-password");
    By loginBtn = By.id("a2g0s.buyerloginandregister.0.i7.6eb555a3DgM3IT");


    public LoginPage open() {
        Selenide.open("https://login.aliexpress.com/");
        return this;
    }

    public LoginPage setEmail(String value) {
        setValue($(emailField), value);
        return this;
    }

    public LoginPage setPassword (String value) {
        setValue($(passwordField), value);
        return this;
    }

    public HomePage clickLoginBtn(){
        $(loginBtn).click();
        Selenide.open("https://www.aliexpress.com/");
        return new HomePage();
    }
}

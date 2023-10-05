package org.myProject.ui.aliexpress;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private By loginBtn = By.id("a2g0s.buyerloginandregister.0.i7.6eb555a3DgM3IT");

    public HomePage isPresent() {
        Assert.assertFalse($(loginBtn).exists());
        return this;
    }
}

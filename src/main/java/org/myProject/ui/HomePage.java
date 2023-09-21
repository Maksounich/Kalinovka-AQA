package org.myProject.ui;

import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends Page {

    private By signInBtn = By.id("accessToken");

    public HomePage isPresent() {
        Assert.assertFalse($(signInBtn).exists());
        return this;
    }
}

package ui;

import com.codeborne.selenide.SelenideElement;
import org.myProject.ui.Page;
import org.myProject.ui.SignInPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.element;


public class LoginTest extends BaseTest {


    @Test
    public void loginTest() {
        new SignInPage()
                .open()
                .setEmail("lili.korgik@gmail.com")
                .setPassword("Korgik123")
                .clickSignInBtn()
                .isPresent();
    }
}














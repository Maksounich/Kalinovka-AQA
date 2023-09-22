package ui.kidstaff;

import org.myProject.ui.SignInPage;

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














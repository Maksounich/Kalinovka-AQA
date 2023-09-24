package login_reg;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;
import profile.UserProfile;

import static com.codeborne.selenide.Selenide.$x;

public class LoginRegPage extends BasePage {

    //Login elements
    private SelenideElement usernameInput = $x("//input[@name='username']");
    private SelenideElement passwordLoginInput = $x("//input[@name='password']");
    private SelenideElement loginBtn = $x("//button[@name='login']");

    //Registration elements
    private SelenideElement emailInput = $x("//input[@name='email']");
    private SelenideElement firstNameInput = $x("//input[@name='billing_first_name']");
    private SelenideElement lastNameInput = $x("//input[@name='billing_last_name']");
    private SelenideElement numberInput = $x("//input[@name='billing_phone']");
    private SelenideElement registrBtn = $x("//button[@name='register']");

    //Login methods
    public UserProfile login(String userName, String password)
    {
        usernameInput.sendKeys(userName);
        passwordLoginInput.sendKeys(password);
        loginBtn.click();
        return new UserProfile();
    }
}

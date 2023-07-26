package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utiles.User;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@id='input_15']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='input_16']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitBtn;

    public HomePage login(User user) {
        setValue(email, user.getEmail());
        setValue(password, user.getPassword());
        click(submitBtn);
        return new HomePage();
    }
}

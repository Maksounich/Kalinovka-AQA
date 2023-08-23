package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.BasePage;
import java.time.Duration;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private final SelenideElement homeBtn = $x("//button[@ng-click=\"home()\"]");
    private final SelenideElement customerLoginBtn = $x("//button[@ng-click=\"customer()\"]");
    private final SelenideElement managerLoginBtn = $x("//button[@ng-click=\"manager()\"]");

    public SelenideElement getHomeBtn() {
        return homeBtn;
    }

    public SelenideElement getCustomerLoginBtn() {
        return customerLoginBtn;
    }

    public SelenideElement getManagerLoginBtn() {
        return managerLoginBtn;
    }

    public CustomerPage clickCustomerLogin() {
        click(customerLoginBtn.shouldBe(Condition.visible, Duration.ofSeconds(5)));
        return new CustomerPage();
    }

    public ManagerPage clickManagerLogin() {
        click(managerLoginBtn);
        return new ManagerPage();
    }

    public LoginPage goHome() {
        click(homeBtn);
        return this;
    }
}

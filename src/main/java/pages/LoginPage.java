package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@ng-click=\"home()\"]")
    private WebElement homeBtn;

    @FindBy(xpath = "//button[@ng-click=\"customer()\"]")
    private WebElement customerLoginBtn;

    @FindBy(xpath = "//button[@ng-click=\"manager()\"]")
    private WebElement managerLoginBtn;


    public CustomerPage clickCustomerLogin() {
        click(customerLoginBtn);
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

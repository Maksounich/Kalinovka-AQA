package pages;

import core.BasePage;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.Properties;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[@ng-click=\"home()\"]")
    private WebElement homeBtn;

    @FindBy(xpath = "//button[@ng-click=\"customer()\"]")
    private WebElement customerLoginBtn;

    @FindBy(xpath = "//button[@ng-click=\"manager()\"]")
    private WebElement managerLoginBtn;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public CustomerPage getCustomerLogin(){
        customerLoginBtn.click();
        return new CustomerPage();
    }

    public ManagerPage getManagerLogin(){
        managerLoginBtn.click();
        return new ManagerPage();
    }

    public LoginPage goHome(){
        homeBtn.click();
        return this;
    }

}

package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//button[@ng-click=\"transactions()\"]")
    private WebElement transactionBtn;

    @FindBy(xpath = "//button[@ng-click=\"deposit()\"]")
    private WebElement depositBtn;

    @FindBy(xpath = "//button[@ng-click=\"withdrawl()\"]")
    private WebElement withdrawlBtn;

    @FindBy(xpath = "//*[@ng-show=\"logout\"]")
    private WebElement logOutBtn;

    @FindBy(id = "accountSelect")
    private WebElement accountSelect;

    @FindBy(xpath = "//form[@ng-submit=\"deposit()\"]//input[@placeholder=\"amount\"]")
    private WebElement depositField;


    @FindBy(xpath = "//form[@ng-submit=\"withdrawl()\"]//input[@placeholder=\"amount\"]")
    private WebElement withdrawlField;

    @FindBy(xpath = "//button[@class=\"btn btn-default\"]")
    private WebElement confirmBtn;

    @FindBy(xpath = "//span[@class=\"error ng-binding\"]")
    private WebElement trxInfo;


    public AccountPage depositeAmount(String sum) {
        click(depositBtn);
        sendKeys(depositField, sum);
        click(confirmBtn);
        return this;
    }

    public AccountPage withdrawlAmount(String sum) {
        click(withdrawlBtn);
        sendKeys(withdrawlField, sum);
        click(confirmBtn);
        return this;
    }

    public AccountPage logOut() {
        click(logOutBtn);
        return this;
    }

    public AccountPage selectAccount(String accountValue) {
        selectByText(accountSelect, accountValue);
        return this;
    }

    public WebElement getTrxInfo() {
        return trxInfo;
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import core.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage extends BasePage {
    private final SelenideElement transactionBtn = $x("//button[@ng-click=\"transactions()\"]");
    private final SelenideElement depositBtn = $x("//button[@ng-click=\"deposit()\"]");
    private final SelenideElement withdrawlBtn = $x("//button[@ng-click=\"withdrawl()\"]");
    private final SelenideElement logOutBtn = $x("//*[@ng-show=\"logout\"]");
    private final SelenideElement accountSelect = $(By.id("accountSelect"));
    private final SelenideElement depositField = $x("//form[@ng-submit=\"deposit()\"]//input[@placeholder=\"amount\"]");
    private final SelenideElement withdrawlField = $x("//form[@ng-submit=\"withdrawl()\"]//input[@placeholder=\"amount\"]");
    private final SelenideElement confirmBtn = $x("//button[@class=\"btn btn-default\"]");
    private final SelenideElement trxInfo = $x("//span[@class=\"error ng-binding\"]");


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

    public SelenideElement getTrxInfo() {
        return trxInfo;
    }
}

package pages;

import core.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

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

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    public AccountPage depositeAmount(String sum){
        depositBtn.click();
        depositField.sendKeys(sum);
        confirmBtn.click();
        return this;
    }

    public AccountPage withdrawlAmount(String sum){
        withdrawlBtn.click();
        withdrawlField.sendKeys(sum);
        confirmBtn.click();
        return this;
    }

    public AccountPage logOut(){
        logOutBtn.click();
        return this;
    }

    public AccountPage selectAccount(String accountValue) {
        Select select = new Select(accountSelect);
        select.selectByVisibleText(accountValue);
        accountSelect.click();
        return this;
    }

    public AccountPage assertWithdrawlTrx(){
        String trxInfoTxt = trxInfo.getText();
        Assert.assertEquals(trxInfoTxt,"Transaction successful", "no trx");
        return this;
    }

    public AccountPage assertDepositTrx(){
        String trxInfoTxt = trxInfo.getText();
        Assert.assertEquals(trxInfoTxt,"Deposit Successful","no deposit");
        return this;
    }



}

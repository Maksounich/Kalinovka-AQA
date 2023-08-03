package pages;

import core.BasePage;
import core.ContainerDrv;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ManagerPage extends BasePage {

    @FindBy(xpath = "//button[@ng-click=\"addCust()\"]")
    private WebElement addCustBtn;
    @FindBy(xpath = "//button[@ng-click=\"openAccount()\"]")
    private WebElement openAccountBtn;
    @FindBy(xpath = "//button[@ng-click=\"showCust()\"]")
    private WebElement showCustBtn;
    @FindBy(xpath = "//input[@ng-model=\"fName\"]")
    private WebElement fNameField;
    @FindBy(xpath = "//input[@ng-model=\"lName\"]")
    private WebElement lNameField;
    @FindBy(xpath = "//input[@ng-model=\"postCd\"]")
    private WebElement postCodeField;
    @FindBy(xpath = "//button[@class=\"btn btn-default\"][contains(text(),\"Add Customer\")]")
    private WebElement addCustConfirmBtn;
    @FindBy(id = "userSelect")
    private WebElement userSelect;
    @FindBy(id = "currency")
    private WebElement currencySelect;
    @FindBy(xpath = "//button[contains(text(),\"Process\")]")
    private WebElement processBtn;

    public ManagerPage addCustomer(String fName, String lName, String postCode) {
        click(addCustBtn);
        sendKeys(fNameField,fName);
        sendKeys(lNameField,lName);
        sendKeys(postCodeField,postCode);
        click(addCustConfirmBtn);
        ContainerDrv.getDriver().switchTo().alert().accept();
        return this;
    }

    public ManagerPage clickOpenAccount() {
        click(openAccountBtn);
        return this;
    }

    public ManagerPage selectUser(String userValue) {
        selectByText(userSelect,userValue);
        return this;
    }

    public ManagerPage selectCurrency(String currency) {
        selectByText(currencySelect,currency);
        return this;
    }

    public ManagerPage clickProcess() {
        click(processBtn);
        ContainerDrv.getDriver().switchTo().alert().accept();
        return this;
    }


}

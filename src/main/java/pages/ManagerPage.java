package pages;
;
import com.codeborne.selenide.SelenideElement;
import core.BasePage;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ManagerPage extends BasePage {

    private final SelenideElement addCustBTN = $x("//button[@ng-click=\"addCust()\"]");
    private final SelenideElement openAccountBTN = $x("//button[@ng-click=\"openAccount()\"]");
    private final SelenideElement showCustomersBTN = $x("//button[@ng-click=\"showCust()\"]");
    private final SelenideElement custBTN = $x("//button[@ng-click=\"showCust()\"]");
    private final SelenideElement fNameField = $x("//input[@ng-model=\"fName\"]");
    private final SelenideElement lNameField = $x("//input[@ng-model=\"lName\"]");
    private final SelenideElement postCodeField = $x("//input[@ng-model=\"postCd\"]");
    private final SelenideElement addCustConfirmBtn = $x("//button[@class=\"btn btn-default\"][contains(text(),\"Add Customer\")]");
    private final SelenideElement userSelect = $(By.id("userSelect"));
    private final SelenideElement currencySelect = $(By.id("currency"));
    private final SelenideElement processBtn = $x("//button[contains(text(),\"Process\")]");
    private final SelenideElement searchCustomerField = $x("//input[@ng-model=\"searchCustomer\"]");
    private final SelenideElement deleteBtn = $x("//button[@ng-click=\"deleteCust(cust)\"]");

    public ManagerPage addCustomer(String fName, String lName, String postCode) {
        click(addCustBTN);
        sendKeys(fNameField, fName);
        sendKeys(lNameField, lName);
        sendKeys(postCodeField, postCode);
        click(addCustConfirmBtn);
        return this;
    }

    public ManagerPage clickOpenAccount() {
        click(openAccountBTN);
        return this;
    }

    public ManagerPage selectUser(String userValue) {
        selectByText(userSelect, userValue);
        return this;
    }

    public ManagerPage selectCurrency(String currency) {
        selectByText(currencySelect, currency);
        return this;
    }

    public ManagerPage clickProcess() {
        click(processBtn);
        return this;
    }

    public ManagerPage clickCustomers() {
        click(showCustomersBTN);
        return this;
    }

    public ManagerPage searchCustomer(String user) {
        sendKeys(searchCustomerField, user);
        return this;
    }

    public SelenideElement getDeleteBtn() {
        return deleteBtn;
    }

    public ManagerPage clickCustBTN(){
        click(custBTN);
        return this;
    }

}

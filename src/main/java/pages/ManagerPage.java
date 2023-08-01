package pages;

import core.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.Watchable;

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

    public ManagerPage() {
        PageFactory.initElements(driver,this);
    }

    public ManagerPage addCustomer(String fName,String lName,String postCode){
        addCustBtn.click();
        fNameField.sendKeys(fName);
        lNameField.sendKeys(lName);
        postCodeField.sendKeys(postCode);
        addCustConfirmBtn.click();
        driver.switchTo().alert().accept();
        return this;
    }

    public ManagerPage clickOpenAccount(){
        openAccountBtn.click();
        return this;
    }

    public ManagerPage selectUser(String userValue) {
        Select select = new Select(userSelect);
        select.selectByVisibleText(userValue);
        return this;
    }

    public ManagerPage selectCurrency(String currency){
        Select select = new Select(currencySelect);
        select.selectByVisibleText(currency);
        return this;
    }

    public ManagerPage clickProcess(){
        processBtn.click();
        driver.switchTo().alert().accept();
        return this;
    }


}

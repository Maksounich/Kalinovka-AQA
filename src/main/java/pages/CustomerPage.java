package pages;

import com.codeborne.selenide.SelenideElement;
import core.BasePage;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CustomerPage extends BasePage {
    private final SelenideElement userSelect = $(By.id("userSelect"));
    private final SelenideElement loginBtn = $x("//button[contains(text(),\"Login\")]");

    public SelenideElement getUserSelectBtn(){
        return userSelect;
    }
    public AccountPage selectUser(String userName) {
        selectByText(userSelect, userName);
        click(loginBtn);
        return new AccountPage();
    }
}

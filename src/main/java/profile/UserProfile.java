package profile;

import base.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class UserProfile extends BasePage {
    private SelenideElement myProfiletxt = $x("//h1[contains(text(), 'Мій профіль')]");

    public SelenideElement getMyProfiletxt()
    {
        return myProfiletxt;
    }
}

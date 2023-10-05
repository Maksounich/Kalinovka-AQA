package org.myProject.ui.aliexpress;

import com.codeborne.selenide.SelenideElement;

public class Page {

    protected void setValue(SelenideElement element, String value) {
        element.setValue(value);
    }

}

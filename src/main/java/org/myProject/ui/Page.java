package org.myProject.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public abstract class Page {

    protected void setValue(SelenideElement element, String value) {
        element.setValue(value);
    }

}

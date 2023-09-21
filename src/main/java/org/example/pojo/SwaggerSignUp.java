package org.example.pojo;

import org.example.utils.PropertiesConfig;

import java.util.Properties;

import static io.restassured.internal.common.assertion.AssertionSupport.properties;

public class SwaggerSignUp {
    private String username = System.currentTimeMillis() + "$";
    private String password = PropertiesConfig.password;
    private String confirm_password = PropertiesConfig.confirm_password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

}

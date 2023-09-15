package org.example.pojo;

import java.util.Properties;

import static io.restassured.internal.common.assertion.AssertionSupport.properties;

public class SwaggerSignUp {
//прописать properties
    private String username = new Properties().getProperty("username");
    private String password = new Properties().getProperty("password");
    private String confirm_password = new Properties().getProperty("confirm_password");

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

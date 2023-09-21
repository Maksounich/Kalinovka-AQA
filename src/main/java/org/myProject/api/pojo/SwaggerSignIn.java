package org.example.pojo;

import org.example.utils.PropertiesConfig;

public class SwaggerSignIn {
    private String username;
    private String password = PropertiesConfig.password;

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
}
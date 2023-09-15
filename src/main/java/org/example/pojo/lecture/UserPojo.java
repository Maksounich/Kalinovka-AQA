package org.example.pojo.lecture;

import lombok.Data;

@Data
public class UserPojo {
    private String username = "Lily" + System.currentTimeMillis();
    private String password = "12345568788";
    private String confirm_password ="12345568788";

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

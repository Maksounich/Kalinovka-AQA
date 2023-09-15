package org.example.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ChangedPassword {
    // @JsonFormat(pattern = "new_password")
     String username;
     String password;
     String new_password = "127849372";
     String confirm_new_password = "127849372";

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

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getConfirm_new_password() {
        return confirm_new_password;
    }

    public void setConfirm_new_password(String confirm_new_password) {
        this.confirm_new_password = confirm_new_password;
    }
}

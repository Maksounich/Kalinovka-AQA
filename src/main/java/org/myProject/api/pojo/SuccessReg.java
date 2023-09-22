package org.myProject.api.pojo;

import lombok.Data;

@Data
public class SuccessReg {
    private int id;
    private String token;

    public int getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

}

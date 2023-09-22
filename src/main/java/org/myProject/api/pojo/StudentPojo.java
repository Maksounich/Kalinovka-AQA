package org.myProject.api.pojo;

import org.myProject.api.utils.PropertiesConfig;

public class StudentPojo {
    private String name = "Student №" + System.currentTimeMillis();
    private String email = System.currentTimeMillis() + "@gmail.com";
    private String office = PropertiesConfig.office;
    private String mentor = PropertiesConfig.mentor;
    private String signed_up = PropertiesConfig.signed_up;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public String getSigned_up() {
        return signed_up;
    }

    public void setSigned_up(String signed_up) {
        this.signed_up = signed_up;
    }
}

package org.example.pojo;

public class StudentPojo {
    private String name = "Student №" + System.currentTimeMillis();
    private String email = System.currentTimeMillis() + "@gmail.com";
    private String office = "Slovensko";
    private String mentor = "Human";
    private String signed_up = "2023-09-12T07:39:10.620Z";

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

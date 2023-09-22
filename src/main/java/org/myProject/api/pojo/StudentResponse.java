package org.myProject.api.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentResponse {
    public String name;
    public String email;
    public String office;
    public String mentor;
    public Date signed_up;
    public int study_time;
    public int id;
    public Date created_at;
    public Date updated_at;

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

    public Date getSigned_up() {
        return signed_up;
    }

    public void setSigned_up(Date signed_up) {
        this.signed_up = signed_up;
    }

    public int getStudy_time() {
        return study_time;
    }

    public void setStudy_time(int study_time) {
        this.study_time = study_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}

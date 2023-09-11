package user;

import java.util.Date;

public class UpdatedUser {
    private String name;
    private String job;
    private Date updatedAt;

    public UpdatedUser(){}

    public UpdatedUser(String name, String job, Date updatedAt) {
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}

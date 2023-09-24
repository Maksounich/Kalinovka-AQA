package person;

import java.util.Date;

public class PatchUpdate {
    private String name;
    private String job;
    private Date updatedAt;

    public PatchUpdate(String name, String job, Date updatedAt) {
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

package users;

import java.util.Date;

public class UserCreate {
    private String name;
    private String job;
    private String id;
    private Date createdAt;

    public UserCreate() {}

    public UserCreate(String name, String job, String id, Date createdAt) {
        this.name = name;
        this.job = job;
        this.id = id;
        this.createdAt = createdAt;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}

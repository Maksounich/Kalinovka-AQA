package register;

public class RegisterSuccess {
    private Integer id;
    private String token;

    public RegisterSuccess() {}

    public RegisterSuccess(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}

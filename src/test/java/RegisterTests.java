import org.example.pojo.SwaggerSignUp;
import org.example.pojo.service.AuthService;
import org.testng.annotations.Test;

import java.util.Properties;

public class RegisterTests  extends BaseTest{

    @Test
    public void checkHappyRegister() {
        SwaggerSignUp user = new SwaggerSignUp();

        AuthService.register(user, 201);

        //TODO connect to DB and check register user
    }


    @Test
    public void checkRegister() {
        SwaggerSignUp user = new SwaggerSignUp();
        user.setUsername("");

        AuthService.register(user, 400);
    }
}

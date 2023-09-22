package api;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.myProject.api.pojo.BaseRequest;
import org.myProject.api.pojo.SwaggerSignIn;
import org.myProject.api.pojo.SwaggerSignUp;
import org.myProject.api.pojo.service.AuthService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private SwaggerSignUp swaggerSignUp;

    @BeforeMethod
    public void reg() {
        swaggerSignUp = new SwaggerSignUp();
        AuthService.register(swaggerSignUp, 201);
    }

    @Test
    public void checkToken() {
        SwaggerSignIn user = new SwaggerSignIn();
        user.setUsername(swaggerSignUp.getUsername());

        String token = AuthService.login(user);

        Assertions.assertThat(token.length()).isEqualTo(121);
    }

    @Test
    public void checkHappyToken() {
        SwaggerSignIn user = new SwaggerSignIn();

        String token = AuthService.login(user);

        Response response = BaseRequest.getReq(token, "/students");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
}

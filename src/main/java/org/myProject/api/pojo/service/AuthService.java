package org.myProject.api.pojo.service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.myProject.api.pojo.SwaggerSignIn;
import org.myProject.api.pojo.SwaggerSignUp;
import org.myProject.api.pojo.Token;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.myProject.api.pojo.BaseRequest.postReg;


public class AuthService {

    private static final Map<Long, String> tokens = new ConcurrentHashMap<>();


    public static String getToken() {
        String token = tokens.get(Thread.currentThread().getId());
        if (Optional.ofNullable(token).isPresent())
            return token;

        SwaggerSignUp user = new SwaggerSignUp();
        SwaggerSignIn userLogin = new SwaggerSignIn();
        userLogin.setUsername(user.getUsername());
        userLogin.setPassword(user.getPassword());

        register(user, 201);
        tokens.put(Thread.currentThread().getId(), login(userLogin));

        return tokens.get(Thread.currentThread().getId());
    }

    @Step("registration {0}")
    public static void register(Object user, int status) {
        Response response = postReg(user, "/sign-up");

        assertThat(response.getStatusCode()).isEqualTo(status);
    }
    @Step("login {0}")
    public static String login(Object userLogin) {
        Response response = postReg(userLogin, "/sign-in");

        assertThat(response.getStatusCode()).isEqualTo(200);

        return response.as(Token.class).getAccess_token();
    }
}



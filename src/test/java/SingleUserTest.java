import org.junit.Assert;
import org.junit.Test;
import specifications.Specifications;
import users_data.SingleUserData;

import static io.restassured.RestAssured.given;

public class SingleUserTest {
    private static final String URL = "https://reqres.in";

    @Test
    public void getSingleUserData()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(200));

        SingleUserData user = given()
                .when()
                .get("/api/users/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", SingleUserData.class);
        System.out.println(user.getEmail());
    }

    @Test
    public void SingleUserNotFound()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpec(404));

        SingleUserData user = given()
                .when()
                .get("/api/users/23")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", SingleUserData.class);

        Assert.assertNull(user);
    }
}

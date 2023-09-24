import org.junit.Test;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class UserDelete {
    private static final String URL = "https://reqres.in";
    @Test
    public void deleteUserTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(204));

        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
    }
}

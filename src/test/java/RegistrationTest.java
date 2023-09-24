import org.junit.Assert;
import org.junit.Test;
import registration.Register;
import registration.SuccessReg;
import registration.UnSuccessedReg;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class RegistrationTest {
    private static final String URL = "https://reqres.in";
    @Test
    public void successedRegTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(200));

        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);

        String token = "QpwL5tke4Pnpja7X4";
        Integer id = 4;

        Assert.assertEquals(successReg.getToken(), token);
        Assert.assertEquals(successReg.getId(), id);
    }

    @Test
    public void unSuccessedReg()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(400));

        Register user = new Register("eve.holt@reqres.in", "");

        UnSuccessedReg unSuccessedReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(UnSuccessedReg.class);

        String expError = "Missing password";
        Assert.assertEquals(expError, unSuccessedReg.getError());
    }
}

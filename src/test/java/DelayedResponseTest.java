import org.junit.Assert;
import org.junit.Test;
import specifications.Specifications;
import users_data.UsersData;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class DelayedResponseTest {
    private final static String URL = "https://reqres.in";

    @Test
    public void delayResponseTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.delayResponseSpec());

        List<UsersData> users = given()
            .when()
            .get("/api/users?delay=3")
            .then().log().all()
            .extract().body().jsonPath().getList("data", UsersData.class);

        List<String> avatars = users.stream().map(UsersData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

        for(int i =0;i<avatars.size();i++)
        {
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }

    }
}

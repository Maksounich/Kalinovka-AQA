import org.testng.Assert;
import org.testng.annotations.Test;
import users.ListUsersData;
import users.SingleUser;
import utils.Specifications;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class UsersTests {
    private final String URL = "https://reqres.in/";

    @Test
    public void listUsersTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        List<ListUsersData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ListUsersData.class);
        users.forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        // The second method assertion:
        List<String> avatars = users.stream().map(ListUsersData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
        for(int i = 0; i < avatars.size(); i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void singleUserTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL),Specifications.responseSpec(200));
        SingleUser user = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", SingleUser.class);
        Assert.assertEquals(user.getId(),2);
        Assert.assertEquals(user.getFirst_name(),"Janet");
    }

    @Test
    public void userNotFoundTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(404));
        SingleUser user = given()
                .when()
                .get("api/users/23")
                .then().log().all()
                .extract().as(SingleUser.class);
        Assert.assertNull(user.getFirst_name(),user.getLast_name());
        Assert.assertNull(user.getId(), user.getAvatar());
        Assert.assertNull(user.getEmail());
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;
import users.UpdatedUser;
import users.User;
import users.UserCreate;
import utils.Specifications;
import static io.restassured.RestAssured.given;

public class OneUserTests {
    private final String URL = "https://reqres.in/";

    @Test
    public void createUser() {
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(201));
        User user = new User("morpheus","leader");
        UserCreate user1 = given()
                .body(user)
                .when()
                .post("api/users")
                .then().log().all()
                .extract().as(UserCreate.class);
        Assert.assertEquals(user1.getName(),"morpheus");
        Assert.assertEquals(user1.getJob(),"leader");
    }

    @Test
    public void putUpdateUser() {
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(200));
        User updateUser = new User("morpheus","zion resident");
        UpdatedUser user2 = given()
                .body(updateUser)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UpdatedUser.class);
        Assert.assertEquals(user2.getName(),"morpheus");
        Assert.assertEquals(user2.getJob(),"zion resident");
    }

    @Test
    public void patchUpdateUser() {
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(200));
        User updateUser = new User("morpheus","zion resident");
        UpdatedUser user2 = given()
                .body(updateUser)
                .when()
                .patch("api/users/5")
                .then().log().all()
                .extract().as(UpdatedUser.class);
        Assert.assertEquals(user2.getName(),"morpheus");
        Assert.assertEquals(user2.getJob(),"zion resident");
    }

    @Test
    public void deleteUser(){
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(204));
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then().log().all();
    }
}

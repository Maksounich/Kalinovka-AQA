import org.junit.Assert;
import org.junit.Test;
import person.Create;
import person.Person;
import person.Update;
import specifications.Specifications;

import static io.restassured.RestAssured.given;

public class PersonInfActionsTest {
    private static final String URL = "https://reqres.in";
    @Test
    public void createPersonTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(201));

        Person person = new Person("morpheus", "leader");

        Create newPerson = given()
                .body(person)
                .when()
                .post("/api/users")
                .then().log().all()
                .extract().as(Create.class);

        System.out.println(newPerson.getCreatedAt() + newPerson.getId() + newPerson.getJob() + newPerson.getName());

        Assert.assertEquals(newPerson.getName(), "morpheus");
        Assert.assertEquals(newPerson.getJob(), "leader");
    }

    @Test
    public void updatePersonTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(200));

        Person person = new Person("morpheus", "zion rezident");

        Update newPerson = given()
                .body(person)
                .when()
                .put("/api/users/2")
                .then().log().all()
                .extract().as(Update.class);

        Assert.assertEquals(newPerson.getJob(), "zion rezident");
        Assert.assertEquals(newPerson.getName(), "morpheus");
    }
}

import org.junit.Assert;
import org.junit.Test;
import resuorces_data.ResourcesData;
import specifications.Specifications;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ListResourcesTest {
    private static final String URL = "https://reqres.in";
    @Test
    public void listResourcesTest()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(200));

        List<ResourcesData> resources = given()
                .when()
                .get("/api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ResourcesData.class);

        List<Integer> ids = resources.stream().map(x->x.getId()).collect(Collectors.toList());
        List<Integer> years = resources.stream().map(x->x.getYear()).collect(Collectors.toList());

        for(int i = 0; i < resources.size(); i++)
        {
            Assert.assertTrue(years.get(i) - 1999 == ids.get(i));
        }
    }
}

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.*;
import utils.Specifications;
import java.util.List;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.given;

public class ResourceTests {
    private final String URL = "https://reqres.in/";

    @Test
    public void listResourceTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(200));
        List<Resource> resource = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", Resource.class);
        List<Integer> years = resource.stream().map(Resource::getYear).collect(Collectors.toList());
        List<Integer> sortYears = years.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(years, sortYears);
        System.out.println(years);
        System.out.println(sortYears);
    }

    @Test
    public void singleResourceTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(200));
        Resource resource = given()
                .when()
                .get("api/unknown/2")
                .then().log().all()
                .extract().body().jsonPath().getObject("data", Resource.class);
        Assert.assertEquals(resource.getYear(),2001);
        Assert.assertEquals(resource.getId(),2);
        Assert.assertEquals(resource.getPantone_value(),"17-2031");
    }

    @Test
    public void singleResourceNotFoundTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(404));
        Resource resource = given()
                .when()
                .get("api/unknown/23")
                .then().log().all()
                .extract().as(Resource.class);
        Assert.assertNull(resource.getYear());
        Assert.assertNull(resource.getId());
        Assert.assertNull(resource.getPantone_value());
    }
}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.pojo.service.StudentService;
import org.example.pojo.*;
import org.example.specifications.Specifications;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.example.pojo.service.StudentService.createStudent;
import static org.example.pojo.service.StudentService.getStudents;
import static org.example.pojo.BaseRequest.postReg;
import static org.example.pojo.BaseRequest.putChange;


public class RestTest {
    //array list for deleted users
    private final static List<String> usersForDelete = new ArrayList<>();

    private final static String URL = "https://reqres.in";

    @BeforeSuite
    public void beforeTEst() {
        RestAssured.baseURI = "http://192.168.68.233:4069/api/v1";
    }

    //method to delete users
    @AfterSuite
    public void deleteUsers() {
        getStudents().forEach(StudentService::deleteStudent);
    }

    //1
    @Test
    public void checkAvatarAndIdTest() {
        //прописала клас і визвала з нього метод, який приймає/встановлює request і response методи в параметрах
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        List<UserData> users = given()
                .when()
                .get("/api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        //checked if avatars contain users` ids
        users.forEach(x -> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
        //checked if all emails finish with "@regres.in"
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@regres.in")));

        //another way to check if avatars contain users` ids
//        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
//        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
//        for (int i = 0; i < avatars.size(); i++) {
//            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
    }

    //2
    @Test
    public void successRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        //expected result id and token
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        //created new user which can be related to Register class
        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);

        Assert.assertEquals(id, successReg.getId());
        Assert.assertEquals(token, successReg.getToken());
    }

    //3
    @Test
    public void unSuccessRegTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec400());
        Register user = new Register("sydney@fife", "");
        UnSuccessReg unSuccessReg = given()
                .body(user)
                .when()
                .post("/api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);

        Assert.assertEquals("Missing password", unSuccessReg.getError());
    }


    @Test
    public void checkLogInTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOK200());
        LogIn user = new LogIn("eve.holt@reqres.in", "pistol");
        SuccessLogIn successLogIn = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(SuccessLogIn.class);
        Assert.assertEquals("QpwL5tke4Pnpja7X4", successLogIn.getToken());
    }


    //SWAGGER


    @Test
    public void signUpTest() {
        SwaggerSignUp user = new SwaggerSignUp();
        Response response = postReg(user, "/sign-up");
        // usersForDelete.add(user.getUsername());

        Assert.assertEquals(response.getStatusCode(), 201);

    }


    @Test
    public void signInTest() {
        SwaggerSignUp user = new SwaggerSignUp();
        postReg(user, "/sign-up");

        SwaggerSignIn userLogin = new SwaggerSignIn();
        userLogin.setUsername(user.getUsername());
        Response response = postReg(userLogin, "/sign-in");

        usersForDelete.add(user.getUsername());

        Assert.assertEquals(response.getStatusCode(), 200);
    }

//my test
//    @Test
//    public void changePasswordTest() {
//        SwaggerSignUp user = new SwaggerSignUp();
//        postReg(user, "/sign-up");
//
//        SwaggerSignIn userLogin = new SwaggerSignIn();
//        userLogin.setUsername(user.getUsername());
//        userLogin.setPassword(user.getPassword());
//        postReg(userLogin, "/sign-in");
//
//        ChangedPassword password = new ChangedPassword("Lily", "63478473", "12345678", "12345678");
//        password.setNew_password(password.getPassword());
//
//        Response response = putChange(password);
//
//         usersForDelete.add(user.getUsername());
//
//        Assert.assertEquals(changedPassword.getNew_password(), changedPassword.getConfirm_new_password());
//
//    }

//Andri test
//    @Test
//    public void changePasswordTest() {
//        SwaggerSignUp user = new SwaggerSignUp();
//        postReg(user, "/sign-up");
//
//        SwaggerSignIn userLogin = new SwaggerSignIn();
//        userLogin.setUsername(user.getUsername());
//        userLogin.setPassword(user.getPassword());
//        Token login =  postReg(userLogin, "/sign-in").as(Token.class);
//
//        ChangedPassword password = new ChangedPassword();
//        password.setPassword(userLogin.getPassword());
//        password.setUsername(userLogin.getUsername());
//        Response response = putChange(password, login.getAccess_token());
//
//        usersForDelete.add(user.getUsername());
//
//
//        Assert.assertEquals(password.getNew_password(), password.getConfirm_new_password());
//
//    }


    @Test
    public void changePasswordTest() {
        SwaggerSignUp user = new SwaggerSignUp();
        postReg(user, "/sign-up");

        SwaggerSignIn userLogin = new SwaggerSignIn();
        userLogin.setUsername(user.getUsername());
        userLogin.setPassword(user.getPassword());
        Token login = postReg(userLogin, "/sign-in").as(Token.class);

        ChangedPassword password = new ChangedPassword();
        password.setPassword(userLogin.getPassword());
        password.setUsername(userLogin.getUsername());
        Response response = putChange(password, login.getAccess_token());

        usersForDelete.add(user.getUsername());


        Assert.assertEquals(password.getNew_password(), password.getConfirm_new_password());

    }

    // Student test
    @Test
    public void studentTest() {
        StudentPojo studentRequest = new StudentPojo();

        StudentResponse studentResponse = createStudent(studentRequest, 201);

        AssertionsApi.assertStudent(studentRequest, studentResponse);
    }


}


//my first test
//
//    @Test
//    public void checkAvatarAndIdTest() {
//        List<UserData> users = given()
//                .when()
//                .contentType(ContentType.JSON)
//                .get(URL + "api/users?page=2")
//                .then().log().all()
//                .extract().body().jsonPath().getList("data", UserData.class);
//
//        //checked if avatars contain users` ids
//        users.stream().forEach(x->Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
//        Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@regres.in")));
//
//        //another way to check if avatars contain users` ids
//        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
//        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
//        for (int i = 0; i < avatars.size(); i++) {
//            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
//        }
//
//
//
//
//
//lecture for gay club
//
//    @Test
//    public void registerTest () {
//        UserPojo user = new UserPojo();
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(user).log().all()
//                .when()
//                .post("/sign-up")
//                .then().log().all()
//                .extract().response();
//
//        Assert.assertEquals(response.getStatusCode(), 201);
//    }
//
//
//    @Test
//    public void logInTest1 () {
//        UserPojo user = new UserPojo();
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(user).log().all()
//                .when()
//                .post("/sign-up")
//                .then().log().all()
//                .extract().response();
//
//        LoginTest1 userLog = new LoginTest1();
//        userLog.setPassword(user.getPassword());
//        userLog.setUsername(user.getUsername());
//        Token1 log = (Token1) given()
//                .contentType(ContentType.JSON)
//                .body(userLog).log().all()
//                .when()
//                .post("/sign-in")
//                .then().log().all()
//                .extract().response()
//                .as(Token1.class);
//
//
//
//        Assert.assertEquals(user.getUsername(), userLog.getUsername());
//    }








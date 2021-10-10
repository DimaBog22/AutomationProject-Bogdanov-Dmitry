package RestAssuredTask;

import com.google.gson.Gson;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import RestAssuredTask.User.Root;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Log4j2
public class RestTests {

    String idDmitryPlumber = "";

    public static String readFileAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/RestAssuredTask/requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }
    @Test
    public void GetListUsers() {

        String endpoint = "/api/users?page=2";
        given().when().get(endpoint).then().statusCode(200);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

    }
    @Test
    public void GetSingleUser() {

        String endpoint = "/api/users/2";
        given().when().get(endpoint).then().statusCode(200);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.data.id, 2);
        Assert.assertEquals(root.data.email, "janet.weaver@reqres.in");

    }
    @Test
    public void GetSingleUserNotFound() {

        String endpoint = "/api/users/23";
        given().when().get(endpoint).then().statusCode(404);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

    }
    @Test
    public void GetListResource() {

        String endpoint = "/api/unknown";
        given().when().get(endpoint).then().statusCode(200);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

    }
    @Test
    public void GetSingleResource() {

        String endpoint = "/api/unknown/2";
        given().when().get(endpoint).then().statusCode(200);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

    }
    @Test
    public void GetSingleResourceNotFound() {

        String endpoint = "/api/unknown/23";
        given().when().get(endpoint).then().statusCode(404);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

    }
    @Test(priority = 1)
    public void PostCreate() {

        String endpoint = "/api/users";
        String requestBody = readFileAsString("post");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().get("name"), "Dmitry");
        Assert.assertEquals(response.jsonPath().get("job"), "plumber");

        idDmitryPlumber = response.jsonPath().get("id");
        log.info(idDmitryPlumber);
        log.info(response.body().prettyPrint());

    }
    @Test(priority = 2)
    public void PutUpdate() {

        String endpoint = "/api/users" + idDmitryPlumber;
        String requestBody = readFileAsString("put");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().put(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name"), "Dmitrius");
        Assert.assertEquals(response.jsonPath().get("job"), "devOps");

        log.info("user " + idDmitryPlumber + " is updated via PUT");
        log.info(response.body().prettyPrint());

    }
    @Test(priority = 3)
    public void PatchUpdate() {

        String endpoint = "/api/users" + idDmitryPlumber;
        String requestBody = readFileAsString("patch");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().put(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("name"), "Dima");
        Assert.assertEquals(response.jsonPath().get("job"), "devOps");

        log.info("user " + idDmitryPlumber + " is updated via PATCH");
        log.info(response.body().prettyPrint());

    }
    @Test(priority = 4)
    public void Delete() {

        String endpoint = "/api/users/" + idDmitryPlumber;
        Response response = given().delete(endpoint).then().extract().response();
        Assert.assertEquals(response.statusCode(), 204);
        log.info("user " + idDmitryPlumber + " is deleted");

    }
    @Test(priority = 5)
    public void PostRegisterSuccessful() {

        String endpoint = "/api/register";
        String requestBody = readFileAsString("register");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");

        log.info(response.body().prettyPrint());

    }
    @Test
    public void PostRegisterUnSuccessful() {

        String endpoint = "/api/register";
        String requestBody = readFileAsString("registerUnsuccessful");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");

        log.info(response.body().prettyPrint());

    }
    @Test(priority = 6)
    public void PostLoginSuccessful() {

        String endpoint = "/api/login";
        String requestBody = readFileAsString("login");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");

        log.info(response.body().prettyPrint());

    }
    @Test
    public void PostLoginUnSuccessful() {

        String endpoint = "/api/login";
        String requestBody = readFileAsString("loginUnsuccessful");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.jsonPath().get("error"), "Missing password");

        log.info(response.body().prettyPrint());

    }
    @Test
    public void GetDelay() {

        String endpoint = "/api/users?delay=3";
        given().when().get(endpoint).then().statusCode(200);
        Response response = given().when().get(endpoint).then().extract().response();
        log.info(response.body().prettyPrint());

    }

}

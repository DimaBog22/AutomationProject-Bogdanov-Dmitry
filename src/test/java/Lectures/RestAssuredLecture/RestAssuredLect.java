package Lectures.RestAssuredLecture;

import Lectures.RestAssuredLecture.Root;
import com.google.gson.Gson;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class RestAssuredLect {

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in";
    }

    @Test
    public void test1() {

        String endpoint = "api/users?id=1";
        given()
                .when()
                .get(endpoint) // send GET request
                .then()
                .statusCode(200) // check that status code is 200
                .extract() // export
                .response() // object of response which contains body, headers and other fields
                .getBody()
                .prettyPrint();

    }
    @Test
    public void test2() {

        String endpoint = "/api/users?id=1";

        Gson gson = new Gson();
        Root root = gson.fromJson(given()
                .when()
                .get(endpoint)
                .getBody()
                .asPrettyString(), Root.class);

        Assert.assertEquals(root.data.id, 1);

    }

    @DataProvider(name = "checkIds", parallel = true)
    public Object [][] data() {

        return new Object [][] {

                {1},
                {2},
                {3},
                {4},
                {5}

        };

    }
    @Test(dataProvider = "checkIds")
    public void test3(int id) {

        String endpoint = "/api/users?id=" + id;
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        Assert.assertEquals(root.data.id, id);

    }

}
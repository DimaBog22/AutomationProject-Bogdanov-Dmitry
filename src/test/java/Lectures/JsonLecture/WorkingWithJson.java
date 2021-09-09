package Lectures.JsonLecture;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jsonPojo.User;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;

public class WorkingWithJson {

    @Test
    public void test1() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        System.out.println(jsonObject);
        System.out.println(jsonObject.get("orderID"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(0).getAsJsonObject().get("productID"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(1).getAsJsonObject().get("productID"));
    }

    @Test
    public void test2() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        User user = gson.fromJson(json, User.class);
        System.out.println(user);
        System.out.println(user.getOrderID());
        System.out.println(user.getContents().get(0).getProductID());
        System.out.println(user.getContents().get(1).getProductID());
    }

    @Test
    public void test3() throws Exception {
        Gson gson = new Gson();
        String json = readFileAsString();
        User user = gson.fromJson(json, User.class);
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        assertEquals(user.getOrderID().doubleValue(), jsonObject.get("orderID").getAsDouble());
    }

    public static String readFileAsString() throws Exception {
        return new String(Files.readAllBytes(Paths.get("src/test/java/data.json")));
    }
}
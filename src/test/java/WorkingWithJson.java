import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkingWithJson {

    @Test
    public void test1() throws IOException {

        Gson gson = new Gson();
        String jsonData = readData();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
        System.out.println(jsonObject.get("members"));
        System.out.println(jsonObject.get("members").getAsJsonArray().get(0));

    }

    public String readData() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/java/data.json")));
    }

}

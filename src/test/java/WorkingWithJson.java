import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WorkingWithJson {

    @Test
    public void test1() {

        Gson gson = new Gson();

    }

    public String readData() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/java/data.json")));
    }

}

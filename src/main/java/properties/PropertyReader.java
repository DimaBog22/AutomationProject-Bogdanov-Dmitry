package properties;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties(String propertyName) {

        Properties properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(propertyName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;

    }

}

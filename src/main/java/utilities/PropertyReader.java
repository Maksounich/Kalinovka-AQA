package utilities;
;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static final Properties properties = new Properties();

    public static String getProp(String prop){
        if (properties.isEmpty()) {
            Class<PropertyReader> utilClass = PropertyReader.class;
            try {
                properties.load(utilClass.getResourceAsStream("/app.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return properties.getProperty(prop);
    }
}

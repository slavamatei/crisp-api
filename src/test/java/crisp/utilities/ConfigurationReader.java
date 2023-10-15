package crisp.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties=new Properties(); // create a static object

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
        } catch (IOException e) {
            System.out.println("Property is not found in Configuration Properties Files");
        }

    }
    public  static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }
}

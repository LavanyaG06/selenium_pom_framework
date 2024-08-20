package utilities;

import java.io.*;
import java.util.*;

public class Configuration {
    private static Properties properties = new Properties();

    public static String getPropertyValue(String key) throws IOException {
        String filePath = System.getProperty("user.dir")+"/src/test/resources/config.properties";
        FileInputStream inputStream = new FileInputStream(filePath);
        properties.load(inputStream);
        return properties.getProperty(key).toString();
    }
}

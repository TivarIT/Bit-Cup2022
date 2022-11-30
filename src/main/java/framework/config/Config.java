package framework.config;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Logger LOG = Logger.getLogger(Config.class);
    private static Properties properties;
    private static String file = "";

    public static Properties createProperties(String fileName) {
        if (properties == null || !file.equals(fileName)) {
            file = fileName;
            properties = new Properties();
            FileInputStream fis;
            try {
                fis = new FileInputStream("src/main/resources/" + fileName);
                properties.load(fis);
            } catch (IOException e) {
                LOG.error("Test data file is missing");
            }
        }
        return properties;
    }
}

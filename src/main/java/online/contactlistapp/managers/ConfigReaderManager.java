package online.contactlistapp.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderManager {

    private static final String CONFIG_FILE_PATH = "src/main/resources/config.properties";
    private static Properties properties;

    private static void initProperties() {//initiem properietatea declarata mai sus
        try {
            FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static String getProperty(String key) {// key reprezinta 'browser' sau alta cheie care e declarata in config.properties
        if (properties == null) {
            initProperties();
        }
        return getProperty(key);
    }

}




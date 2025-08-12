package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    // Load the properties file from the folder
    public static Properties userData =
            loadProperties(System.getProperty("user.dir") + "\\src\\main\\java\\properties\\userdata.properties");

    private static Properties loadProperties(String path) {
        Properties pro = new Properties();
        // stream for reading file
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
        } catch (IOException | NullPointerException e) {
            System.out.println("Error occurred :  " + e.getMessage());
        }

        return pro;
    }

}

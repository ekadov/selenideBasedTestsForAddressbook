package ru.addressbook.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfProperties {

    private static final Logger LOGGER = LogManager.getLogger(ConfProperties.class);

    private static Properties properties = new Properties();

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("Error reading configuration file");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getPortalUrl() {
        return properties.getProperty("base_url");
    }

    public static String getValidUsername() {
        return properties.getProperty("valid_username");
    }

    public static String getValidPassword() {
        return properties.getProperty("valid_password");
    }

    public static String getInvalidUsername() {
        return properties.getProperty("invalid_username");
    }

    public static String getInvalidPassword() {
        return properties.getProperty("invalid_password");
    }

    public static String getDbUrl() {
        return properties.getProperty("db_url");
    }

    public static String getDbUsername() {
        return properties.getProperty("db_username");
    }

    public static String getDbPassword() {
        return properties.getProperty("db_password");
    }

    public static String getTakeScreenshotOnFail() {
        return properties.getProperty("take_screenshot_on_fail");
    }

    public static String getJdbcDriver() {
        return properties.getProperty("jdbc_driver");
    }


}




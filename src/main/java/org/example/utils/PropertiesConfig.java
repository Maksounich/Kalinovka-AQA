package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesConfig {
    public static String baseURI;
    public static String URL;
    public static String password;
    public static String confirm_password;
    public static String office;
    public static String mentor;
    public static String signed_up;
    public static String new_password;
    public static String confirm_new_password;

    public static void setUpProperties() {
        Properties properties = new Properties();

        try (InputStream inputStream = PropertiesConfig.class.getResourceAsStream("/app.properties")) {
            properties.load(inputStream);
            baseURI = properties.getProperty("baseURI");
            URL = properties.getProperty("URL");
            password = properties.getProperty("password");
            confirm_password = properties.getProperty("confirm_password");
            office = properties.getProperty("office");
            mentor = properties.getProperty("mentor");
            signed_up = properties.getProperty("signed_up");
            new_password = properties.getProperty("new_password");
            confirm_new_password = properties.getProperty("confirm_new_password");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}

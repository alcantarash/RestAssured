package com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GlobalThings {

    public static String URL;
    public static String REPORT_NAME;
    public static String REPORT_PATH;
    private Properties properties;

    public GlobalThings(){
        properties = new Properties();
        InputStream input = null;

        try {
            input = new FileInputStream("globalThings.properties");
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("url.default");
        REPORT_NAME = properties.getProperty("report.name");
        REPORT_PATH = properties.getProperty("report.path");


    }
}

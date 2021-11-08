package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataManager {

    public static Properties prop;

    final static String PATH_TO_TEST_DATA = "src/main/resources/testData.properties";

    public static Properties getTestDataProperties() {
        if (prop == null) {
            prop = new Properties();
            readTestDataFromFile();
        }
        return prop;
    }

    public static void readTestDataFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(PATH_TO_TEST_DATA);
            prop.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public enum testDataProperties{
        protocol("protocol"),
        login("login"),
        password("password"),
        host("host"),
        minSliderValue("minSliderValue"),
        maxSliderValue("maxSliderValue");

        private String property;

        testDataProperties(String property) {
            this.property = property;
        }

        public String getProperty(){
            return prop.getProperty(property);
        }
    }
}

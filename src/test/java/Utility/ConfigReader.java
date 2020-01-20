package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



    public class ConfigReader {

        private static Properties configFile;
        static {
            try {

                FileInputStream fileInputStream = new FileInputStream("configuration.properties");

                configFile = new Properties();

                configFile.load(fileInputStream);

                fileInputStream.close();
            } catch (IOException e) {

            }
        }

        public static String getProperty(String key) {
            return configFile.getProperty(key);
        }

        public static void main(String[] args) {

            String url = getProperty("JDBC_URL");
            String username = getProperty("JDBC_username");
            String password = getProperty("JDBC_password");
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
        }
    }



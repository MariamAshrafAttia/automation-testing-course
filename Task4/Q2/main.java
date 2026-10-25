
package Q2;

import java.util.Properties;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {

    public static void main(String[] args) throws IOException {

        // Create a valid properties file
        Files.writeString(
                Path.of("config.properties"),
                "username=mariam\n" +
                        "timeout=30\n"
        );

        // Create a corrupted properties file
        Files.writeString(
                Path.of("corrupted.properties"),
                "username=mariam\n" +
                        "password=\\uZZZZ\n"
        );

        // Test 1: Valid file
        System.out.println("Test 1: Valid file");

        try {
            Properties p = ConfigReader.readConfig("config.properties");

            System.out.println("Username: " +
                    p.getProperty("username"));
            System.out.println("Timeout: " +
                    p.getProperty("timeout"));

        } catch (ConfigException e) {
            System.out.println("ConfigException: " +
                    e.getMessage());
        }

        // Test 2: Non-existent file
        System.out.println("\nTest 2: Non-existent file");

        try {
            ConfigReader.readConfig("missing.properties");

        } catch (ConfigException e) {
            System.out.println("ConfigException: " +
                    e.getMessage());
            System.out.println("Original cause: " +
                    e.getCause().getClass().getSimpleName());
        }

        // Test 3: Corrupted file
        System.out.println("\nTest 3: Corrupted file");

        try {
            ConfigReader.readConfig("corrupted.properties");

        } catch (ConfigException e) {
            System.out.println("ConfigException: " +
                    e.getMessage());
            System.out.println("Original cause: " +
                    e.getCause().getClass().getSimpleName());
        }
    }
}

package Q2;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
public class ConfigReader {

    public static Properties readConfig(String path)
            throws ConfigException
    {
        // 1. Create a Properties object
            Properties p=new Properties();

        // 2. Open the file using try-with-resources
            try (FileInputStream file = new FileInputStream(path))
            {
            // Load properties here
                p.load(file);
            }catch (IOException e)
            {
       // 3. Wrap IOException inside ConfigException
                throw new ConfigException(
                        "Failed to read config file: " + path, e);
            }catch (IllegalArgumentException e)
            {
                throw new ConfigException(
                        "Invalid config file format: " + path, e);
            }

        // 4. Return the Properties object
            return p;
    }
}

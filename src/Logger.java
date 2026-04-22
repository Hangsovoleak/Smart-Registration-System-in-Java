import java.io.FileWriter;
import java.io.IOException;

// This class logs errors into error.log file
public class Logger {
    public static void logError(String message) {
        try {
            FileWriter writer = new FileWriter("error.log", true);
            writer.write(message + "\n");
            writer.close();
        } catch (IOException e) {
            // If logging fails, at least show something
            System.out.println("Logging failed!");
        }
    }
}

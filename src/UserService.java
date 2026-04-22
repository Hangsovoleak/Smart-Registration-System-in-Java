import java.io.FileWriter;
import java.io.IOException;

// This class handles saving user data to file
public class UserService {

    // Method to save user into users.txt
    public static void saveUser(User user) throws IOException {

        // "true" means append mode (don't overwrite old data)
        FileWriter writer = new FileWriter("users.txt", true);
        writer.write(user.toString() + "\n");
        writer.close(); // always close to prevent memory leak
    }
}

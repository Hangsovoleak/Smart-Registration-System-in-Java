// Custom exception for age validation
public class UnderAgeException extends Exception {
    // Constructor that accepts a custom message
    public UnderAgeException(String message) {
        super(message); // passes message to Exception class
    }
}

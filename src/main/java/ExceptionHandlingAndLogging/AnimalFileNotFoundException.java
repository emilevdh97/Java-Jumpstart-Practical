package ExceptionHandlingAndLogging;

public class AnimalFileNotFoundException extends RuntimeException {
    public AnimalFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

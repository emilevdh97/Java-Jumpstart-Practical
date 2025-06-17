package loggingAndExceptionHandling;

public class AnimalsFileNotFoundException extends RuntimeException {

    public AnimalsFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

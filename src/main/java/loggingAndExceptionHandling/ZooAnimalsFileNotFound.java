package loggingAndExceptionHandling;

public class ZooAnimalsFileNotFound extends RuntimeException {
    public ZooAnimalsFileNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}

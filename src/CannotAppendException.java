public class CannotAppendException extends Exception {
    public CannotAppendException(String message) {
        super(message);
    }

    public CannotAppendException(String message, Throwable cause) {
        super(message, cause);
    }
}

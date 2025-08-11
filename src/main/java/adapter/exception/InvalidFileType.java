package adapter.exception;

public class InvalidFileType extends RuntimeException {
    public InvalidFileType(String message) {
        super(message);
    }
}

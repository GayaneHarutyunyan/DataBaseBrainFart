package utils.exception;

@SuppressWarnings("serial")
public class DaoRuntimeException extends RuntimeException {

    public DaoRuntimeException() {
        super();
    }

    public DaoRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoRuntimeException(String message) {
        super(message);
    }

}

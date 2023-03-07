package util;

public class AlreadyExistException extends Exception {

    public AlreadyExistException() {
        super();
    }

    public AlreadyExistException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public AlreadyExistException(String message, Throwable cause) {
        super(message, cause);

    }

    public AlreadyExistException(String message) {
        super(message);

    }

    public AlreadyExistException(Throwable cause) {
        super(cause);

    }
}


package util;

public class HandleUserException extends Exception {
    public HandleUserException() {
        super();
    }

    public HandleUserException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);

    }

    public HandleUserException(String message, Throwable cause) {
        super(message, cause);

    }

    public HandleUserException(String message) {
        super(message);

    }

    public HandleUserException(Throwable cause) {
        super(cause);

    }
}


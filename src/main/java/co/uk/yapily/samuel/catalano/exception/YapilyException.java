package co.uk.yapily.samuel.catalano.exception;

/**
 * @author Samuel Catalano
 */

public class YapilyException extends Exception {

    public YapilyException() {
        super();
    }

    public YapilyException(final String message) {
        super(message);
    }

    public YapilyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public YapilyException(final Throwable cause) {
        super(cause);
    }

    protected YapilyException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
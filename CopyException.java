/**
 * Created by JEWELZ on 5/5/15.
 */
public class CopyException extends Throwable {

    public CopyException() {
    }

    public CopyException(String message) {
        super(message);
    }

    public CopyException(String message, Throwable cause) {
        super(message, cause);
    }

    public CopyException(Throwable cause) {
        super(cause);
    }

    public CopyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

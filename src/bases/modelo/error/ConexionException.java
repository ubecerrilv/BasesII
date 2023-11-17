package bases.modelo.error;

@SuppressWarnings("serial")
public class ConexionException extends RuntimeException {

	public ConexionException() {
		super();
	}

	public ConexionException(String message) {
		super(message);
	}

	public ConexionException(Throwable cause) {
		super(cause);
	}

	public ConexionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConexionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}

package by.imix.controlSystem.exceptions;

/**
 * Created by IntelliJ IDEA.
 * User: Miha
 * Date: 28.10.12
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class ExceptionControlSystem extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 27L;

	public ExceptionControlSystem() {
    }

    public ExceptionControlSystem(String message) {
        super(message);
    }

    public ExceptionControlSystem(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionControlSystem(Throwable cause) {
        super(cause);
    }
}

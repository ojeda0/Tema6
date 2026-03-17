package exceptions;

public class InvalidTareaDataException extends RuntimeException{

	private static final long serialVersionUID = -176134178028476389L;

	public InvalidTareaDataException(String message) {
		super(message);
	}
	
}

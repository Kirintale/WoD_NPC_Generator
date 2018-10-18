package exceptions;

public class NpcGeneratorException extends Exception{
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 7142307140422096050L;

	public NpcGeneratorException(String string) {
		super (string);
	}
	
	public NpcGeneratorException(Exception e) {
		super (e);
	}
	
	public NpcGeneratorException(Throwable e) {
		super (e);
	}
	
	public NpcGeneratorException(String string, Throwable throwable) {
		super (string, throwable);
	}
}

/****************************************************************************
** FILE: FileFormatException.java
** AUTHOR: Brendan Lally
** STUDENT ID: 18407220
** UNIT: COMP2003 (Object Oriented Software Engineering)
** PURPOSE: A custom exception type to represent errors in the format of the
			property, event or plan files.
** LAST MOD: 25/10/16
****************************************************************************
**/

public class FileFormatException extends Exception {
	
	public FileFormatException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileFormatException(String message) {
		super(message);
	}
}
/**
 * 
 */
package Exception;

/**
 * @author Yipeng Zhang
 * @content cannot read specific database
 */
public class ReadDataBaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public ReadDataBaseException(String table) {
		super("Cannot access or read Table " + table);
	}
}

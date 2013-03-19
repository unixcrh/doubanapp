/**
 * 
 */
package org.mcxiaoke.commons.http;

/**
 * @author mcxiaoke
 * 
 */
public class SimpleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SimpleException() {
		super();
	}

	public SimpleException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public SimpleException(String detailMessage) {
		super(detailMessage);
	}

	public SimpleException(Throwable throwable) {
		super(throwable);
	}

}

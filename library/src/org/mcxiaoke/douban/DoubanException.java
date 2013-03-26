/**
 * 
 */
package org.mcxiaoke.douban;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanException extends Exception {
	private static final long serialVersionUID = 1L;

	private final int errorCode;
	private final String errorMessage;

	public DoubanException(int errorCode, String errorMessage,
			Throwable throwable) {
		super(errorMessage, throwable);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public DoubanException(int errorCode, String errorMessage) {
		this(errorCode, errorMessage, null);
	}

	public int getErrorCode() {
		return errorCode;
	}

}

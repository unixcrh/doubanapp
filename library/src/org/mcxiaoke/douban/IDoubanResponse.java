/**
 * 
 */
package org.mcxiaoke.douban;

import android.os.Bundle;

/**
 * @author mcxiaoke
 * @param <T>
 * 
 */
interface IDoubanResponse<T> {
	public int getErrorCode();

	public String getErrorMessage();

	public Bundle getExtras();

	public T getData();

}

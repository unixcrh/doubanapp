/**
 * 
 */
package org.mcxiaoke.douban.api;

import android.content.ContentValues;

/**
 * @author mcxiaoke
 * 
 */
public interface ContentStorable {

	public ContentValues writeToContentValues(ContentValues dest);

	public boolean readFromContentValues(ContentValues source);

}

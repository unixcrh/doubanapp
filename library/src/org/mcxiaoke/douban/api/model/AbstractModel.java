/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import android.os.Parcel;

/**
 *  Model抽象基类
 * @author mcxiaoke
 *
 */
public abstract class AbstractModel implements IBaseModel {

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}

}

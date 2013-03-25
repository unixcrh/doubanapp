/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanBookAnnotations extends
		AbstractListModel<DoubanBookAnnotation> {
	private List<DoubanBookAnnotation> annotations;

	public List<DoubanBookAnnotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(List<DoubanBookAnnotation> annotations) {
		this.annotations = annotations;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DoubanBookAnnotations [annotations=");
		builder.append(annotations);
		builder.append(", getCount()=");
		builder.append(getCount());
		builder.append(", getStart()=");
		builder.append(getStart());
		builder.append(", getTotal()=");
		builder.append(getTotal());
		builder.append("]");
		return builder.toString();
	}

	@Override
	public List<DoubanBookAnnotation> getData() {
		return annotations;
	}

	@Override
	public int size() {
		return annotations == null ? NULL_SIZE : annotations.size();
	}

}

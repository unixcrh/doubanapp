/**
 * 
 */
package org.mcxiaoke.douban.api.model;

import java.util.List;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanBookAnnotations extends AbstractListModel {
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

}

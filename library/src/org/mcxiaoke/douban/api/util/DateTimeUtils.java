/**
 * 
 */
package org.mcxiaoke.douban.api.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.text.TextUtils;

/**
 * 日期时间解析类
 * 
 * @author mcxiaoke
 * 
 */
public final class DateTimeUtils {
	// douban shuo date string format : created_at: "2013-03-13 10:08:09",
	private static final String DATE_FORMAT_STRING_DOUBAN = "yyyy-MM-dd HH:mm";
	public static final SimpleDateFormat DATE_FORMAT_DOUBAN = new SimpleDateFormat(
			DATE_FORMAT_STRING_DOUBAN, Locale.US);
	private static final ParsePosition PARSE_POSITION = new ParsePosition(0);

	public static Date parseDoubanDate(final String text) {
		Date date = null;
		if (!TextUtils.isEmpty(text)) {
			PARSE_POSITION.setIndex(0);
			date = DATE_FORMAT_DOUBAN.parse(text, PARSE_POSITION);
		}
		return date;
	}

}

/**
 * 
 */
package org.mcxiaoke.douban.api.parser;

import java.io.IOException;
import java.util.Date;

import org.mcxiaoke.douban.api.util.DateTimeUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author mcxiaoke
 * 
 */
public class DateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return DateTimeUtils.parseDoubanDate(parser.getText());
	}

}

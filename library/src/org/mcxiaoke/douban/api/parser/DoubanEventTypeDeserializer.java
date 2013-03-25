/**
 * 
 */
package org.mcxiaoke.douban.api.parser;

import java.io.IOException;

import org.mcxiaoke.douban.api.DoubanEventType;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanEventTypeDeserializer extends JsonDeserializer<DoubanEventType> {

	@Override
	public DoubanEventType deserialize(JsonParser parser,
			DeserializationContext context) throws IOException,
			JsonProcessingException {
		String text = parser.getText();
		DoubanEventType type = DoubanEventType.valueOf(text);
		return type;
	}

}

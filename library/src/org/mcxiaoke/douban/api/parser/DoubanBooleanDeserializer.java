/**
 * 
 */
package org.mcxiaoke.douban.api.parser;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanBooleanDeserializer extends JsonDeserializer<Boolean> {

	@Override
	public Boolean deserialize(JsonParser parser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		return !"no".equalsIgnoreCase(parser.getText());
	}

}

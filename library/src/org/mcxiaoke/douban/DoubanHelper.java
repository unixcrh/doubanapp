/**
 * 
 */
package org.mcxiaoke.douban;

import java.io.IOException;
import java.util.List;

import org.mcxiaoke.commons.http.SimpleResponse;
import org.mcxiaoke.douban.api.model.DoubanError;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author mcxiaoke
 * 
 */
final class DoubanHelper {

	public static DoubanError parseError(SimpleResponse response)
			throws IOException {
		return parseSingleResponse(response, DoubanError.class);
	}

	public static <T> T parseSingleResponse(SimpleResponse response,
			Class<T> clazz) throws IOException {
		ObjectMapper om = DoubanHelper.getObjectMapper();
		return om.readValue(response.getContent(), clazz);
	}

	public static <T> T parseArrayResponse(SimpleResponse response,
			TypeReference<T> type) throws IOException {
		ObjectMapper om = DoubanHelper.getObjectMapper();
		return om.readValue(response.getContent(), type);
	}

	public static ObjectMapper getObjectMapper() {
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		om.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		return om;
	}
}

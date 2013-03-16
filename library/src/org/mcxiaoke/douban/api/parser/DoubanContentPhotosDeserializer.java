/**
 * 
 */
package org.mcxiaoke.douban.api.parser;

import java.io.IOException;
import java.util.ArrayList;

import org.mcxiaoke.douban.api.model.DoubanContentPhotos;

import android.util.Log;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author mcxiaoke
 * 
 */
public class DoubanContentPhotosDeserializer extends
		JsonDeserializer<DoubanContentPhotos> {

	@Override
	public DoubanContentPhotos deserialize(JsonParser parser,
			DeserializationContext context) throws IOException,
			JsonProcessingException {
		ArrayList<String> array = new ArrayList<String>();
		while (parser.nextToken() != JsonToken.END_OBJECT) {
			array.add(parser.getText());
		}
		DoubanContentPhotos photos = new DoubanContentPhotos();
		for (int i = 0; i < array.size(); i = i + 2) {
			int id = Integer.valueOf(array.get(i));
			String url = array.get(i + 1);
			photos.add(id, url);
		}
		photos.sort();
//		for (int i = 0; i < photos.getIds().size(); ++i) {
//			Log.e("AndroidTestCase", "" + photos.getIds().get(i) + ": "
//					+ photos.getUrls().get(i));
//		}
		return photos;
	}

}

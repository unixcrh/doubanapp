package org.scribe.services;

import org.mcxiaoke.commons.util.Base64;

public class DatatypeConverterEncoder extends Base64Encoder {
	@Override
	public String encode(byte[] bytes) {
		return Base64.encodeBytes(bytes);
	}

	@Override
	public String getType() {
		return "DatatypeConverter";
	}
}

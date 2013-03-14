package org.scribe.services;

import org.scribe.exceptions.*;
import org.scribe.utils.*;

/**
 * plaintext implementation of {@SignatureService}
 * 
 * @author Pablo Fernandez
 * 
 */
public class PlaintextSignatureService implements SignatureService {
	private static final String METHOD = "PLAINTEXT";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSignature(String baseString, String apiSecret,
			String tokenSecret) {
		try {
			Preconditions.checkEmptyString(apiSecret,
					"Api secret cant be null or empty string");
			return OAuthEncoder.encode(apiSecret) + '&'
					+ OAuthEncoder.encode(tokenSecret);
		} catch (Exception e) {
			throw new OAuthSignatureException(baseString, e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSignatureMethod() {
		return METHOD;
	}
}

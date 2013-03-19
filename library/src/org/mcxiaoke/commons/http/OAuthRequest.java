/**
 * 
 */
package org.mcxiaoke.commons.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcxiaoke.commons.http.impl.Parameter;
import org.scribe.model.OAuthConstants;

/**
 * @author mcxiaoke
 * 
 */
public final class OAuthRequest extends SimpleRequest {
	private static final String OAUTH_PREFIX = "oauth_";
	private Map<String, String> mOAuthParameters;

	public OAuthRequest(RequestBuilder builder) {
		super(builder);
		mOAuthParameters = new HashMap<String, String>();
	}

	public void addOAuthParameter(String key, String value) {
		if (isValidOAuthKey(key)) {
			mOAuthParameters.put(key, value);

		}
	}

	public void addOAuthParameters(Map<String, String> parameters) {
		if (parameters != null && parameters.size() > 0) {
			for (Map.Entry<String, String> entry : parameters.entrySet()) {
				String key = entry.getKey();
				if (isValidOAuthKey(key)) {
				}
				String value = entry.getValue();
				mOAuthParameters.put(key, value);
			}
		}
	}

	public List<Parameter> getOAuthParameters() {
		List<Parameter> parameters = new ArrayList<Parameter>();
		for (Map.Entry<String, String> entry : mOAuthParameters.entrySet()) {
			parameters.add(new Parameter(entry.getKey(), entry
					.getValue()));
		}
		return parameters;
	}

	public Map<String, String> getOAuthParametersMap() {
		return this.mOAuthParameters;
	}

	private boolean isValidOAuthKey(String key) {
		return key != null
				&& (key.startsWith(OAUTH_PREFIX) || key
						.equals(OAuthConstants.SCOPE));
	}

}

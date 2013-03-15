package org.mcxiaoke.douban.app.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.mcxiaoke.commons.util.FileUtils;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Log;

public class BaseTestCase extends AndroidTestCase {
	private static final String TAG = "AndroidTestCase";

	protected final void debug(Object obj) {
		Log.i(TAG, "" + obj);
	}

	protected final void error(Object obj) {
		Log.e(TAG, "" + obj);
	}

	protected final InputStream openAssets(String fileName) throws IOException {
		Context context = getContext();
		return context.getAssets().open(fileName);
	}

	protected final String openAssetsAsString(String fileName)
			throws IOException {
		return FileUtils.copyToString(new InputStreamReader(
				openAssets(fileName)));
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}

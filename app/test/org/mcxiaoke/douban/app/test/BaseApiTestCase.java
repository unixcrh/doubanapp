package org.mcxiaoke.douban.app.test;

import org.mcxiaoke.douban.DoubanApiClient;
import org.mcxiaoke.douban.DoubanApiClientFactory;
import org.mcxiaoke.douban.DoubanSession;

public abstract class BaseApiTestCase extends BaseTestCase {
	protected DoubanApiClient api;
	protected DoubanSession session;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		session = Mock.mockDoubanSessionWithToken(getContext());
		api = DoubanApiClientFactory.getApiClient(getContext(), session);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSession() {
		assertTrue(session.isSessionValid());
	}

	public void testSessionComplete() {
		DoubanSession ds = Mock.mockDoubanSession(getContext());
		assertEquals(ds.getApiKey(), Mock.API_KEY);
		assertEquals(ds.getApiSecret(), Mock.API_SECRET);
		assertEquals(ds.getCallbackUrl(), Mock.CALLBACK_URL);
		assertTrue(ds.isSessionEmpty());
		assertTrue(ds.isKeyAndSecretValid());
		assertFalse(ds.isSessionExpired());
		assertNull(ds.getAuthorizeCode());
	}

}

/**
 * 
 */
package org.mcxiaoke.douban;

/**
 * @author mcxiaoke
 * 
 */
public final class DoubanConfig {
	public static final String EXTRA_ERROR_CODE = "EXTRA_ERROR_CODE";
	public static final String EXTRA_ERROR_MESSAGE = "EXTRA_ERROR_MESSAGE";
	public static final String EXTRA_ERROR_REQUEST = "EXTRA_ERROR_REQUEST";
	

	public static final String API_HOST = "https://api.douban.com";
	
	public static final int DEFAULT_COUNT=20;
	public static final int DEFAULT_START=0;

	public static final class OAuth {

		public static final String AUTHORIZE_URL = "https://www.douban.com/service/auth2/auth";
		public static final String TOKEN_URL = "https://www.douban.com/service/auth2/token";

		public static final String CALLBACK_URL = "http://www.baidu.com";
		public static final String KEY_CLIENT_ID = "client_id";
		public static final String KEY_CLIENT_SECRET = "client_secret";
		public static final String KEY_REDIRECT_URI = "redirect_uri";
		public static final String KEY_GRANT_TYPE = "grant_type";
		public static final String KEY_RESPONSE_TYPE = "response_type";
		public static final String KEY_SCOPE = "scope";
		public static final String KEY_CODE = "code";

		public static final String VALUE_RESPONSE_TYPE_CODE = "code";
		public static final String VALUE_RESPONSE_TYPE_TOKEN = "token";

		public static final String getDefaultScope() {
			StringBuilder sb = new StringBuilder();
			sb.append(Scope.SCOPE_BASIC_COMMON).append(",");
			sb.append(Scope.SCOPE_SHUO_BASIC_READ).append(",");
			sb.append(Scope.SCOPE_SHUO_BASIC_WRITE).append(",");
			sb.append(Scope.SCOPE_COMMUNITY_BASIC_NOTE).append(",");
			sb.append(Scope.SCOPE_COMMUNITY_BASIC_USER).append(",");
			sb.append(Scope.SCOPE_COMMUNITY_BASIC_PHOTO).append(",");
			sb.append(Scope.SCOPE_MOVIE_BASIC).append(",");
			sb.append(Scope.SCOPE_BOOK_BASIC_READ);
			return sb.toString();
		}
	}

	public static final class Key {
		public static final String TOTAL = "total";
		public static final String COUNT = "count";
		public static final String START = "start";
		public static final String QUERY = "q";
		public static final String TAG = "tag";
		public static final String USER_ID = "user_id";
		public static final String SOURCE = "source";
		public static final String SOURCE_ID = "source_id";
		public static final String TARGET_ID = "target_id";
		public static final String APPKEY = "appkey";
	}

	static final class Scope {
		public static final String SCOPE_BASIC_COMMON = "douban_basic_common";
		public static final String SCOPE_SHUO_BASIC_READ = "shuo_basic_r";
		public static final String SCOPE_SHUO_BASIC_WRITE = "shuo_basic_w";
		public static final String SCOPE_COMMUNITY_BASIC_NOTE = "community_basic_note";
		public static final String SCOPE_COMMUNITY_BASIC_USER = "community_basic_user";
		public static final String SCOPE_COMMUNITY_BASIC_PHOTO = "community_basic_photo";
		public static final String SCOPE_COMMUNITY_BASIC_ONLINE = "community_basic_online";
		public static final String SCOPE_EVENT_BASIC_READ = "event_basic_r";
		public static final String SCOPE_EVENT_BASIC_WRITE = "event_basic_w";
		public static final String SCOPE_MOVIE_BASIC = "movie_basic";
		public static final String SCOPE_MOVIE_BASIC_READ = "movie_basic_r";
		public static final String SCOPE_MOVIE_BASIC_WRITE = "movie_basic_w";
		public static final String SCOPE_BOOK_BASIC_READ = "book_basic_r";
		public static final String SCOPE_BOOK_BASIC_WRITE = "book_basic_w";
		public static final String SCOPE_MUSIC_BASIC_READ = "music_basic_r";
		public static final String SCOPE_MUSIC_BASIC_WRITE = "music_basic_w";
	}

	public static final class Path {
		public static final String COMMENTS = "/v2/%s/%s/comments";
		public static final String COMMENT = "/v2/%a/%s/comment/%s";

		// public static final String USER = "/v2/user/%s";

		public static final String USERS = "/v2/user";
		public static final String USER_ME = "/v2/user/~me";
		public static final String USER = "/shuo/v2/users/%s";
		// public static final String USER_ME = "/shuo/v2/users/~me";

		// below from douban shuo
		public static final String USERS_FOLLOWING = "/shuo/v2/users/%s/following";
		public static final String USERS_FOLLOWERS = "/shuo/v2/users/%s/followers";
		public static final String USERS_FOLLOW_IN_COMMON = "/shuo/v2/users/%s/follow_in_common";
		public static final String USERS_FOLLOW_ALSO = "/shuo/v2/users/%s/following_followers_of";
		public static final String USERS_SEARCH = "/shuo/v2/users/search";
		public static final String USER_BLOCK = "/shuo/v2/users/%s/block";
		public static final String USER_FOLLOW = "/shuo/v2/friendships/create";
		public static final String USER_UNFOLLOW = "/shuo/v2/friendships/destroy";
		public static final String USER_FRIENDSHIP = "/shuo/v2/friendships/show";

		public static final String NOTES = "/v2/notes";
		public static final String NOTES_USER = "/v2/note/user_created/%s";
		public static final String NOTES_LIKED = "/v2/note/user_liked/%s";
		public static final String NOTE_ID = "/v2/note/%s";
		public static final String NOTE_COMMENTS = "/v2/note/%s/comments";
		public static final String NOTE_LIKE = "/v2/note/%s/like";

		public static final String ALBUM = "/v2/album/%s";
		public static final String PHTOTS = "/v2/album/%s/photos";
		public static final String PHOTO = "/v2/photo/%s";

		public static final String STATUSES = "/shuo/v2/statuses/";
		public static final String STATUSES_HOME = "/shuo/v2/statuses/home_timeline";
		public static final String STATUSES_USER = "/shuo/v2/statuses/user_timeline/%s";
		public static final String STATUS = "shuo/v2/statuses/%s";
		public static final String STATUS_COMMENTS = "/shuo/v2/statuses/%s/comments";
		public static final String STATUS_COMMENT = "/shuo/v2/statuses/comment/%s";
		public static final String STATUS_RESHARE = "/shuo/v2/statuses/%s/reshare";
		public static final String STATUS_LIKE = "/shuo/v2/statuses/%s/like";

		public static final String BOOK = "/v2/book/%s";
		public static final String BOOK_ISBN = "/v2/book/isbn/%s";
		public static final String BOOKS_SEARCH = "/v2/book/search";
		public static final String BOOK_COLLECTIONs = "/v2/book/user/%s/collections";
		public static final String BOOK_COLLECTION = "/v2/book/%s/collection";
		public static final String BOOK_ANNOTATIONS = "/v2/book/user/%s/annotations";
		public static final String BOOK_ANNOTATION = "/v2/book/annotation/%s";
		public static final String BOOK_REVIEWS = "/v2/book/reviews";
		public static final String BOOK_REVIEW = "/v2/book/review/%s";

		public static final String MOVIE = "/v2/movie/subject/%s";
		public static final String MOVIE_PHOTOS = "/v2/movie/subject/%s/photos";
		public static final String MOVIE_REVIEWS = "/v2/movie/subject/%s/reviews";
		public static final String MOVIE_COMMENTS = "/v2/movie/subject/%s/comments";
		public static final String MOVIES_SEARCH = "/v2/movie/search";
		public static final String MOVIES_TOP250 = "/v2/movie/top250";
		public static final String MOVIES_USTOP = "/v2/movie/us_box";
		public static final String MOVIES_WEEKLY = "/v2/movie/weekly";
		public static final String CELEBRITY = "/v2/movie/celebrity/%s";
		public static final String CELEBRITY_WORKS = "/v2/movie/celebrity/%s/works";
		public static final String CELEBRITY_PHOTOS = "/v2/movie/celebrity/%s/photos";

		public static final String MUSIC = "/v2/music/%s";
		public static final String MUSICS_SEARCH = "/v2/music/search";
		public static final String MUSIC_REVIEWS_NEW = "/v2/music/reviews";
		public static final String MUSIC_REVIEWS = "/v2/music/review/%s";

		public static final String EVENT = "/v2/event/%s";
		public static final String EVENTS_CREATED = "/v2/event/user_created/%s";
		public static final String EVENTS_PARTICIPATED = "/v2/event/user_participated/%s";
		public static final String EVENTS_WISHED = "/v2/event/user_wished/%s";
		public static final String EVENTS = "/v2/event/list";
		public static final String EVENT_CITIES = "/v2/loc/list";
		public static final String EVENT_PARTICIPATS = "/v2/event/%s/participants";

		public static final String ONLINE = "/v2/online/%s";
		public static final String ONLINES = "/v2/onlines";
		public static final String ONLINE_PARTICIPATES = "/v2/online/%s/participants";
		public static final String ONLINE_LIKE = "/v2/online/%s/like";
		public static final String ONLINES_PHOTOS = "/v2/online/%s/photos";
		public static final String ONLINES_CREATED = "/v2/online/user_created/%s";
		public static final String ONLINES_PARTICIPANTED = "/v2/online/user_participated/%s";
	}

}

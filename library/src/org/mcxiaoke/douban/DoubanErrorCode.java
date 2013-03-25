package org.mcxiaoke.douban;

public final class DoubanErrorCode {
	

	public static final int CODE_OK = 0;
	
	public static final int CODE_UNKOWN_ERROR = -1000;
	public static final int CODE_NETWORK_ERROR = -1001;
	public static final int CODE_SERVER_ERROR = -1002;
	public static final int CODE_UNAUTHORIZED = -1003;
	
	public static final int CODE_NEED_PERMISSION = 1000;
	public static final int CODE_URI_NOT_FOUND = 1001;
	public static final int CODE_MISSING_ARGUMENTS = 1002;
	public static final int CODE_IMAGE_TOO_LARGE = 1003;
	public static final int CODE_BANNED_WORDS_FOUND = 1004;
	public static final int CODE_INPUT_TOO_SHORT = 1005;
	public static final int CODE_RESOURCE_NOT_FOUND = 1006;
	public static final int CODE_NEED_CAPTCHA = 1007;


	// http://developers.douban.com/wiki/?title=api_v2

	// 200 OK 请求成功
	// 201 CREATED 创建成功
	// 202 ACCEPTED 更新成功
	// 400 BAD REQUEST 请求的地址不存在或者包含不支持的参数
	// 401 UNAUTHORIZED 未授权
	// 403 FORBIDDEN 被禁止访问
	// 404 NOT FOUND 请求的资源不存在
	// 500 INTERNAL SERVER ERROR 内部错误

	// 999 unknow_v2_error 未知错误 400
	// 1000 need_permission 需要权限 403
	// 1001 uri_not_found 资源不存在 404
	// 1002 missing_args 参数不全 400
	// 1003 image_too_large 上传的图片太大 400
	// 1004 has_ban_word 输入有违禁词 400
	// 1005 input_too_short 输入为空，或者输入字数不够 400
	// 1006 target_not_fount 相关的对象不存在，比如回复帖子时，发现小组被删掉了 400
	// 1007 need_captcha 需要验证码，验证码有误 403
	// 1008 image_unknow 不支持的图片格式 400
	// 1009 image_wrong_format 照片格式有误(仅支持JPG,JPEG,GIF,PNG或BMP) 400
	// 1010 image_wrong_ck 访问私有图片ck验证错误 403
	// 1011 image_ck_expired 访问私有图片ck过期 403
	// 1012 title_missing 题目为空 400
	// 1013 desc_missing 描述为空 400


}

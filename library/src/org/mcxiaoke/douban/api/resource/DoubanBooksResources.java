/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.io.IOException;
import java.util.Date;

import org.mcxiaoke.douban.DoubanException;
import org.mcxiaoke.douban.DoubanResponse;
import org.mcxiaoke.douban.api.model.DoubanBook;
import org.mcxiaoke.douban.api.model.DoubanBookAnnotation;
import org.mcxiaoke.douban.api.model.DoubanBookAnnotations;
import org.mcxiaoke.douban.api.model.DoubanBookCollectionItem;
import org.mcxiaoke.douban.api.model.DoubanBookCollections;
import org.mcxiaoke.douban.api.model.DoubanBookReview;
import org.mcxiaoke.douban.api.model.DoubanBooks;

/**
 * @author mcxiaoke
 * 
 */
public interface DoubanBooksResources {

	// 图书

	DoubanResponse<DoubanBook> getBook(long bookId) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBook> getBookByISBN(String isbn)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBooks> searchBook(String query)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBooks> searchBook(String query, String tag)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBooks> searchBook(String query, String tag, int count)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBooks> searchBook(String query, String tag, int count,
			int start) throws DoubanException, IOException;

	// 书评

	DoubanResponse<DoubanBookReview> addBookReview(long bookId, String title,
			String content) throws DoubanException, IOException;

	DoubanResponse<DoubanBookReview> addBookReview(long bookId, String title,
			String content, int rating) throws DoubanException, IOException;

	DoubanResponse<DoubanBookReview> updateBookReview(long reviewId,
			String title, String content) throws DoubanException, IOException;

	DoubanResponse<DoubanBookReview> updateBookReview(long reviewId,
			String title, String content, int rating) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookReview> deleteBookReview(long reviewId)
			throws DoubanException, IOException;

	// 收藏
	DoubanResponse<DoubanBookCollectionItem> getBookCollection(long collectionId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status, String tags) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status, String tags, String comment) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status, String tags, String comment, String privacy,
			int rating) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status, String tags)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status, String tags, String comment)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status, String tags, String comment,
			String privacy, int rating) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollectionItem> deleteBookCollection(
			long collectionId) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId,
			String status) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId,
			String status, Date from, Date to) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId,
			String status, Date from, Date to, int rating)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(
			String userName, String status) throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(
			String userName, String status, Date from, Date to)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookCollections> getUserBookCollections(
			String userName, String status, Date from, Date to, int rating)
			throws DoubanException, IOException;

	// 笔记

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId,
			String status) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId,
			String status, Date from, Date to) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId,
			String status, Date from, Date to, int rating)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(String userName)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(
			String userName, String status) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(
			String userName, String status, Date from, Date to)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(
			String userName, String status, Date from, Date to, int rating)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> getBookAnnotation(long annotationId)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> getBookAnnotation(long annotationId,
			String format) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, int page) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, String chapter) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, int page, String chapter) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, int page, String chapter, String privacy)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, int page) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, String chapter) throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, int page, String chapter) throws DoubanException,
			IOException;

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, int page, String chapter, String privacy)
			throws DoubanException, IOException;

	DoubanResponse<DoubanBookAnnotation> deleteBookAnnotation(long annotationId)
			throws DoubanException, IOException;

}

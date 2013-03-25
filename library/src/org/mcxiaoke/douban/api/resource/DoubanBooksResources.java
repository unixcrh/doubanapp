/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.util.Date;

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

	DoubanResponse<DoubanBook> getBook(long bookId);

	DoubanResponse<DoubanBook> getBookByISBN(String isbn);

	DoubanResponse<DoubanBooks> searchBook(String query);

	DoubanResponse<DoubanBooks> searchBook(String query, String tag);

	DoubanResponse<DoubanBooks> searchBook(String query, String tag, int count);

	DoubanResponse<DoubanBooks> searchBook(String query, String tag, int count,
			int start);

	// 书评

	DoubanResponse<DoubanBookReview> addBookReview(long bookId, String title,
			String content);

	DoubanResponse<DoubanBookReview> addBookReview(long bookId, String title,
			String content, int rating);

	DoubanResponse<DoubanBookReview> updateBookReview(long reviewId,
			String title, String content);

	DoubanResponse<DoubanBookReview> updateBookReview(long reviewId,
			String title, String content, int rating);

	DoubanResponse<DoubanBookReview> deleteBookReview(long reviewId);

	// 收藏
	DoubanResponse<DoubanBookCollectionItem> getBookCollection(long collectionId);

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status);

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status, String tags);

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status, String tags, String comment);

	DoubanResponse<DoubanBookCollectionItem> addBookCollection(long bookId,
			String status, String tags, String comment, String privacy,
			int rating);

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status);

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status, String tags);

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status, String tags, String comment);

	DoubanResponse<DoubanBookCollectionItem> updateBookCollection(
			long collectionId, String status, String tags, String comment,
			String privacy, int rating);

	DoubanResponse<DoubanBookCollectionItem> deleteBookCollection(
			long collectionId);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId,
			String status);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId,
			String status, Date from, Date to);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(long userId,
			String status, Date from, Date to, int rating);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(String userName);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(
			String userName, String status);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(
			String userName, String status, Date from, Date to);

	DoubanResponse<DoubanBookCollections> getUserBookCollections(
			String userName, String status, Date from, Date to, int rating);

	// 笔记

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId,
			String status);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId,
			String status, Date from, Date to);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(long userId,
			String status, Date from, Date to, int rating);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(String userName);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(
			String userName, String status);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(
			String userName, String status, Date from, Date to);

	DoubanResponse<DoubanBookAnnotations> getUserBookAnnotations(
			String userName, String status, Date from, Date to, int rating);

	DoubanResponse<DoubanBookAnnotation> getBookAnnotation(long annotationId);

	DoubanResponse<DoubanBookAnnotation> getBookAnnotation(long annotationId,
			String format);

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, int page);

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, String chapter);

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, int page, String chapter);

	DoubanResponse<DoubanBookAnnotation> addBookAnnotation(long bookId,
			String content, int page, String chapter, String privacy);

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, int page);

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, String chapter);

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, int page, String chapter);

	DoubanResponse<DoubanBookAnnotation> updateBookAnnotation(long annoationId,
			String content, int page, String chapter, String privacy);

	DoubanResponse<DoubanBookAnnotation> deleteBookAnnotation(long annotationId);

}

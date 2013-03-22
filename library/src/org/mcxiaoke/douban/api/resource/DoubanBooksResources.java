/**
 * 
 */
package org.mcxiaoke.douban.api.resource;

import java.util.Date;

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

	DoubanBook getBook(long bookId);

	DoubanBook getBookByISBN(String isbn);

	DoubanBooks searchBook(String query);

	DoubanBooks searchBook(String query, String tag);

	DoubanBooks searchBook(String query, String tag, int count);

	DoubanBooks searchBook(String query, String tag, int count, int start);

	// 书评

	DoubanBookReview addBookReview(long bookId, String title, String content);

	DoubanBookReview addBookReview(long bookId, String title, String content,
			int rating);

	DoubanBookReview updateBookReview(long reviewId, String title,
			String content);

	DoubanBookReview updateBookReview(long reviewId, String title,
			String content, int rating);

	DoubanBookReview deleteBookReview(long reviewId);

	// 收藏
	DoubanBookCollectionItem getBookCollection(long collectionId);

	DoubanBookCollectionItem addBookCollection(long bookId, String status);

	DoubanBookCollectionItem addBookCollection(long bookId, String status,
			String tags);

	DoubanBookCollectionItem addBookCollection(long bookId, String status,
			String tags, String comment);

	DoubanBookCollectionItem addBookCollection(long bookId, String status,
			String tags, String comment, String privacy, int rating);

	DoubanBookCollectionItem updateBookCollection(long collectionId,
			String status);

	DoubanBookCollectionItem updateBookCollection(long collectionId,
			String status, String tags);

	DoubanBookCollectionItem updateBookCollection(long collectionId,
			String status, String tags, String comment);

	DoubanBookCollectionItem updateBookCollection(long collectionId,
			String status, String tags, String comment, String privacy,
			int rating);

	DoubanBookCollectionItem deleteBookCollection(long collectionId);

	DoubanBookCollections getUserBookCollections(long userId);

	DoubanBookCollections getUserBookCollections(long userId, String status);

	DoubanBookCollections getUserBookCollections(long userId, String status,
			Date from, Date to);

	DoubanBookCollections getUserBookCollections(long userId, String status,
			Date from, Date to, int rating);

	DoubanBookCollections getUserBookCollections(String userName);

	DoubanBookCollections getUserBookCollections(String userName, String status);

	DoubanBookCollections getUserBookCollections(String userName,
			String status, Date from, Date to);

	DoubanBookCollections getUserBookCollections(String userName,
			String status, Date from, Date to, int rating);

	// 笔记

	DoubanBookAnnotations getUserBookAnnotations(long userId);

	DoubanBookAnnotations getUserBookAnnotations(long userId, String status);

	DoubanBookAnnotations getUserBookAnnotations(long userId, String status,
			Date from, Date to);

	DoubanBookAnnotations getUserBookAnnotations(long userId, String status,
			Date from, Date to, int rating);

	DoubanBookAnnotations getUserBookAnnotations(String userName);

	DoubanBookAnnotations getUserBookAnnotations(String userName, String status);

	DoubanBookAnnotations getUserBookAnnotations(String userName,
			String status, Date from, Date to);

	DoubanBookAnnotations getUserBookAnnotations(String userName,
			String status, Date from, Date to, int rating);

	DoubanBookAnnotation getBookAnnotation(long annotationId);

	DoubanBookAnnotation getBookAnnotation(long annotationId, String format);

	DoubanBookAnnotation addBookAnnotation(long bookId, String content, int page);

	DoubanBookAnnotation addBookAnnotation(long bookId, String content,
			String chapter);

	DoubanBookAnnotation addBookAnnotation(long bookId, String content,
			int page, String chapter);

	DoubanBookAnnotation addBookAnnotation(long bookId, String content,
			int page, String chapter, String privacy);

	DoubanBookAnnotation updateBookAnnotation(long annoationId, String content,
			int page);

	DoubanBookAnnotation updateBookAnnotation(long annoationId, String content,
			String chapter);

	DoubanBookAnnotation updateBookAnnotation(long annoationId, String content,
			int page, String chapter);

	DoubanBookAnnotation updateBookAnnotation(long annoationId, String content,
			int page, String chapter, String privacy);

	boolean deleteBookAnnotation(long annotationId);

}

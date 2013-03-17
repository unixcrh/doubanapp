/**
 * 
 */
package org.mcxiaoke.douban.api.action;

import org.mcxiaoke.douban.api.model.DoubanBook;
import org.mcxiaoke.douban.api.model.DoubanBookAnnotation;
import org.mcxiaoke.douban.api.model.DoubanBookAnnotations;
import org.mcxiaoke.douban.api.model.DoubanBookCollection;
import org.mcxiaoke.douban.api.model.DoubanBookCollectionItem;
import org.mcxiaoke.douban.api.model.DoubanBookReview;
import org.mcxiaoke.douban.api.model.DoubanBooks;

/**
 * @author mcxiaoke
 * 
 */
public interface IDoubanBookAction {
	// GET /v2/book/:id
	DoubanBook getBookInfo(long bookId);

	// GET /v2/book/isbn/:name
	DoubanBook getBookInfo(String isbn);

	// GET https://api.douban.com/v2/book/search
	DoubanBooks getBooksSearch(String query, String tag, int start, int count);

	// POST https://api.douban.com/v2/book/reviews
	DoubanBookReview writeBookReview(long bookId, String title, String content,
			int rate);

	// PUT https://api.douban.com/v2/book/review/:id
	DoubanBookReview updateBookReview(long reviewId, String title,
			String content, int rate);

	// DELETE https://api.douban.com/v2/book/review/:id
	DoubanBookReview deleteBookReview(long reviewId);

	// GET https://api.douban.com/v2/book/user/:name/annotations
	DoubanBookAnnotations getBookAnnotations(String userName);

	// GET https://api.douban.com/v2/book/:id/annotations
	DoubanBookAnnotations getBookAnnotations(long bookId, String order,
			String format);

	// GET https://api.douban.com/v2/book/annotation/:id
	DoubanBookAnnotation getBookAnnotation(long annotationId);

	// POST https://api.douban.com/v2/book/:id/annotations
	DoubanBookAnnotation writeBookAnnotation(long bookId, String content,
			String chapter, String privacy, int page);

	// PUT https://api.douban.com/v2/book/annotation/:id
	DoubanBookAnnotation updateBookAnnotation(long annotationId,
			String content, String chapter, String privacy, int page);

	// DELETE https://api.douban.com/v2/book/annotation/:id
	DoubanBookAnnotation deleteBookAnnotation(long annotationId);

	// GET https://api.douban.com/v2/book/user/:name/collections
	DoubanBookCollection getBookCollection(String userName, String status,
			String from, String to, int rate);

	// GET https://api.douban.com/v2/book/:id/collection
	DoubanBookCollectionItem getBookCollectionItem(long bookId);

	// POST https://api.douban.com/v2/book/:id/collection
	DoubanBookCollectionItem addBookCollectionItem(long bookId, String status,
			String comment, String privacy, int rate);

	// PUT https://api.douban.com/v2/book/:id/collection
	DoubanBookCollectionItem updateBookCollectionItem(long bookId,
			String status, String comment, String privacy, int rate);

	// DELETE https://api.douban.com/v2/book/:id/collection
	DoubanBookCollectionItem deleteBookCollectionItem(long bookId);
}

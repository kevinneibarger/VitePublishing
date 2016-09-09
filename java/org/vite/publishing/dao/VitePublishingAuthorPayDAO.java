/**
 * 
 */
package org.vite.publishing.dao;

import java.util.List;

import org.vite.publishing.bean.VitePublishingAuthorPay;

/**
 * @author Kevin Neibarger
 *
 */
public interface VitePublishingAuthorPayDAO {
	
	void save(VitePublishingAuthorPay vpAuthor);
	void update(VitePublishingAuthorPay vpAuthor);
	void delete(VitePublishingAuthorPay vpAuthor);
	List<VitePublishingAuthorPay> getAuthorsFromPayDB();
	VitePublishingAuthorPay getAuthorById(long authorId);

}

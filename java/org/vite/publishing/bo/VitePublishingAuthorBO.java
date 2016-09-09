package org.vite.publishing.bo;

import java.util.List;

import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingSpotlightAuthor;

public interface VitePublishingAuthorBO {
	
	void save(VitePublishingAuthor vpAuthor);
	void update(VitePublishingAuthor vpAuthor);
	void delete(VitePublishingAuthor vpAuthor);
	
	VitePublishingAuthor getAuthorById(long authorId);
	List<VitePublishingSpotlightAuthor> getSpotlightAuthors();
	List<VitePublishingAuthor> getAuthors();
	List<VitePublishingAuthor> getAuthors(String letter);
	List<VitePublishingBooks> getCategories(String letter);
}

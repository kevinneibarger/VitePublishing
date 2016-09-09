package org.vite.publishing.dao;

import java.util.List;

import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingSpotlightAuthor;

public interface VitePublishingAuthorDAO {
	
	void save(VitePublishingAuthor vpAuthor);
	void update(VitePublishingAuthor vpAuthor);
	void delete(VitePublishingAuthor vpAuthor);
	List<VitePublishingAuthor> getAuthors();
	VitePublishingAuthor getAuthorById(long authorId);
	
	List<VitePublishingAuthor> getAuthorByLastName(String lastName);
	List<VitePublishingAuthor> getAuthorByFullName(String firstName, String lastName);
	
	List<VitePublishingSpotlightAuthor> getSpotlightAuthors();
	List<VitePublishingAuthor> getAuthors(String letter);
	List<VitePublishingBooks> getCategories(String letter);
}

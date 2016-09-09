package org.vite.publishing.dao;

import java.util.List;

import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingBookshelf;

public interface VitePublishingBookshelfDAO {

	void save(VitePublishingBookshelf fullBook);
	void update(VitePublishingBookshelf fullBook);
	void delete(VitePublishingBookshelf fullBook);
	
	VitePublishingBookshelf getBookFromBookshelfById(long bookId);
	void openBook(VitePublishingBookshelf openBook);
	
	List<VitePublishingBookshelf> getBookshelfByReaderId(long readerId);
	
	VitePublishingBookshelf getBookshelfBookByReader(long readerId, long bookId);
	void buyFullBook(long readerId, long bookId);
}

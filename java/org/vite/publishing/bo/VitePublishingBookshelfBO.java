package org.vite.publishing.bo;

import java.util.List;

import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingBookshelf;

public interface VitePublishingBookshelfBO {

	void save(VitePublishingBookshelf vpFBBook);
	void update(VitePublishingBookshelf vpFBBook);
	void delete(VitePublishingBookshelf vpFBBook);
	
	VitePublishingBookshelf getBookFromBookshelfById(long bookId);
	
	List<VitePublishingBooks> getBooksOnBookshelf(long readerId, boolean isFullBook);
	void buyFullBook(long readerId, long bookId);
}

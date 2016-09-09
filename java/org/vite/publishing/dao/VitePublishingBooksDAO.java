package org.vite.publishing.dao;

import java.sql.Timestamp;
import java.util.List;

import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingChapters;
import org.vite.publishing.bean.VitePublishingReadFirstBook;

public interface VitePublishingBooksDAO {

	void save(VitePublishingBooks book);
	void update(VitePublishingBooks book);
	void delete(VitePublishingBooks book);
	
	VitePublishingBooks getBookById(long bookId);
	List<VitePublishingBooks> getBookByAuthor(long authorId);
	List<VitePublishingBooks> getBooksByCategory(String category);
	List<VitePublishingBooks> getBooksBySubCategory(String subCategory);
	List<VitePublishingBooks> getBooksByPublishedDate(Timestamp date);
	List<VitePublishingBooks> getBooksBySubmittedDate(Timestamp date);
	List<VitePublishingBooks> getNewestBooks();
	List<String> getAllCategories();
	List<VitePublishingReadFirstBook> getReadFirstBooks(List<String> allCategories);
	List<VitePublishingChapters> getAllChaptersByBookId(long bookId);
	StringBuilder getChapterText(long bookId, String chapterNum);
	List<VitePublishingBooks> getBookParag();
}

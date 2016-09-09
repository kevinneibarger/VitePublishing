/**
 * 
 */
package org.vite.publishing.util;

import java.util.List;

import junit.framework.Assert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingBookshelf;
import org.vite.publishing.bean.VitePublishingChapters;
import org.vite.publishing.bean.VitePublishingReadFirstBook;
import org.vite.publishing.bean.VitePublishingSpotlightAuthor;
import org.vite.publishing.bo.VitePublishingAuthorBO;
import org.vite.publishing.bo.VitePublishingBooksBO;
import org.vite.publishing.bo.VitePublishingBookshelfBO;

/**
 * @author Kevin Neibarger
 *
 */
public class VitePublishingTestDriver {
	  
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"config/beanlocations.xml");

//		// Get Spotlight Authors
//		VitePublishingAuthorBO vpAuthorBo = (VitePublishingAuthorBO)appContext.getBean("vpAuthorBo"); 
//		List<VitePublishingSpotlightAuthor> spotlightAuthors = vpAuthorBo.getSpotlightAuthors();
//		
//		for (VitePublishingSpotlightAuthor spotAuth : spotlightAuthors) {
//			System.out.println("Author: "+spotAuth.getAuthor().getFirstName()+" "+spotAuth.getAuthor().getLastName()+" Has: "+spotAuth.getBookCount()+" Books!");
//		}
		
		// Get Newest Books
		VitePublishingBooksBO booksBo = (VitePublishingBooksBO)appContext.getBean("vpBooksBo");
		VitePublishingBookshelfBO bookShelfBO = (VitePublishingBookshelfBO)appContext.getBean("vpBookshelfBo");
		
		// Get all full books on bookshelf
		List<VitePublishingBooks> getFullBooks = bookShelfBO.getBooksOnBookshelf(10000003, true);
		
		// Get all half books on bookshelf
		List<VitePublishingBooks> getHalfBooks = bookShelfBO.getBooksOnBookshelf(10000003, false);
		
		if (getFullBooks != null && getFullBooks.size() > 0) {
			
			for (VitePublishingBooks fullBook : getFullBooks) {
				System.out.println("Full BOOK: "+fullBook.getBookTitle());
			}
		}
		
		if (getHalfBooks != null && getHalfBooks.size() > 0) {
			
			for (VitePublishingBooks halfBook : getHalfBooks) {
				System.out.println("Half BOOK: "+halfBook.getBookTitle());
			}
		}
		
//		// Get 5 newest books by publish date
//		List<VitePublishingBooks> getNewestBooks = booksBo.getNewestBooks();
//		
//		Assert.assertNotNull(getNewestBooks);
//		
//		if (getNewestBooks != null) {
//			
//			if (getNewestBooks.size() == 0) {
//				
//				System.out.println("\n There are No new books published today!");
//			} else {
//				
//				for (VitePublishingBooks book : getNewestBooks) {
//					System.out.println("\n ------- BOOK TITLE: "+book.getBookTitle()+" -----");
//					System.out.println(" ------- BOOK SUMMARY: "+book.getBookSummary()+" -----");
//					System.out.println(" ------- AUTHOR: "+book.getAuthor().getFirstName()+" "+book.getAuthor().getLastName()+" -----");
//					System.out.println(" ------- DATE SUBMITTED: "+book.getSubmittedDate()+" -----");
//					System.out.println(" ------- DATE PUBLISHED: "+book.getPublishedDate()+" -----");
//				}
//			}
//			
//		}
//		
//		// Test new Bookshelf
//		VitePublishingBookshelfBO bookshelfBo = (VitePublishingBookshelfBO)appContext.getBean("vpBookshelfBo");
//		VitePublishingBookshelf bookFromBShelf = bookshelfBo.getBookFromBookshelfById(50000008);
//		
//		if (bookFromBShelf != null) {
//			System.out.println("BOOK\n"+bookFromBShelf.toString());
//		} else {
//			System.out.println("BOOK with ID = 6001 DOES NOT Exist!");
//		}
//		
//		List<String> getCategories = booksBo.getAllCategories();
//		
//		if (getCategories != null && getCategories.size() >0) {
//			
//			for (String cat : getCategories) {
//				System.out.println("Category: "+cat);
//			}
//		}
//		
//		
//		// Get Read First Books
//		List<VitePublishingReadFirstBook> readFirstBooks = booksBo.getReadFirstBooks(getCategories);
//		if (readFirstBooks != null && readFirstBooks.size() > 0) {
//			
//			for (VitePublishingReadFirstBook readMe : readFirstBooks) {
//				System.out.println("CATEGORY: "+readMe.getCategory());
//				System.out.println("CATEGORY COUNT: "+readMe.getCategoryCount());
//				System.out.println("BOOK TITLE: "+readMe.getBook().getBookTitle());
//			}
//		}
//		
//		// Get All Chapters for book
//		List<VitePublishingChapters> allBookChaptersById = booksBo.getAllChaptersByBookId(50000008);
//		if (allBookChaptersById != null && allBookChaptersById.size() > 0) {
//			
//			VitePublishingBooks book = booksBo.getBookById(50000008);
//			System.out.println("---------------------------------------------");
//			System.out.println("BOOK NAME: "+book.getBookTitle());
//			
//			for (VitePublishingChapters chapter : allBookChaptersById) {
//				
//				System.out.println("CHAPTER NAME: "+chapter.getChapterName());
//				System.out.println("CHAPTER NUM: "+chapter.getChapterNum());
//				
//			}
//			System.out.println("---------------------------------------------");
//		}
		
		// build a pdf for a given Chapter
		//booksBo.buildChaptersToPDF(50000008, "2", "Chapter 2");
	}
}

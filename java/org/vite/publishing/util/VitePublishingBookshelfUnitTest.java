package org.vite.publishing.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingBookshelfRow;
import org.vite.publishing.bo.VitePublishingBooksBO;
import org.vite.publishing.bo.VitePublishingBookshelfBO;

import junit.framework.Assert;

public class VitePublishingBookshelfUnitTest {

	VitePublishingBooksBO booksBo;
	
	VitePublishingBookshelfBO bookShelfBO;
	
	
	@Before
	public void setUp() throws Exception {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"config/beanlocations.xml");
		
		booksBo = (VitePublishingBooksBO)appContext.getBean("vpBooksBo");
		bookShelfBO = (VitePublishingBookshelfBO)appContext.getBean("vpBookshelfBo");
	}

	@Test
	public void test() {
		
		//VitePublishingBooks book = booksBo.getBookById(10001);
		//Assert.assertNotNull(book);
		List<VitePublishingBooks> booksByCat = booksBo.getBooksByCategory("Sci");
		
		if (booksByCat != null && booksByCat.size() > 0) {
			
			for (VitePublishingBooks book : booksByCat) {
				System.out.println("Book Title: "+book.getBookTitle()+" Author: "+book.getAuthor().getFirstName()+ " "+book.getAuthor().getLastName());
			}
		} else {
			System.out.println("There are NO Books with the category you selected");
		}
		Assert.assertNotNull(booksByCat);
		
		List<VitePublishingBooks> booksBySubCat = booksBo.getBooksBySubCategory("Non-Fiction");
		Assert.assertNotNull(booksBySubCat);
		
		if (booksBySubCat != null && booksBySubCat.size() > 0) {
			
			for (VitePublishingBooks book : booksBySubCat) {
				System.out.println("Book Title: "+book.getBookTitle()+" Published Date: "+book.getPublishedDate());
			}
		}
		
	}

	@Test
	public void testNewestBooks() {
		
		// Get 5 newest books by publish date
		List<VitePublishingBooks> getNewestBooks = booksBo.getNewestBooks();
		
		Assert.assertNotNull(getNewestBooks);
		
		if (getNewestBooks != null) {
			
			if (getNewestBooks.size() == 0) {
				
				System.out.println("\n There are No new books published today!");
			} else {
				
				for (VitePublishingBooks book : getNewestBooks) {
					System.out.println("\n ------- BOOK TITLE: "+book.getBookTitle()+" -----");
					System.out.println(" ------- BOOK SUMMARY: "+book.getBookSummary()+" -----");
					System.out.println(" ------- AUTHOR: "+book.getAuthor().getFirstName()+" "+book.getAuthor().getLastName()+" -----");
					System.out.println(" ------- DATE SUBMITTED: "+book.getSubmittedDate()+" -----");
					System.out.println(" ------- DATE PUBLISHED: "+book.getPublishedDate()+" -----");
				}
			}
			
		}
	}
	
	@Test
	public void testBookshelfRowBuilder() {
		
		String readerId = "10000003";
		int count = 1;
		
		// Get all full books on bookshelf
		//List<VitePublishingBooks> getFullBooks = bookShelfBO.getBooksOnBookshelf(new Long(readerId).longValue(), true);
		List<VitePublishingBooks> getFullBooks = buildBookshelf();
		
		if (getFullBooks != null) {
			
			List<VitePublishingBookshelfRow> bookShelfRows = buildBookshelfRows(getFullBooks);
			
			for (VitePublishingBookshelfRow row : bookShelfRows) {
				System.out.println("Title Book 1 -> "+row.getBook1().getBookTitle());
				System.out.println("Title Book 2 -> "+row.getBook2().getBookTitle());
				System.out.println("Title Book 3 -> "+row.getBook3().getBookTitle());
				System.out.println("Number of Books In Row: "+row.getNumBooksInRow());
			}
		}
	}
	
	private List<VitePublishingBookshelfRow> buildBookshelfRows(List<VitePublishingBooks> books) {
		
		List<VitePublishingBookshelfRow> bookShelfRows = null;
		int numBooksInRow = 0;
		
		if (books != null) {
			bookShelfRows = new ArrayList<VitePublishingBookshelfRow>();
			VitePublishingBooks book1 = null;
			VitePublishingBooks book2 = null;
			VitePublishingBooks book3 = null;
			VitePublishingBookshelfRow bookshelfRow = null;
			
			if (books.size() <= 3) {
				System.out.println("Bookshelf has LESS THAN OR EQUAL to 3 books!");
				
				bookshelfRow = new VitePublishingBookshelfRow();
				
				if (books.size() == 1) {
					book1 = books.get(0);
					book2 = new VitePublishingBooks();
					book3 = new VitePublishingBooks();
					numBooksInRow = 1;
				} 
				
				if (books.size() == 2) {
					book1 = books.get(0);
					book2 = books.get(1);
					book3 = new VitePublishingBooks();
					numBooksInRow = 2;
				} 
				
				if (books.size() == 3) {
					book1 = books.get(0);
					book2 = books.get(1);
					book3 = books.get(2);
					numBooksInRow = 3;
				} 
				
				bookshelfRow.setBook1(book1);
				bookshelfRow.setBook2(book2);
				bookshelfRow.setBook3(book3);
				bookshelfRow.setNumBooksInRow(numBooksInRow);
				bookShelfRows.add(bookshelfRow);
				
			} else {
				System.out.println("Bookshelf has MORE THAN 3 books!");
				
				int currentLoopIndx = 0;
				int bookOneIndx = 0;
				int bookTwoIndx = 0;
				int bookThreeIndx = 0;
				
				int n = books.size() / 2;
				for (int i = 0; i < n; i++) {
					
					bookshelfRow = new VitePublishingBookshelfRow();
					
//					System.out.println("******* CURRENT LOOP INDEX: "+currentLoopIndx+" *****************");
//					System.out.println("******* BOOK 1 INDEX: "+bookOneIndx+" *****************");
//					System.out.println("******* BOOK 2 INDEX: "+bookTwoIndx+" *****************");
//					System.out.println("******* BOOK 3 INDEX: "+bookThreeIndx+" *****************");
					
					if (i % 3 == 0) {
						//System.out.println("Multiple of 3? "+currentLoopIndx+" % 3 == "+(currentLoopIndx % 3));
						//bookOneIndx = i * 2 + 1;
						//bookTwoIndx = i * 2 + 2;
						//bookThreeIndx = i * 2 + 3;
						
						if (i == 0) {
							bookOneIndx = currentLoopIndx;
							bookTwoIndx = currentLoopIndx + 1;
							bookThreeIndx = currentLoopIndx + 2;
						} else {
							bookOneIndx = currentLoopIndx + 1;
							bookTwoIndx = currentLoopIndx + 2;
							bookThreeIndx = currentLoopIndx + 3;
						}
						
					} else {
						//System.out.println("NOT Multiple of 3 "+currentLoopIndx+" % 3 == "+(currentLoopIndx % 3));
						//bookOneIndx = i * 2;
						//bookTwoIndx = i * 2 + 1;
						//bookThreeIndx = i * 2 + 2;	
						
						bookOneIndx = currentLoopIndx;
						//System.out.println("******* GETTING BOOK 1 INDEX - Not a multiple of 3: "+bookOneIndx+" *****************");
						bookTwoIndx = currentLoopIndx + 1;
						bookThreeIndx = currentLoopIndx + 2;	
						
					}	
					
					currentLoopIndx = bookThreeIndx+1;
					
					
					//System.out.println("******* CURRENT LOOP INDEX: "+currentLoopIndx+" *****************");
//					System.out.println("******* BOOK 1 INDEX: "+bookOneIndx+" *****************");
//					System.out.println("******* BOOK 2 INDEX: "+bookTwoIndx+" *****************");
//					System.out.println("******* BOOK 3 INDEX: "+bookThreeIndx+" *****************");
					
					
					if (bookOneIndx < books.size()) {
						//System.out.println("******* GETTING BOOK 1 INDEX: "+bookOneIndx+" *****************");
						//System.out.println(books.get(bookOneIndx).getBookTitle());
						book1 = books.get(bookOneIndx);
					} else {
						book1 = new VitePublishingBooks();
					}
					
					if (bookTwoIndx < books.size()) {
						//System.out.println("******* GETTING BOOK 2 INDEX: "+bookTwoIndx+" *****************");
						//System.out.println(books.get(bookTwoIndx).getBookTitle());
						book2 = books.get(bookTwoIndx);
					} else {
						book2 = new VitePublishingBooks();
					}
					
					if (bookThreeIndx < books.size()) {
						//System.out.println("******* GETTING BOOK 3 INDEX: "+bookThreeIndx+" *****************");
						//System.out.println(books.get(bookThreeIndx).getBookTitle());
						book3 = books.get(bookThreeIndx);
					} else {
						book3 = new VitePublishingBooks();
					}
					
					bookshelfRow.setBook1(book1);
					bookshelfRow.setBook2(book2);
					bookshelfRow.setBook3(book3);
					
					if (book1.getBookTitle() != null && book2.getBookTitle() == null && book3.getBookTitle() == null) {
						numBooksInRow = 1;
					} else if (book1.getBookTitle() != null && book2.getBookTitle() != null && book3.getBookTitle() == null) {
						numBooksInRow = 2;
					} else if (book1.getBookTitle() != null && book2.getBookTitle() != null && book3.getBookTitle() != null) {
						numBooksInRow = 3;
					} else {
						numBooksInRow = 0;
					}
					bookshelfRow.setNumBooksInRow(numBooksInRow);
					bookShelfRows.add(bookshelfRow);

				}
			}
		}
		
		return bookShelfRows;
	}
	
	private List<VitePublishingBooks> buildBookshelf() {
		
		List<VitePublishingBooks> books = new ArrayList<VitePublishingBooks>();
		
		VitePublishingBooks book = null;
		
		for (int i = 0; i < 1; i++) {
			book = new VitePublishingBooks();
			book.setAuthor(new VitePublishingAuthor());
			book.setAuthorId(0);
			book.setBookId(randInt(0, 50000));
			book.setBookSummary("Test Book Summary"+(i+1));
			book.setBookTitle("Test Book "+(i+1));
			book.setCategory("Fiction");
			book.setUiApproved("Yes");
			book.setCmsApprover("Approved");
			book.setHalfBookChptr(2);
			book.setPublishedDate(new Timestamp(System.currentTimeMillis()));
			book.setSubmittedDate(new Timestamp(System.currentTimeMillis()));
			books.add(book);
		}
		
		return books;
	}
	
	private int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}

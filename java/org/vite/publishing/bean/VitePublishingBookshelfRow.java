/**
 * 
 */
package org.vite.publishing.bean;

import java.io.Serializable;

/**
 * @author kevinscomp
 *
 */
public class VitePublishingBookshelfRow implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private VitePublishingBooks book1;
	private VitePublishingBooks book2;
	private VitePublishingBooks book3;
	private long book1CurrChapter;
	private long book2CurrChapter;
	private long book3CurrChapter;
	private int numBooksInRow;
	
	public VitePublishingBooks getBook1() {
		return book1;
	}
	public void setBook1(VitePublishingBooks book1) {
		this.book1 = book1;
	}
	public VitePublishingBooks getBook2() {
		return book2;
	}
	public void setBook2(VitePublishingBooks book2) {
		this.book2 = book2;
	}
	public VitePublishingBooks getBook3() {
		return book3;
	}
	public void setBook3(VitePublishingBooks book3) {
		this.book3 = book3;
	}

	public String toString() {
		
		StringBuilder bld = new StringBuilder();
		
		if (book1 != null) {
			bld.append("Book 1: "+book1.getBookTitle());
		}
		
		if (book2 != null) {
			bld.append("Book 2: "+book2.getBookTitle());
		}

		if (book3 != null) {
			bld.append("Book 3: "+book3.getBookTitle());
		}
		
		bld.append("Number of Books in Row: "+numBooksInRow);
		
		return bld.toString();
	}
	public int getNumBooksInRow() {
		return numBooksInRow;
	}
	public void setNumBooksInRow(int numBooksInRow) {
		this.numBooksInRow = numBooksInRow;
	}
	public long getBook1CurrChapter() {
		return book1CurrChapter;
	}
	public void setBook1CurrChapter(long book1CurrChapter) {
		this.book1CurrChapter = book1CurrChapter;
	}
	public long getBook2CurrChapter() {
		return book2CurrChapter;
	}
	public void setBook2CurrChapter(long book2CurrChapter) {
		this.book2CurrChapter = book2CurrChapter;
	}
	public long getBook3CurrChapter() {
		return book3CurrChapter;
	}
	public void setBook3CurrChapter(long book3CurrChapter) {
		this.book3CurrChapter = book3CurrChapter;
	}
}

/**
 * 
 */
package org.vite.publishing.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Kevin Neibarger
 *
 */
@Entity
@Table (name = "v_r_bookshelf")
public class VitePublishingBookshelf implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long fullBookId;
	private long readerId; //Foreign key
	private long bookId;   // Foreign key
	private String currentChptr;
	private String bookStatus;
	private String shelfStatus;
	private Timestamp lastOpened;
	private String transactionId;
	private String transactionDate;
	private String bookCost;
	
	private VitePublishingReader reader;
	private VitePublishingBooks book;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FULL_BOOK_ID", unique = true, nullable = false)
	public long getFullBookId() {
		return fullBookId;
	}
	public void setFullBookId(long fullBookId) {
		this.fullBookId = fullBookId;
	}
	
	@Column(name = "READER_ID", unique = true, nullable = false)
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "READER_ID", referencedColumnName = "READER_ID", insertable = false, updatable = false)
	public VitePublishingReader getReader() {
		return this.reader;
	}
	
	@Column(name = "BOOK_ID", unique = true, nullable = false)
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID", insertable = false, updatable = false)
	public VitePublishingBooks getBook() {
		return this.book;
	}
	
	@Column(name = "CURRENT_CHPTR", unique = true, nullable = false, length = 30)
	public String getCurrentChptr() {
		return currentChptr;
	}
	public void setCurrentChptr(String currentChptr) {
		this.currentChptr = currentChptr;
	}
	
	@Column(name = "BOOK_STATUS", unique = true, nullable = false, length = 20)
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	
	@Column(name = "LAST_OPENED", unique = true, nullable = false)
	public Timestamp getLastOpened() {
		return lastOpened;
	}
	public void setLastOpened(Timestamp lastOpened) {
		this.lastOpened = lastOpened;
	}
	
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false, length = 50)
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	@Column(name = "TRANSACTION_DATE", unique = true)
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Column(name = "BOOK_COST", unique = true, length = 10)
	public String getBookCost() {
		return bookCost;
	}
	public void setBookCost(String bookCost) {
		this.bookCost = bookCost;
	}

	public String toString() {
		
		return "Full Book ID: "+fullBookId+"\nReader ID: "+readerId+"\nBook ID: "+bookId+
				"\nCurrent Chapter: "+currentChptr+"\n Book Status: "+bookStatus+"\nLast Opened: "+lastOpened+
				"\nTransaction ID: "+transactionId+"\nTransaction Date: "+transactionDate+"\nBook Cost: "+bookCost;
	}
	public void setReader(VitePublishingReader reader) {
		this.reader = reader;
	}
	public void setBook(VitePublishingBooks book) {
		this.book = book;
	}
	
	@Column(name = "SHELF_STATUS", unique = true, nullable = false, length = 25)
	public String getShelfStatus() {
		return shelfStatus;
	}
	public void setShelfStatus(String shelfStatus) {
		this.shelfStatus = shelfStatus;
	}
}

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

@Entity
@Table (name = "v_cms_financials")
public class VitePublishingCMSFinancials implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long financialsId;
	private String transactionId;
	private Timestamp transactionDate;
	private String dollarAmt;
	private long readerId; // Foreign Key
	private long bookId; // Foreign Key
	
	private VitePublishingReader reader;
	private VitePublishingBooks book;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FINANCIALS_ID", unique = true, nullable = false)
	public long getFinancialsId() {
		return financialsId;
	}
	public void setFinancialsId(long financialsId) {
		this.financialsId = financialsId;
	}
	
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false, length = 50)
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	@Column(name = "TRANSACTION_DATE", unique = true, nullable = false)
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	@Column(name = "DOLLAR_AMT", unique = true, nullable = false, length = 50)
	public String getDollarAmt() {
		return dollarAmt;
	}
	public void setDollarAmt(String dollarAmt) {
		this.dollarAmt = dollarAmt;
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

	public String toString() {
		
		return "Financials ID: "+financialsId+"\nTransaction ID: "+transactionId
				+"\nTransaction Date: "+transactionDate+"\nDollar Amount: "+dollarAmt+
				"\nReader ID: "+readerId+"\nBook ID: "+bookId;
	}
	public void setReader(VitePublishingReader reader) {
		this.reader = reader;
	}
	public void setBook(VitePublishingBooks book) {
		this.book = book;
	}
}

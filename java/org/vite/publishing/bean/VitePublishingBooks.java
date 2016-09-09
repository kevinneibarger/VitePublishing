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
 * @author HB17217
 *
 */
@Entity
@Table (name = "v_b_books")
public class VitePublishingBooks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long bookId;
	private String bookTitle;
	private String bookSummary;
	private String category;
	private String subCategory;
	private long authorId;  // Foreign key
	private long halfBookChptr;
	private String uiApproved;
	private Timestamp submittedDate;
	private Timestamp publishedDate;
	private String cmsApprover;
	
	private VitePublishingAuthor author;
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "BOOK_ID", unique = true, nullable = false)
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	
	@Column(name = "BOOK_SUMMARY", unique = true, nullable = false, length = 250)
	public String getBookSummary() {
		return bookSummary;
	}
	public void setBookSummary(String bookSummary) {
		this.bookSummary = bookSummary;
	}
	
	@Column(name = "CATEGORY", unique = true, nullable = false, length = 100)
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Column(name = "SUB_CATEGORY", unique = true, nullable = false, length = 100)
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "AUTHOR_ID", insertable = false, updatable = false)
	public VitePublishingAuthor getAuthor() {
		return author;
	}
	
	@Column(name = "AUTHOR_ID", unique = true, nullable = false)
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	
	@Column(name = "UI_APPROVED", unique = true, nullable = false, length = 20)
	public String getUiApproved() {
		return uiApproved;
	}
	public void setUiApproved(String uiApproved) {
		this.uiApproved = uiApproved;
	}
	
	@Column(name = "SUBMITTED_DATE", unique = true, nullable = false)
	public Timestamp getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}
	
	@Column(name = "PUBLISHED_DATE", unique = true)
	public Timestamp getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Timestamp publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	@Column(name = "CMS_APPROVER", unique = true, nullable = false, length = 150)
	public String getCmsApprover() {
		return cmsApprover;
	}
	public void setCmsApprover(String cmsApprover) {
		this.cmsApprover = cmsApprover;
	}
	
	@Column(name = "BOOK_TITLE", unique = true, nullable = false, length = 250)
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	
	public String toString() {
		
		return "Book ID: "+bookId+"\nBook Title: "+bookTitle+"\nBook Summary: "+bookSummary+
			   "\nCategory: "+category+"\nSub Category: "+subCategory+"\nAuthor ID: "+authorId+
			   "\nUI Approved: "+uiApproved+"\nSubmitted Date: "+submittedDate+"\nPublished Date: "+publishedDate+
			   "\nCMS Approver: "+cmsApprover;
	}
	public void setAuthor(VitePublishingAuthor author) {
		this.author = author;
	}
	
	@Column(name = "HALF_BOOK_CHPT", unique = true, nullable = false)
	public long getHalfBookChptr() {
		return halfBookChptr;
	}
	
	public void setHalfBookChptr(long halfBookChptr) {
		this.halfBookChptr = halfBookChptr;
	}
	
}

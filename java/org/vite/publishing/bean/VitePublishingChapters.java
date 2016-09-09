/**
 * 
 */
package org.vite.publishing.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

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
@Table (name = "v_b_chapters")
public class VitePublishingChapters implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long chaptersId;
	private long bookId;
	private String chapterNum;
	private String chapterName;
	private String chptContent;
	
	private VitePublishingBooks book;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CHAPTERS_ID", unique = true, nullable = false)
	public long getChaptersId() {
		return chaptersId;
	}
	public void setChaptersId(long chaptersId) {
		this.chaptersId = chaptersId;
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
	
	
	@Column(name = "CHAPTER_NUM", unique = true, nullable = false, length = 50)
	public String getChapterNum() {
		return chapterNum;
	}
	public void setChapterNum(String chapterNum) {
		this.chapterNum = chapterNum;
	}
	
	@Column(name = "CHAPTER_NAME", unique = true, nullable = false, length = 50)
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
	public String toString() {
		return "Chapters ID: "+chaptersId+"\nBook ID: "+bookId+"\nChapter Num: "+chapterNum+"\nChapter Name: "+chapterName;
	}
	public void setBook(VitePublishingBooks book) {
		this.book = book;
	}
	
	@Column(name = "CHPT_CONTENT", unique = true, nullable = false)
	public String getChptContent() {
		return chptContent;
	}
	public void setChptContent(String chptContent) {
		this.chptContent = chptContent;
	}
}

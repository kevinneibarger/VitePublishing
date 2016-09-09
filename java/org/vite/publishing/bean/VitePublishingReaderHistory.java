package org.vite.publishing.bean;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "v_r_reader_hst")
public class VitePublishingReaderHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long readerHistId;
	private long readerId;
	private Timestamp actionDate;
	private String actionType;
	private String actionDetail;
	private String bookId;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HISTORY_ID", unique = true, nullable = false)
	public long getReaderHistId() {
		return readerHistId;
	}
	public void setReaderHistId(long readerHistId) {
		this.readerHistId = readerHistId;
	}
	
	@Column(name = "READER_ID", unique = true, nullable = false)
	public long getReaderId() {
		return readerId;
	}
	public void setReaderId(long readerId) {
		this.readerId = readerId;
	}
	
	@Column(name = "ACTION_DATE", unique = true, nullable = false)
	public Timestamp getActionDate() {
		return actionDate;
	}
	public void setActionDate(Timestamp actionDate) {
		this.actionDate = actionDate;
	}
	
	@Column(name = "ACTION_TYPE", unique = true, nullable = false, length = 50)
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
	@Column(name = "ACTION_DETAILS", unique = true, nullable = false, length = 250)
	public String getActionDetail() {
		return actionDetail;
	}
	public void setActionDetail(String actionDetail) {
		this.actionDetail = actionDetail;
	}
	
	@Column(name = "BOOK_ID", unique = true, nullable = false)
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String toString() {
		
		return "History ID: "+readerHistId+"\nReader ID: "+readerId+"\nAction Date: "+actionDate+
				"\nAction Type: "+actionType+"\nAction Details: "+actionDetail+"\nBook ID:"+bookId;
	}
}

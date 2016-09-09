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
 * 
 */

/**
 * @author HB17217
 *
 */
@Entity
@Table (name = "v_b_read_chpt_one")
public class VitePublishingReadChapterOne implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long chapOneId;
	private long bookId;
	private String ipAddress;
	private String deviceId;
	
	private VitePublishingBooks book;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CHAP_ONE_ID", unique = true, nullable = false)
	public long getChapOneId() {
		return chapOneId;
	}
	public void setChapOneId(long chapOneId) {
		this.chapOneId = chapOneId;
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
	
	@Column(name = "IP_ADDRESS", unique = true, nullable = false, length = 20)
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	@Column(name = "DEVICE_ID", unique = true, nullable = false, length = 20)
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public String toString() {
		
		return "Chapter One ID: "+chapOneId+"\nBook ID: "+bookId+"\nIP Address: "+ipAddress+"\nDevice ID: "+deviceId;
	}
	public void setBook(VitePublishingBooks book) {
		this.book = book;
	}
}

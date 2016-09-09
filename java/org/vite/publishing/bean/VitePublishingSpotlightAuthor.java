/**
 * 
 */
package org.vite.publishing.bean;

import java.io.Serializable;

/**
 * @author Kevin Neibarger
 *
 */
public class VitePublishingSpotlightAuthor implements Serializable {

	private static final long serialVersionUID = 1L;
	private VitePublishingAuthor author;
	private long bookCount;
	
	public VitePublishingAuthor getAuthor() {
		return author;
	}
	public void setAuthor(VitePublishingAuthor author) {
		this.author = author;
	}
	public long getBookCount() {
		return bookCount;
	}
	public void setBookCount(long bookCount) {
		this.bookCount = bookCount;
	}

	public String toString() {
		return "\nAuthor: "+author.toString()+"\nBook Count: "+bookCount;
	}
}

/**
 * 
 */
package org.vite.publishing.bean;

import java.io.Serializable;

/**
 * @author Kevin Neibarger
 *
 */
public class VitePublishingReadFirstBook implements Serializable {

	private static final long serialVersionUID = 1L;
	private long categoryCount;
	private String category;
	private VitePublishingBooks book;
	
	public long getCategoryCount() {
		return categoryCount;
	}
	public void setCategoryCount(long categoryCount) {
		this.categoryCount = categoryCount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public VitePublishingBooks getBook() {
		return book;
	}
	public void setBook(VitePublishingBooks book) {
		this.book = book;
	}
}

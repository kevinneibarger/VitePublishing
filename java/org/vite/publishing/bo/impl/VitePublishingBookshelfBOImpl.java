package org.vite.publishing.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingBookshelf;
import org.vite.publishing.bo.VitePublishingBookshelfBO;
import org.vite.publishing.dao.VitePublishingBooksDAO;
import org.vite.publishing.dao.VitePublishingBookshelfDAO;
import org.vite.publishing.util.VitePublishingConstants;

@Service("vpBookshelfBo")
public class VitePublishingBookshelfBOImpl implements VitePublishingBookshelfBO {

	@Autowired
	VitePublishingBookshelfDAO vpBookshelfDao;
	
	@Autowired
	VitePublishingBooksDAO vpBooksDao;
	
	@Override
	public void save(VitePublishingBookshelf vpFBBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(VitePublishingBookshelf vpFBBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(VitePublishingBookshelf vpFBBook) {
		// TODO Auto-generated method stub

	}

	@Override
	public VitePublishingBookshelf getBookFromBookshelfById(long bookId) {
		return vpBookshelfDao.getBookFromBookshelfById(bookId);
	}

	@Override
	public List<VitePublishingBooks> getBooksOnBookshelf(long readerId, boolean isFullBook) {
		
		List<VitePublishingBookshelf> myBookshelf = vpBookshelfDao.getBookshelfByReaderId(readerId);
		List<VitePublishingBooks> books = new ArrayList<VitePublishingBooks>();
		
		if (myBookshelf != null && myBookshelf.size() > 0) {
			for (VitePublishingBookshelf book : myBookshelf) {
				if (isFullBook) {
					if (book != null && book.getBookStatus().equalsIgnoreCase(VitePublishingConstants.FULL_BOOK)) {
						books.add(vpBooksDao.getBookById(book.getBookId()));
					}
				} else {
					if (book != null && book.getBookStatus().equalsIgnoreCase(VitePublishingConstants.HALF_BOOK)) {
						books.add(vpBooksDao.getBookById(book.getBookId()));
					}
				}
			}
		}
		
		return books;
	}

	@Override
	public void buyFullBook(long readerId, long bookId) {
		vpBookshelfDao.buyFullBook(readerId, bookId);
	}
}

package org.vite.publishing.dao.impl;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingBookshelf;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingBookshelfDAO;

@Repository("vpBookshelfDao")
public class VitePublishingBookshelfDAOImpl extends CustomHibernateDaoSupport implements
		VitePublishingBookshelfDAO {

	@Override
	public void save(VitePublishingBookshelf fullBook) {
		getHibernateTemplate().save(fullBook);
	}

	@Override
	public void update(VitePublishingBookshelf fullBook) {
		getHibernateTemplate().update(fullBook);
	}

	@Override
	public void delete(VitePublishingBookshelf fullBook) {
		getHibernateTemplate().delete(fullBook);
	}

	@Override
	public VitePublishingBookshelf getBookFromBookshelfById(long bookId) {
		@SuppressWarnings("unchecked")
		List<VitePublishingBookshelf> list = getHibernateTemplate().find(
                "from VitePublishingBookshelf where bookId=?",bookId
           );
		
		if (list != null && list.size() > 0) {
			return (VitePublishingBookshelf)list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public void openBook(VitePublishingBookshelf openBook) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBookshelf> getBookshelfByReaderId(long readerId) {
		return getHibernateTemplate().find(
                "from VitePublishingBookshelf where readerId=?",readerId
           );
	}

	@Override
	public void buyFullBook(long readerId, long bookId) {
		// TODO Update query set book status = full, shelf status = yes and generate a transaction code
		VitePublishingBookshelf bookToBuy = getBookshelfBookByReader(readerId, bookId);
		bookToBuy.setBookStatus("Full");
		bookToBuy.setTransactionId(new Integer(randInt(1, 1000000000)).toString());
		
		// TODO: Set actual transaction date!
		//bookToBuy.setTransactionDate(new Long(System.currentTimeMillis()).toString());
		
		getHibernateTemplate().update(bookToBuy);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VitePublishingBookshelf getBookshelfBookByReader(long readerId, long bookId) {
		
		List<VitePublishingBookshelf> list = getHibernateTemplate().find(
                "from VitePublishingBookshelf where bookId=? and readerId=?",bookId, readerId);
		
		if (list != null && list.size() > 0) {
			return (VitePublishingBookshelf)list.get(0);
		} else {
			return null;
		}
	}

//	@Override
//	public void openBook(VitePublishingBookshelf openBook) {
//		//Update v_r_bookshelf SET CURRENT_CHPTR = {CHAPTER OPENED} where BOOK_ID={BOOK} and READER_ID = {READER_ID}
//		
//		VitePublishingBookshelf openedBook = new VitePublishingBookshelf();
//		openedBook.setCurrentChptr(openBook.getCurrentChptr());
//	}
	
	private int randInt(int min, int max) {

	    // Usually this can be a field rather than a method variable
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}

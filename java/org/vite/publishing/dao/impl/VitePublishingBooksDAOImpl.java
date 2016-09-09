package org.vite.publishing.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.sql.Connection;



import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingChapters;
import org.vite.publishing.bean.VitePublishingReadFirstBook;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingAuthorDAO;
import org.vite.publishing.dao.VitePublishingBooksDAO;

import java.sql.Statement;


@Repository("vpBooksDao")
public class VitePublishingBooksDAOImpl extends CustomHibernateDaoSupport implements VitePublishingBooksDAO {

	@Autowired
	private VitePublishingAuthorDAO authorDAO;
	
	@Override
	public void save(VitePublishingBooks book) {
		getHibernateTemplate().save(book);

	}

	@Override
	public void update(VitePublishingBooks book) {
		getHibernateTemplate().update(book);

	}

	@Override
	public void delete(VitePublishingBooks book) {
		getHibernateTemplate().delete(book);

	}

	@Override
	public VitePublishingBooks getBookById(long bookId) {
		@SuppressWarnings("unchecked")
		List<VitePublishingBooks> list = getHibernateTemplate().find(
                "from VitePublishingBooks where bookId=?",bookId
           );
		getHibernateTemplate().clear();
		return (VitePublishingBooks)list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBooks> getBookByAuthor(long authorId) {
		return getHibernateTemplate().find("from VitePublishingBooks where authorId=?", authorId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBooks> getBooksByCategory(String category) {
		return getHibernateTemplate().find("from VitePublishingBooks where category like '%"+category+"%'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBooks> getBooksBySubCategory(String subCategory) {
		return getHibernateTemplate().find("from VitePublishingBooks where subCategory like '%"+subCategory+"%'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBooks> getBooksByPublishedDate(Timestamp date) {
		return getHibernateTemplate().find("from VitePublishingBooks where publishedDate = ?", date);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBooks> getBooksBySubmittedDate(Timestamp date) {
		return getHibernateTemplate().find("from VitePublishingBooks where submittedDate = ?", date);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingBooks> getNewestBooks() {
		
		// This is a blecherous hack.. Since "someone" decided to use timestamps instead of dates, in order
		// for dates to match for newest books we've got to match down to the second. The following ignores
		// hour, minute and second since the database will most likely have year month day, and hour minute
		// second will be 00. 
		// Obtain our environment naming context
		/*Context initCtx;
		Connection conn = null;
		try {
			// Get a connection from the pool
			initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup("jdbc/viteDB");

			// Allocate and use a connection from the pool
		    conn =  ds.getConnection(); 

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		Date date = new Date(System.currentTimeMillis()); // timestamp now
		Calendar cal = Calendar.getInstance();       // get calendar instance
		cal.setTime(date);                           // set cal to date
		cal.set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
		cal.set(Calendar.MINUTE, 0);                 // set minute in hour
		cal.set(Calendar.SECOND, 0);                 // set second in minute
		cal.set(Calendar.MILLISECOND, 0);            // set millis in second

		Timestamp now = new Timestamp(cal.getTimeInMillis());

		//List<VitePublishingBooks> newBooks = new ArrayList<VitePublishingBooks>();
		
		List<VitePublishingBooks> returnNewest = new ArrayList<VitePublishingBooks>();
		/*try (Statement stm = conn.createStatement()) {			
			String query = "select * from v_b_books where ui_approved = 'Approved' order by published_date desc";			
			ResultSet rs = stm.executeQuery(query);
			//List<VitePublishingBooks> newBooks = stm.executeQuery(query);
			// Store and return result of the query
			//List<VitePublishingBooks> newBooks = new ArrayList();
			while (rs.next()) {
				VitePublishingBooks vitePubBooks = new VitePublishingBooks();
				vitePubBooks.setBookId(Long.parseLong(rs.getString("BOOK_ID")));
				vitePubBooks.setBookTitle("BOOK_TITLE");
				vitePubBooks.setBookSummary(rs.getString("BOOK_SUMMARY"));
				vitePubBooks.setCategory(rs.getString("CATEGORY"));
				vitePubBooks.setSubCategory(rs.getString("SUB_CATEGORY"));
				vitePubBooks.setAuthorId(Long.parseLong(rs.getString("AUTHOR_ID")));
				vitePubBooks.setHalfBookChptr(Long.parseLong(rs.getString("HALF_BOOK_CHPT")));
				vitePubBooks.setUiApproved(rs.getString("UI_APPROVED"));
				vitePubBooks.setSubmittedDate(Timestamp.valueOf(rs.getString("SUBMITTED_DATE")));
				vitePubBooks.setPublishedDate(Timestamp.valueOf(rs.getString("PUBLISHED_DATE")));
				vitePubBooks.setCmsApprover(rs.getString("CMS_APPROVER"));
				newBooks.add(vitePubBooks);
				
				System.out.println("The Books "+rs.getString("BOOK_ID"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			// Release connection back to the pool
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			conn = null; // prevent any future access
		}*/
			
		List<VitePublishingBooks> newBooks = 
				getHibernateTemplate().find("from VitePublishingBooks where uiApproved = 'Approved' order by publishedDate desc");

		if (newBooks != null && newBooks.size() > 0) {
			for (int i = 0; i < 5; i++) {
				returnNewest.add(newBooks.get(i));
			}
		}
        getHibernateTemplate().clear();
		return returnNewest;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getAllCategories() {
		return getHibernateTemplate().find("select DISTINCT c.category from VitePublishingBooks c where c.uiApproved = 'Approved'");
	}

	@SuppressWarnings("unchecked") 
	@Override
	public List<VitePublishingReadFirstBook> getReadFirstBooks(List<String> allCategories) {
		List<VitePublishingReadFirstBook> readFirstBooks = new ArrayList<VitePublishingReadFirstBook>();
		VitePublishingReadFirstBook firstBookByCat = new VitePublishingReadFirstBook();
		
		for (String category : allCategories) {
			
			List<VitePublishingBooks> booksByCatList = getBooksByCategory(category);
			List<Long> numCategory = getHibernateTemplate().find("select count(*) from VitePublishingBooks where category = ?", category);
			
			if (booksByCatList != null && booksByCatList.size() > 0) {
				// Get a random book in the category.
				Random rand = new Random();
				int randomNum = rand.nextInt((booksByCatList.size() - 0) + 1) + 0;
  
				firstBookByCat.setCategory(category);
				firstBookByCat.setCategoryCount((numCategory != null && numCategory.size()>0 ? numCategory.get(0) : 0));
				firstBookByCat.setBook((booksByCatList.size()-1 < randomNum ? booksByCatList.get(0) : booksByCatList.get(randomNum)));
				readFirstBooks.add(firstBookByCat);
				firstBookByCat = new VitePublishingReadFirstBook();
			}
		}
		getHibernateTemplate().clear();
		return readFirstBooks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingChapters> getAllChaptersByBookId(long bookId) {
		return getHibernateTemplate().find("from VitePublishingChapters where bookId = ? order by chapter_num asc", bookId);
	}

	@Override
	public StringBuilder getChapterText(long bookId, String chapterNum) {

		StringBuilder chapterText = new StringBuilder();
		@SuppressWarnings("unchecked")
		List<VitePublishingChapters> chapter = 
				getHibernateTemplate().find("from VitePublishingChapters where bookId = ? and chapterNum = ?", bookId, chapterNum);
		
		if (chapter != null && chapter.size() > 0) {
			chapterText.append(chapter.get(0).getChptContent());
		}
		getHibernateTemplate().clear();
		return chapterText;
	}

	@Override
	public List<VitePublishingBooks> getBookParag() {
		return getHibernateTemplate().loadAll(VitePublishingBooks.class);
	
	}
}

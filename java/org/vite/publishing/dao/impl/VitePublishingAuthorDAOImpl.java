package org.vite.publishing.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.expression.spel.ast.Projection;
import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingSpotlightAuthor;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingAuthorDAO;

@Repository("vpAuthorDao")
public class VitePublishingAuthorDAOImpl extends CustomHibernateDaoSupport implements VitePublishingAuthorDAO {
	
	@Override
	public void save(VitePublishingAuthor vpAuthor) {
		getHibernateTemplate().save(vpAuthor);
	}

	@Override
	public void update(VitePublishingAuthor vpAuthor) {
		getHibernateTemplate().update(vpAuthor);
	}

	@Override
	public void delete(VitePublishingAuthor vpAuthor) {
		getHibernateTemplate().delete(vpAuthor);
	}

	@Override
	public List<VitePublishingAuthor> getAuthors() {
		return getHibernateTemplate().loadAll(VitePublishingAuthor.class);
	}

	@Override
	public VitePublishingAuthor getAuthorById(long authorId) {
		return getHibernateTemplate().get(VitePublishingAuthor.class, authorId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingAuthor> getAuthorByLastName(String lastName) {
		return getHibernateTemplate().find(
                "from VitePublishingAuthor where lastName=?",lastName
           );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingAuthor> getAuthorByFullName(String firstName,
			String lastName) {
		return getHibernateTemplate().find("from VitePublishingAuthor where firstName=? and lastName=?", firstName, lastName);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VitePublishingSpotlightAuthor> getSpotlightAuthors() {
		
		/**Select AR.*, BK.book_cnt from (SELECT * FROM `V_A_AUTHOR` where AUTHOR_ID in (SELECT AUTHOR_ID From V_B_BOOKS where UI_APPROVED = 'Approved')) AR,(
SELECT AUTHOR_ID, COUNT(1) book_cnt From V_B_BOOKS where UI_APPROVED = 'Approved' group by AUTHOR_ID ) BK
WHERE AR.AUTHOR_ID = BK.AUTHOR_ID */
		
		// TODO: Get Author Id's by "Approved" from Book Table
		// TODO: Get count of total books by "Approved" author
		List<VitePublishingSpotlightAuthor> spotlightAuthors = new ArrayList<VitePublishingSpotlightAuthor>();
		VitePublishingSpotlightAuthor spotlightAuthor = null;
		
		DetachedCriteria criteria = DetachedCriteria.forClass(VitePublishingBooks.class);
		criteria.add(Restrictions.eq("uiApproved", "Approved"));
		List<VitePublishingBooks> approvedAuthors = getHibernateTemplate().findByCriteria(criteria);
		Set<Long> approvedAuthorIds = new HashSet<Long>();
		long recordLimit = 0;

		if (approvedAuthors != null && approvedAuthors.size() > 0) {
			for (VitePublishingBooks authorBookObj : approvedAuthors) {
				VitePublishingAuthor author = authorBookObj.getAuthor();
				approvedAuthorIds.add(author.getAuthorId());
			}
			
			Iterator<Long> it = approvedAuthorIds.iterator();
			while (it.hasNext()) {
				
				if (recordLimit >= 5) break;
				
				Long authorId = it.next();
				
				List<Long> bookCnt 
				= getHibernateTemplate().find("select count(*) from VitePublishingBooks where authorId = ? ", authorId);
		
				if (bookCnt != null && bookCnt.size() > 0) {
					spotlightAuthor = new VitePublishingSpotlightAuthor();
					spotlightAuthor.setAuthor(getAuthorById(authorId));
					spotlightAuthor.setBookCount(bookCnt.get(0));
				}
			
				spotlightAuthors.add(spotlightAuthor);
				
				recordLimit++;
			}
		}
		getHibernateTemplate().clear();
		Collections.shuffle(spotlightAuthors);
		return spotlightAuthors;
	}

	@Override
	public List<VitePublishingAuthor> getAuthors(String letter) {
		// TODO Auto-generated method stub
		List<VitePublishingAuthor> authorsByLetter = new ArrayList<VitePublishingAuthor>();
		VitePublishingAuthor authorsByLetterObject = null;

		if (letter.equals("all")) {
			return getHibernateTemplate().loadAll(VitePublishingAuthor.class);
		} else {
			DetachedCriteria criteria = DetachedCriteria.forClass(VitePublishingAuthor.class);
			criteria.add(Restrictions.ilike("firstName", letter+"%"));

			authorsByLetter = getHibernateTemplate().findByCriteria(criteria);
			if (authorsByLetter != null && authorsByLetter.size() > 0) {
				System.out.println("Got to this point with the authors ready to send back to the program!");
			}
			getHibernateTemplate().clear();
			return authorsByLetter;
		}
		
	}

	@Override
	public List<VitePublishingBooks> getCategories(String letter) {
		// TODO Auto-generated method stub
		List<VitePublishingBooks> categoriesByLetter = new ArrayList<VitePublishingBooks>();
		VitePublishingBooks categoriesByLetterObject = null;

		if (letter.equals("all")) {
			 categoriesByLetter = getHibernateTemplate().find("select distinct category from VitePublishingBooks");
			return categoriesByLetter;
			//getHibernateTemplate().loadAll(VitePublishingBooks.class);
		} else {
			DetachedCriteria criteria = DetachedCriteria.forClass(VitePublishingBooks.class);
			criteria.add(Restrictions.ilike("category", letter+"%"));

			categoriesByLetter = getHibernateTemplate().find("select distinct category from VitePublishingBooks where category like'"+letter+"%'");
			if (categoriesByLetter != null && categoriesByLetter.size() > 0) {
				System.out.println("Got to this point with the authors ready to send back to the program!");
			}
			getHibernateTemplate().clear();
			return categoriesByLetter;
		}
	}

}

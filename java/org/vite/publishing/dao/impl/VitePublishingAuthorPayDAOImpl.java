package org.vite.publishing.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingAuthorPay;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingAuthorPayDAO;

@Repository("vpAuthorPayDao")
public class VitePublishingAuthorPayDAOImpl extends CustomHibernateDaoSupport implements VitePublishingAuthorPayDAO {

	@Override
	public void save(VitePublishingAuthorPay vpAuthor) {
		getHibernateTemplate().save(vpAuthor);
	}

	@Override
	public void update(VitePublishingAuthorPay vpAuthor) {
		getHibernateTemplate().update(vpAuthor);
	}

	@Override
	public void delete(VitePublishingAuthorPay vpAuthor) {
		getHibernateTemplate().delete(vpAuthor);
	}

	@Override
	public List<VitePublishingAuthorPay> getAuthorsFromPayDB() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VitePublishingAuthorPay getAuthorById(long authorId) {
		// TODO Auto-generated method stub
		return null;
	}

}

package org.vite.publishing.dao.impl;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingChapters;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingChaptersDAO;

@Repository("vpChaptersDao")
public class VitePublishingChaptersDAOImpl extends CustomHibernateDaoSupport implements VitePublishingChaptersDAO {

	@Override
	public void save(VitePublishingChapters chapters) {
		getHibernateTemplate().save(chapters);
	}

	@Override
	public void update(VitePublishingChapters chapters) {
		getHibernateTemplate().update(chapters);
	}

	@Override
	public void delete(VitePublishingChapters chapters) {
		getHibernateTemplate().delete(chapters);
	}

}

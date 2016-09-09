package org.vite.publishing.dao.impl;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingReadChapterOne;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingReadChapterOneDAO;

@Repository("vpReadChptOneDao")
public class VitePublishingReadChapterOneDAOImpl extends CustomHibernateDaoSupport implements
		VitePublishingReadChapterOneDAO {

	@Override
	public void createReadHistory(VitePublishingReadChapterOne chptOne) {
		getHibernateTemplate().save(chptOne);
	}

	@Override
	public void update(VitePublishingReadChapterOne chptOne) {
		getHibernateTemplate().update(chptOne);
	}

	@Override
	public void delete(VitePublishingReadChapterOne chptOne) {
		getHibernateTemplate().delete(chptOne);
	}
}

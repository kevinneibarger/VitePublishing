package org.vite.publishing.dao.impl;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingReaderHistory;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingReaderHistoryDAO;

@Repository("vpReaderHistDao")
public class VitePublishingReaderHistoryDAOImpl extends CustomHibernateDaoSupport implements
		VitePublishingReaderHistoryDAO {

	@Override
	public void save(VitePublishingReaderHistory readerHist) {
		getHibernateTemplate().save(readerHist);
	}

	@Override
	public void update(VitePublishingReaderHistory readerHist) {
		getHibernateTemplate().update(readerHist);
	}

	@Override
	public void delete(VitePublishingReaderHistory readerHist) {
		getHibernateTemplate().delete(readerHist);

	}

}

package org.vite.publishing.dao.impl;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingCMSFinancials;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingCMSFinancialsDAO;

@Repository("vpCMSFinancialsDao")
public class VitePublishingCMSFinancialsDAOImpl extends CustomHibernateDaoSupport implements
		VitePublishingCMSFinancialsDAO {

	@Override
	public void save(VitePublishingCMSFinancials cmsFinancials) {
		getHibernateTemplate().save(cmsFinancials);
	}

	@Override
	public void update(VitePublishingCMSFinancials cmsFinancials) {
		getHibernateTemplate().update(cmsFinancials);
	}

	@Override
	public void delete(VitePublishingCMSFinancials cmsFinancials) {
		getHibernateTemplate().delete(cmsFinancials);
	}

}

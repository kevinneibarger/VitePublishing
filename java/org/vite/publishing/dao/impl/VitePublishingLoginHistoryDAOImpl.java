package org.vite.publishing.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingLoginHistory;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingLoginHistoryDAO;

@Repository("vpLoginHistDao")
public class VitePublishingLoginHistoryDAOImpl extends CustomHibernateDaoSupport implements VitePublishingLoginHistoryDAO {

	@Override
	public void save(VitePublishingLoginHistory vpLoginHist) {
		getHibernateTemplate().save(vpLoginHist);
	}

	@Override
	public void update(VitePublishingLoginHistory vpLoginHist) {
		getHibernateTemplate().update(vpLoginHist);	
	}

	@Override
	public void delete(VitePublishingLoginHistory vpLoginHist) {
		getHibernateTemplate().delete(vpLoginHist);
	}

	@Override
	public List<VitePublishingLoginHistory> getLoginHistory() {
		return getHibernateTemplate().loadAll(VitePublishingLoginHistory.class);
	}

	@Override
	public VitePublishingLoginHistory getLoginHistoryById(long historyId) {
		@SuppressWarnings("unchecked")
		List<VitePublishingLoginHistory> list = getHibernateTemplate().find(
                "from VitePublishingLoginHistory where historyId=?",historyId
           );
		
		if (list != null && list.size() > 0) {
			return (VitePublishingLoginHistory)list.get(0);
		} 
		
		return null;
	}

	@Override
	public VitePublishingLoginHistory getLoginHistoryByReaderId(long readerId) {
		@SuppressWarnings("unchecked")
		List<VitePublishingLoginHistory> list = getHibernateTemplate().find(
                "from VitePublishingLoginHistory where readerId=?",readerId
           );
		return (VitePublishingLoginHistory)list.get(0);
	}

}

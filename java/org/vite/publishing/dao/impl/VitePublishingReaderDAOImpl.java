package org.vite.publishing.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.vite.publishing.bean.VitePublishingReader;
import org.vite.publishing.dao.CustomHibernateDaoSupport;
import org.vite.publishing.dao.VitePublishingReaderDAO;

@Repository("vpReaderDao")
public class VitePublishingReaderDAOImpl extends CustomHibernateDaoSupport implements VitePublishingReaderDAO {

	@Override
	public void save(VitePublishingReader reader) {
		try {
			getHibernateTemplate().saveOrUpdate(reader);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(VitePublishingReader reader) {
		getHibernateTemplate().update(reader);
	}

	@Override
	public void delete(VitePublishingReader reader) {
		getHibernateTemplate().delete(reader);
	}

	@Override
	public VitePublishingReader getReaderById(long readerId) {
		@SuppressWarnings("unchecked")
		List<VitePublishingReader> list = getHibernateTemplate().find(
                "from VitePublishingReader where readerId=?",readerId
           );
		return (VitePublishingReader)list.get(0);
	}

	@Override
	public Integer checkUser(String fbId) {
		
		int retVal = 0;
		String hsql = "select facebookId "
				+ "from VitePublishingReader where facebookId = '"
				+ fbId + "'";

		List<String> users = getHibernateTemplate().find(hsql);

		if (!users.isEmpty()) {
			retVal = 1;
		}

		return retVal;

	}

}

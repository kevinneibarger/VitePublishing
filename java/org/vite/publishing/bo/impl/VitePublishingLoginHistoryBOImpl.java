/**
 * 
 */
package org.vite.publishing.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingLoginHistory;
import org.vite.publishing.bo.VitePublishingLoginHistoryBO;
import org.vite.publishing.dao.VitePublishingLoginHistoryDAO;

/**
 * @author Kevin Neibarger
 *
 */
@Service("vpLoginHistBo")
public class VitePublishingLoginHistoryBOImpl implements
		VitePublishingLoginHistoryBO {

	@Autowired
	VitePublishingLoginHistoryDAO vpLoginHistDao;
	
	/* (non-Javadoc)
	 * @see org.vite.publishing.dao.VitePublishingLoginHistoryDAO#getLoginHistory()
	 */
	@Override
	public List<VitePublishingLoginHistory> getLoginHistory() {
		return vpLoginHistDao.getLoginHistory();
	}

	@Override
	public void save(VitePublishingLoginHistory vpLoginHist) {
		vpLoginHistDao.save(vpLoginHist);
		
	}

	@Override
	public void update(VitePublishingLoginHistory vpLoginHist) {
		vpLoginHistDao.update(vpLoginHist);
	}

	@Override
	public void delete(VitePublishingLoginHistory vpLoginHist) {
		vpLoginHistDao.delete(vpLoginHist);
	}

	@Override
	public VitePublishingLoginHistory getLoginHistoryById(long historyId) {
		return vpLoginHistDao.getLoginHistoryById(historyId);
	}

	@Override
	public VitePublishingLoginHistory getLoginHistoryByReaderId(long readerId) {
		return vpLoginHistDao.getLoginHistoryByReaderId(readerId);
	}

}

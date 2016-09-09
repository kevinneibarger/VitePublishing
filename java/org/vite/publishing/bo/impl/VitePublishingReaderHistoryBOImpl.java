package org.vite.publishing.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingReaderHistory;
import org.vite.publishing.bo.VitePublishingReaderHistoryBO;
import org.vite.publishing.dao.VitePublishingReaderHistoryDAO;

@Service("vpReaderHistBo")
public class VitePublishingReaderHistoryBOImpl implements
		VitePublishingReaderHistoryBO {

	@Autowired
	VitePublishingReaderHistoryDAO vpReadHistDao;
	
	@Override
	public void save(VitePublishingReaderHistory vpReaderHist) {
		vpReadHistDao.save(vpReaderHist);
	}

	@Override
	public void update(VitePublishingReaderHistory vpReaderHist) {
		vpReadHistDao.update(vpReaderHist);
	}

	@Override
	public void delete(VitePublishingReaderHistory vpReaderHist) {
		vpReadHistDao.delete(vpReaderHist);
	}

}

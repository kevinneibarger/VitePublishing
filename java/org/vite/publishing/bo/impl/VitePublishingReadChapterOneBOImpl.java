package org.vite.publishing.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingReadChapterOne;
import org.vite.publishing.bo.VitePublishingReadChapterOneBO;
import org.vite.publishing.dao.VitePublishingReadChapterOneDAO;

@Service("vpReadChptOneBo")
public class VitePublishingReadChapterOneBOImpl implements
		VitePublishingReadChapterOneBO {

	@Autowired
	VitePublishingReadChapterOneDAO vpChptOneDao;
	
	@Override
	public void createReadHistory(VitePublishingReadChapterOne vpReadChpOne) {
		vpChptOneDao.createReadHistory(vpReadChpOne);
	}

	@Override
	public void update(VitePublishingReadChapterOne vpReadChpOne) {
		vpChptOneDao.update(vpReadChpOne);

	}

	@Override
	public void delete(VitePublishingReadChapterOne vpReadChpOne) {
		vpChptOneDao.delete(vpReadChpOne);
	}

}

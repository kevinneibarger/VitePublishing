package org.vite.publishing.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingReader;
import org.vite.publishing.bo.VitePublishingReaderBO;
import org.vite.publishing.dao.VitePublishingReaderDAO;

@Service("vpReaderBo")
public class VitePublishingReaderBOImpl implements VitePublishingReaderBO {

	@Autowired
	VitePublishingReaderDAO vpReaderDao;
	
	@Override
	public void save(VitePublishingReader vpReader) {
		vpReaderDao.save(vpReader);
	}

	@Override
	public void update(VitePublishingReader vpReader) {
		vpReaderDao.update(vpReader);
	}

	@Override
	public void delete(VitePublishingReader vpReader) {
		vpReaderDao.delete(vpReader);
	}

	@Override
	public VitePublishingReader getReaderById(long readerId) {
		return vpReaderDao.getReaderById(readerId);
	}

	@Override
	public int checkUser(String fbId) {
		// TODO Auto-generated method stub
		Integer user = vpReaderDao.checkUser(fbId);
		return user;
	}

}

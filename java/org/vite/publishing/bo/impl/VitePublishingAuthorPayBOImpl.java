package org.vite.publishing.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingAuthorPay;
import org.vite.publishing.bo.VitePublishingAuthorPayBO;
import org.vite.publishing.dao.VitePublishingAuthorPayDAO;

@Service("vpAuthorPayBo")
public class VitePublishingAuthorPayBOImpl implements VitePublishingAuthorPayBO {

	@Autowired
	VitePublishingAuthorPayDAO vpAuthorPayDao;
	
	@Override
	public void save(VitePublishingAuthorPay vpAuthorPay) {
		vpAuthorPayDao.save(vpAuthorPay);
	}

	@Override
	public void update(VitePublishingAuthorPay vpAuthorPay) {
		vpAuthorPayDao.update(vpAuthorPay);
	}

	@Override
	public void delete(VitePublishingAuthorPay vpAuthorPay) {
		vpAuthorPayDao.delete(vpAuthorPay);
	}

}

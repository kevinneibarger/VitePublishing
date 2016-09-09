package org.vite.publishing.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingCMSFinancials;
import org.vite.publishing.bo.VitePublishingCMSFinancialsBO;
import org.vite.publishing.dao.VitePublishingCMSFinancialsDAO;

@Service("vpCMSFinancialBo")
public class VitePublishingCMSFinancialsBOImpl implements
		VitePublishingCMSFinancialsBO {

	@Autowired
	VitePublishingCMSFinancialsDAO vpCMSFinancialDao;
	
	@Override
	public void save(VitePublishingCMSFinancials vpCMSFinancial) {
		vpCMSFinancialDao.save(vpCMSFinancial);
	}

	@Override
	public void update(VitePublishingCMSFinancials vpCMSFinancial) {
		vpCMSFinancialDao.update(vpCMSFinancial);
	}

	@Override
	public void delete(VitePublishingCMSFinancials vpCMSFinancial) {
		vpCMSFinancialDao.delete(vpCMSFinancial);
	}

}

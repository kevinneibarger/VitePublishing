package org.vite.publishing.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingChapters;
import org.vite.publishing.bo.VitePublishingChaptersBO;
import org.vite.publishing.dao.VitePublishingChaptersDAO;

@Service("vpChaptersBo")
public class VitePublishingChaptersBOImpl implements VitePublishingChaptersBO {

	@Autowired
	VitePublishingChaptersDAO vpChptsDao;
	
	@Override
	public void save(VitePublishingChapters vpChapters) {
		vpChptsDao.save(vpChapters);
	}

	@Override
	public void update(VitePublishingChapters vpChapters) {
		vpChptsDao.update(vpChapters);
	}

	@Override
	public void delete(VitePublishingChapters vpChapters) {
		vpChptsDao.delete(vpChapters);
	}

}

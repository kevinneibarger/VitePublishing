package org.vite.publishing.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingSpotlightAuthor;
import org.vite.publishing.bo.VitePublishingAuthorBO;
import org.vite.publishing.dao.VitePublishingAuthorDAO;

@Service("vpAuthorBo")
public class VitePublishingAuthorBOImpl implements VitePublishingAuthorBO {

	@Autowired
	VitePublishingAuthorDAO vpAuthorDao;
	
	@Override
	public void save(VitePublishingAuthor vpAuthor) {
		vpAuthorDao.save(vpAuthor);
	}

	@Override
	public void update(VitePublishingAuthor vpAuthor) {
		vpAuthorDao.update(vpAuthor);
	}

	@Override
	public void delete(VitePublishingAuthor vpAuthor) {
		vpAuthorDao.delete(vpAuthor);
	}

	@Override
	public VitePublishingAuthor getAuthorById(long authorId) {
		return vpAuthorDao.getAuthorById(authorId);
	}

	@Override
	public List<VitePublishingSpotlightAuthor> getSpotlightAuthors() {
		return vpAuthorDao.getSpotlightAuthors();
	}

	@Override
	public List<VitePublishingAuthor> getAuthors() {
		// TODO Auto-generated method stub
		return vpAuthorDao.getAuthors();
	}

	@Override
	public List<VitePublishingAuthor> getAuthors(String letter) {
		// TODO Auto-generated method stub
		return vpAuthorDao.getAuthors(letter);
	}

	@Override
	public List<VitePublishingBooks> getCategories(String letter) {
		// TODO Auto-generated method stub
		return vpAuthorDao.getCategories(letter);
	}

}

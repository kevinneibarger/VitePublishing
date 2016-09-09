package org.vite.publishing.dao;

import org.vite.publishing.bean.VitePublishingReader;

public interface VitePublishingReaderDAO {

	void save(VitePublishingReader reader);
	void update(VitePublishingReader reader);
	void delete(VitePublishingReader reader);
	VitePublishingReader getReaderById(long readerId);
	Integer checkUser(String fbId);
}

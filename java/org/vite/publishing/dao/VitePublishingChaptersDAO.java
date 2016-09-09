package org.vite.publishing.dao;

import org.vite.publishing.bean.VitePublishingChapters;

public interface VitePublishingChaptersDAO {
	
	void save(VitePublishingChapters chapters);
	void update(VitePublishingChapters chapters);
	void delete(VitePublishingChapters chapters);

}

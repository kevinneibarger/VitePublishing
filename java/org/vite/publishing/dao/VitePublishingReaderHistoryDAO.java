package org.vite.publishing.dao;

import org.vite.publishing.bean.VitePublishingReaderHistory;

public interface VitePublishingReaderHistoryDAO {

	void save(VitePublishingReaderHistory readerHist);
	void update(VitePublishingReaderHistory readerHist);
	void delete(VitePublishingReaderHistory readerHist);
}

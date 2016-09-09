package org.vite.publishing.bo;

import org.vite.publishing.bean.VitePublishingReaderHistory;

public interface VitePublishingReaderHistoryBO {
	
	void save(VitePublishingReaderHistory vpReaderHist);
	void update(VitePublishingReaderHistory vpReaderHist);
	void delete(VitePublishingReaderHistory vpReaderHist);
}

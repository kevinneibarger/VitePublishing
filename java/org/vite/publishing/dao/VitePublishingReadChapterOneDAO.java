package org.vite.publishing.dao;

import org.vite.publishing.bean.VitePublishingReadChapterOne;

public interface VitePublishingReadChapterOneDAO {

	void createReadHistory(VitePublishingReadChapterOne chptOne);
	void update(VitePublishingReadChapterOne chptOne);
	void delete(VitePublishingReadChapterOne chptOne);
}

package org.vite.publishing.bo;

import org.vite.publishing.bean.VitePublishingReadChapterOne;

public interface VitePublishingReadChapterOneBO {
	void createReadHistory(VitePublishingReadChapterOne vpReadChpOne);
	void update(VitePublishingReadChapterOne vpReadChpOne);
	void delete(VitePublishingReadChapterOne vpReadChpOne);
}

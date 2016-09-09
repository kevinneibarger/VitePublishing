/**
 * 
 */
package org.vite.publishing.bo;

import java.util.List;

import org.vite.publishing.bean.VitePublishingLoginHistory;

/**
 * @author Kevin Neibarger
 *
 */
public interface VitePublishingLoginHistoryBO {
	void save(VitePublishingLoginHistory vpLoginHist);
	void update(VitePublishingLoginHistory vpLoginHist);
	void delete(VitePublishingLoginHistory vpLoginHist);
	List<VitePublishingLoginHistory> getLoginHistory();
	VitePublishingLoginHistory getLoginHistoryById(long historyId);
	VitePublishingLoginHistory getLoginHistoryByReaderId(long readerId);
	
}

/**
 * 
 */
package org.vite.publishing.bo;

import java.util.List;

import org.vite.publishing.bean.VitePublishingReader;

/**
 * @author Kevin Neibarger
 *
 */
public interface VitePublishingReaderBO {
	
	void save(VitePublishingReader vpReader);
	void update(VitePublishingReader vpReader);
	void delete(VitePublishingReader vpReader);
	VitePublishingReader getReaderById(long readerId);
	int checkUser(String l);
}

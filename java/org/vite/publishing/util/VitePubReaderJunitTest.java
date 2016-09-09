package org.vite.publishing.util;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vite.publishing.bean.VitePublishingReader;
import org.vite.publishing.bo.VitePublishingReaderBO;

public class VitePubReaderJunitTest {

	VitePublishingReaderBO vpReaderBo;
	
	@Before
	public void setUp() throws Exception {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"config/beanlocations.xml");
		
		vpReaderBo = (VitePublishingReaderBO)appContext.getBean("vpReaderBo");
	}

	@Test
	public void test() {
		VitePublishingReader reader = vpReaderBo.getReaderById(1);
		Assert.assertNotNull(reader);
		
		if (reader != null) {
			
			System.out.println(reader.toString());
		}
	}

}

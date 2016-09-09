package org.vite.publishing.util;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.vite.publishing.bo.VitePublishingBookshelfBO;

public class VitePublishingBooksUnitTest {

	VitePublishingBookshelfBO bookshelfBo;
	
	@Before
	public void setUp() throws Exception {
		
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				"config/beanlocations.xml");
		
		bookshelfBo = (VitePublishingBookshelfBO)appContext.getBean("vpBookshelfBo");
	}

	@Test
	public void test() {
		
		String readerId = "10000003";
		String bookId = "50000008";
		
		bookshelfBo.buyFullBook(new Long(readerId).longValue(), new Long(bookId).longValue());
		
	}

}

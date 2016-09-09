package org.vite.publishing.bo.impl;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingChapters;
import org.vite.publishing.bean.VitePublishingReadFirstBook;
import org.vite.publishing.bo.VitePublishingBooksBO;
import org.vite.publishing.dao.VitePublishingBooksDAO;
import org.vite.publishing.util.VitePublishingCreateChapterPDF;

import com.itextpdf.text.DocumentException;

@Service("vpBooksBo")
public class VitePublishingBooksBOImpl implements VitePublishingBooksBO {

	@Autowired
	VitePublishingBooksDAO vpBooksDao;
	
	@Override
	public void save(VitePublishingBooks vpBook) {
		vpBooksDao.save(vpBook);

	}

	@Override
	public void update(VitePublishingBooks vpBook) {
		vpBooksDao.update(vpBook);
	}

	@Override
	public void delete(VitePublishingBooks vpBook) {
		vpBooksDao.delete(vpBook);
	}

	@Override
	public VitePublishingBooks getBookById(long bookId) {
		return vpBooksDao.getBookById(bookId);
	}

	@Override
	public List<VitePublishingBooks> getBookByAuthor(long authorId) {
		return vpBooksDao.getBookByAuthor(authorId);
	}

	@Override
	public List<VitePublishingBooks> getBooksByCategory(String category) {
		return vpBooksDao.getBooksByCategory(category);
	}

	@Override
	public List<VitePublishingBooks> getBooksBySubCategory(String subCategory) {
		return vpBooksDao.getBooksBySubCategory(subCategory);
	}

	@Override
	public List<VitePublishingBooks> getBooksByPublishedDate(Timestamp date) {
		return vpBooksDao.getBooksByPublishedDate(date);
	}

	@Override
	public List<VitePublishingBooks> getBooksBySubmittedDate(Timestamp date) {
		return vpBooksDao.getBooksBySubmittedDate(date);
	}

	@Override
	public List<VitePublishingBooks> getNewestBooks() {
		return vpBooksDao.getNewestBooks();
	}

	@Override
	public List<String> getAllCategories() {
		return vpBooksDao.getAllCategories();
	}

	@Override
	public List<VitePublishingReadFirstBook> getReadFirstBooks(
			List<String> allCategories) {
		return vpBooksDao.getReadFirstBooks(allCategories);
	}

	@Override
	public List<VitePublishingChapters> getAllChaptersByBookId(long bookId) {
		return vpBooksDao.getAllChaptersByBookId(bookId);
	}

	@Override
	public StringBuilder getChapterText(long bookId, String chapterNum) {
		return vpBooksDao.getChapterText(bookId, chapterNum);
	}

	@Override
	public void buildChaptersToPDF(long bookId, String chapterNum, String chapterName) {
		
		String filePath = new File("").getAbsolutePath() + "/src/main/webapp/pdf/";
		StringBuilder chapterText = getChapterText(bookId, chapterNum);

		VitePublishingCreateChapterPDF chapterPDF = VitePublishingCreateChapterPDF.getInstance();
		chapterPDF.setFilePath(filePath);
		chapterPDF.setFilename(bookId + "_Chapter_" +chapterNum+".pdf");
		chapterPDF.setChapterText(chapterText.toString());
		try {
			chapterPDF.createPdf();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\n"+chapterPDF.toString()+"\n");
	}

	@Override
	public List<VitePublishingBooks> getBookSummarys() {
		// TODO Auto-generated method stub
		return vpBooksDao.getBookParag();
	}
}

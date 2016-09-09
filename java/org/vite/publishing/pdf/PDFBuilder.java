/**
 * 
 */
package org.vite.publishing.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Kevin Neibarger
 *
 */

/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 * @author www.codejava.net
 *
 */
public class PDFBuilder extends AbstractITextPdfView {

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC);
	
//	@Autowired
//	private VitePublishingBooksBO booksBO;
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc,
			PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// get data model which is passed by the Spring container
		List<Object> bookInfo = (List<Object>)model.get("listParams");
		
		String chapterText = (String)bookInfo.get(0);
		String bookTitle = (String)bookInfo.get(1);
		String bookChapterNum = (String)bookInfo.get(2);
		
		System.out.println("--------------- BOOK INFORMATION ------------------");
		System.out.println("BOOK Title: "+bookTitle);
		System.out.println("BOOK Chapter: "+bookChapterNum);
		System.out.println("BOOK Chapter Text: "+chapterText);
		System.out.println("--------------- BOOK INFORMATION ------------------");
		
		addMetaData(doc, bookTitle);
		addTitleAndChapter(doc, bookTitle, bookChapterNum);
		doc.add(new Paragraph(chapterText));
	}
	
	private static void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	      paragraph.add(new Paragraph(" "));
	    }
	  }
	  
	private static void addMetaData(Document document, String bookTitle) {
	    document.addTitle(bookTitle);
	    document.addSubject("Category, Fiction");
	    document.addKeywords("Vite, Online, Read, Books");
	    document.addAuthor("Author Name");
	    document.addCreator("Vite Publishing");
	  }

	  private static void addTitleAndChapter(Document document, String bookTitle, String bookChapterNum) throws DocumentException {
	    Paragraph preface = new Paragraph();
	    preface.add(new Paragraph(bookTitle, catFont));
	    addEmptyLine(preface, 2);
	    preface.add(new Paragraph("Chapter "+bookChapterNum, smallBold));
	    addEmptyLine(preface, 3);
	    preface.setAlignment(Element.ALIGN_CENTER);
	    document.add(preface);
	  }

}

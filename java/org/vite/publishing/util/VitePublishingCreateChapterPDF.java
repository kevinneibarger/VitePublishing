/**
 * 
 */
package org.vite.publishing.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Kevin Neibarger
 *
 */
public class VitePublishingCreateChapterPDF implements Serializable {

	private static final long serialVersionUID = 1L;
	private String filePath;
	private String filename;
	private String chapterText;
	
	private VitePublishingCreateChapterPDF() {}
	
	public static VitePublishingCreateChapterPDF getInstance() {
		return new VitePublishingCreateChapterPDF();
	}

	/**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createPdf() throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(this.filePath + this.filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph(this.chapterText));
        // step 5
        document.close();
    }

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setChapterText(String chapterText) {
		this.chapterText = chapterText;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public String toString() {
		return "File Path\n"+filePath+"\nFilename = \n"+filename+"\nCONTENT\n\n"+chapterText;
	}
}

package org.vite.publishing.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class VP_TestPDFFromDB {

	 /** Path to the resulting PDF file. */
	public static final String fullPath = new File("").getAbsolutePath();
    public static final String RESULT
        = fullPath + "/src/main/webapp/WEB-INF/jsp/pdf/hello.pdf";
 
    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
    	throws DocumentException, IOException {
    	new VP_TestPDFFromDB().createPdf(RESULT);
    }
 
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createPdf(String filename)
	throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        document.add(new Paragraph("This will be chapter 1 - It was the best of times, it was the blurst of times.."));
        // step 5
        document.close();
    }
}

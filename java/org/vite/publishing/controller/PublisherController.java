package org.vite.publishing.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.vite.publishing.bean.VitePublishingAuthor;
import org.vite.publishing.bean.VitePublishingBooks;
import org.vite.publishing.bean.VitePublishingBookshelf;
import org.vite.publishing.bean.VitePublishingBookshelfRow;
import org.vite.publishing.bean.VitePublishingEmailParms;
import org.vite.publishing.bean.VitePublishingReadFirstBook;
import org.vite.publishing.bean.VitePublishingReader;
import org.vite.publishing.bean.VitePublishingSpotlightAuthor;
import org.vite.publishing.bo.VitePublishingAuthorBO;
import org.vite.publishing.bo.VitePublishingBooksBO;
import org.vite.publishing.bo.VitePublishingBookshelfBO;
import org.vite.publishing.bo.VitePublishingReaderBO;
import org.vite.publishing.facebook_api.FBGraph;
import org.vite.publishing.facebook_api.FacebookConnector;


/**
 * Handles and retrieves person request
 */
@Controller
@RequestMapping("/publishercontroller")
public class PublisherController {

	protected static Logger logger = Logger.getLogger("controller");
	
	@Autowired
	private VitePublishingReaderBO publishingReaderBO;
	
	@Autowired
	private VitePublishingBooksBO booksBO;
	
	@Autowired
	private VitePublishingAuthorBO authorBO;
	
	@Autowired
	private VitePublishingBookshelfBO bookShelfBO;
	
	
	@RequestMapping(value = "/fblogintest", method = RequestMethod.GET)
	public String loginFacebookUser(Model model, HttpServletRequest request) {
		return "general_pages/testFacebookLogin";
	}
	
	@RequestMapping(value = "/homeloggedin", method = RequestMethod.GET)
	public ModelAndView loginSuccessful(Model model, HttpServletRequest request) {
		// Goto Home page with Reader ID
		// Hardcode a readerId
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_main");
		
		//request.getSession().setAttribute("loggedin", "true");
		//request.getSession().setAttribute("readerId", "10000003");
		 
		return modelAndView;
	}
	
	@RequestMapping(value = "/homenewuser", method = RequestMethod.GET)
	public ModelAndView notLoggedIn(Model model, HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loginUser(Model model, HttpServletRequest request) {
		
		request.getSession().setAttribute("loggedin", "true");
		request.getSession().setAttribute("readerId", "10000003");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_main");
		//modelAndView.setViewName("general_pages/vitepublishing_main2");
		
		
		// TODO: Get list of newest books
		// Get 5 newest books by publish date
		List<VitePublishingBooks> getNewestBooks = booksBO.getNewestBooks();
		if (getNewestBooks != null) {
			
			if (getNewestBooks.size() > 0) {
				System.out.println("GOT BOOK INFORMATION!");
				modelAndView.addObject("newestBooks", getNewestBooks);
			} else {
				System.out.println("THERE ARE NO CURRENT BOOKS!");
				modelAndView.addObject("newestBooks", null);
			}
		}
		
		System.out.println("GET AUTHOR INFO!");
		// Load author spotlight authors
		List<VitePublishingSpotlightAuthor> spotlightAuthors = authorBO.getSpotlightAuthors();
		
		if (spotlightAuthors != null && spotlightAuthors.size() > 0) {
			System.out.println("GOT SPOTLIGHT AUTHOR INFORMATION!");
			modelAndView.addObject("spotLightAuthors", spotlightAuthors);
		} else {
			System.out.println("NO SPOTLIGHT AUTHOR INFORMATION!");
			modelAndView.addObject("spotLightAuthors", null);
		}
		
		// Get "Read First Books" Section
		List<VitePublishingReadFirstBook> readFirstBooks = booksBO.getReadFirstBooks(booksBO.getAllCategories());
		if (readFirstBooks != null && readFirstBooks.size() > 0) {
			System.out.println("GOT 'First Books' INFORMATION!");
			modelAndView.addObject("readFirstBooks", readFirstBooks);
		} else {
			System.out.println("NO 'First Books' INFORMATION!");
			modelAndView.addObject("readFirstBooks", null);
		}
		
		return modelAndView;
		//return "general_pages/vitepublishing_main";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginScreen(HttpServletRequest request, Model model) throws IOException {		
		
		return "general_pages/vitepublishing_login";
	}
	
	@RequestMapping(value = "/bookshelf", method = RequestMethod.GET)
	public ModelAndView gotoBookshelf(HttpServletRequest request, Model model,
			@RequestParam(value="readerId") String readerId) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_bookshelf");
		
		// Get all full books on bookshelf
		List<VitePublishingBooks> getFullBooks = bookShelfBO.getBooksOnBookshelf(new Long(readerId).longValue(), true);
		
		// Get all half books on bookshelf
		List<VitePublishingBooks> getHalfBooks = bookShelfBO.getBooksOnBookshelf(new Long(readerId).longValue(), false);
		
		// Get BookShelf Rows
		List<VitePublishingBookshelfRow> bookShelfRows = null;
		
		if (getFullBooks != null) {
			
			bookShelfRows = buildBookshelfRows(getFullBooks);
			
			if (getFullBooks.size() > 0) {
				System.out.println("GOT FULL BOOK INFORMATION!");
				//displayBooks(getFullBooks, true);
				modelAndView.addObject("fullBooks", getFullBooks);
				modelAndView.addObject("fullBooksCount", getFullBooks.size());
				modelAndView.addObject("fullBooksBookShelf", bookShelfRows);
			} else {
				System.out.println("THERE ARE NO CURRENT BOOKS!");
				modelAndView.addObject("fullBooks", null);
				modelAndView.addObject("fullBooksCount", 0);
				modelAndView.addObject("fullBooksBookShelf", null);
			}
		}
		
		if (getHalfBooks != null) {
			
			bookShelfRows = buildBookshelfRows(getHalfBooks);
			
			if (getHalfBooks.size() > 0) {
				displayBooks(getHalfBooks, false);
				System.out.println("GOT HALF BOOK INFORMATION!");
				modelAndView.addObject("halfBooks", getHalfBooks);
				modelAndView.addObject("halfBooksCount", getHalfBooks.size());
				modelAndView.addObject("halfBooksBookShelf", bookShelfRows);
			} else {
				System.out.println("THERE ARE NO CURRENT HALF BOOKS!");
				modelAndView.addObject("halfBooks", null);
				modelAndView.addObject("halfBooksCount", 0);
				modelAndView.addObject("halfBooksBookShelf", null);
			}
		}

		return modelAndView;
		//return "general_pages/vitepublishing_bookshelf";
	}
	
	@RequestMapping(value="/buybook", method = RequestMethod.GET)
	public ModelAndView buyThisBook(HttpServletRequest request, Model model, @RequestParam(value="bookId") String bookId,
			@RequestParam(value="readerId") String readerId) {
		
		System.out.println("****buyThisBook method **************");
		ModelAndView modelAndView = new ModelAndView();
		String currentView = modelAndView.getViewName();
		boolean isBookAlreadyPurchased = false;
		
		if (bookId != null && readerId != null) {
			System.out.println("****buyThisBook method: Reader Id and Book Id != null **************");
			// Check to make sure the book hasn't already been purchased (although we should never get here!)
			List<VitePublishingBooks> fullBooksOnBS = bookShelfBO.getBooksOnBookshelf(new Long(readerId).longValue(), true);
			if (fullBooksOnBS != null && fullBooksOnBS.size() > 0) {
				for (VitePublishingBooks book : fullBooksOnBS) {
					if (book.getBookId() == new Long(bookId).longValue()) {
						isBookAlreadyPurchased = true;
						break;
					}
				}
			}
			
			if (!isBookAlreadyPurchased) {
				System.out.println("****buyThisBook method: Book has NOT been purchased **************");
				//Buy the book
				bookShelfBO.buyFullBook(new Long(readerId).longValue(), new Long(bookId).longValue());
				try {
					return gotoBookshelf(request, model, readerId);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				modelAndView.setViewName(currentView);
			}
		}
		
		System.out.println("****buyThisBook method: Returning current View, book already purchased or error **************");
		return modelAndView;
	}
	
	@RequestMapping(value = "/bookdetailpage", method = RequestMethod.GET)
	public ModelAndView gotoBookDetail(HttpServletRequest request, Model model, 
			@RequestParam(value="bookId") String bookId, @RequestParam(value="typebook") String typebook) throws IOException {	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_book_detail");
		
		// Set the book Id in the session, as we'll need it
		request.getSession().setAttribute("bookId", bookId);
		
		VitePublishingBooks book = booksBO.getBookById(new Long(bookId).longValue());
		VitePublishingBookshelf bookShelf = bookShelfBO.getBookFromBookshelfById(new Long(bookId).longValue());
		
		if (book != null) {
			modelAndView.addObject("bookById", book);
		}
		
		System.out.println("TYPE BOOK: "+typebook);
		
		if (typebook != null) {
			modelAndView.addObject("typebook", typebook);
		} else {
			modelAndView.addObject("typebook", null);
		}
		
		//TODO: build first and second half chapters
		long totalChapters = book.getHalfBookChptr();
		//REMOVE WHEN DONE TEST
		//long totalChapters = 24;
		long halfBookChapters = 0;
		
		if((totalChapters % 2)!=0) {
			halfBookChapters = totalChapters / 2 + 1;
		} else {
			halfBookChapters = totalChapters / 2;
		}
		
		System.out.println("HALF: "+halfBookChapters);
		System.out.println("FULL: "+totalChapters);
		
		List<String> firstHalfChaptersList = new ArrayList<String>();
		List<String> secondHalfChaptersList = new ArrayList<String>();
		List<String> allChapters = new ArrayList<String>();
		
		for (long i = 1; i <= halfBookChapters; i++) {
			firstHalfChaptersList.add(String.valueOf(i));
		}
		
		for (long i = halfBookChapters + 1; i <= totalChapters; i++) {
			secondHalfChaptersList.add(String.valueOf(i));
		}
		
		allChapters.addAll(firstHalfChaptersList);
		allChapters.addAll(secondHalfChaptersList);
		
		for (String chpt : allChapters) {
			System.out.println("CHAPTER -- "+chpt);
		}
		
		modelAndView.addObject("fullBookChaptersList", allChapters);
		modelAndView.addObject("firstHalfChaptersList", firstHalfChaptersList);
		modelAndView.addObject("secondHalfChaptersList", secondHalfChaptersList);
		modelAndView.addObject("bookCost", bookShelf.getBookCost());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/bookchapterspage", method = RequestMethod.GET)
	public ModelAndView gotoBookChapters(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam(value="bookId") String bookId, @RequestParam(value="chapterNum") String chapterNum,
			@RequestParam(value="typebook") String typebook, @RequestParam(value="frombookshelf") String fromBookshelf) throws IOException {	
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_book_chapters");
		modelAndView.addObject("bookId", bookId);
		modelAndView.addObject("chapterNum", chapterNum);
		
		if (typebook != null) {
			modelAndView.addObject("typebook", typebook);	
		} else {
			modelAndView.addObject("typebook", null);
		}
		
		if (fromBookshelf != null) {
			modelAndView.addObject("frombookshelf", fromBookshelf);
		}
		
		VitePublishingBooks book = booksBO.getBookById(new Long(bookId).longValue());
		VitePublishingBookshelf bookShelf = bookShelfBO.getBookFromBookshelfById(new Long(bookId).longValue());
		
		String chapterText = booksBO.getChapterText(new Long(bookId).longValue(), chapterNum).toString();
		modelAndView.addObject("chapterText", chapterText);
		modelAndView.addObject("bookTitle", book.getBookTitle());
		modelAndView.addObject("authorFirstname", book.getAuthor().getFirstName());
		modelAndView.addObject("authorLastname", book.getAuthor().getLastName());
		modelAndView.addObject("bookCost", bookShelf.getBookCost());
		
		// Build the PDF, maybe return as a Stream??
		return modelAndView;
	}
	
	@RequestMapping(value = "/getbookchapterPDF", method = RequestMethod.GET)
	public ModelAndView downloadExcel(@RequestParam(value="bookId") String bookId,
			@RequestParam(value="chapterNum") String chapterNum) {
		
		// Get Chapter Text
		String chapterText = booksBO.getChapterText(new Long(bookId).longValue(), chapterNum).toString();
		List<Object> listParams = new ArrayList<Object>();
		listParams.add(0, chapterText);
		listParams.add(1, booksBO.getBookById(new Long(bookId).longValue()).getBookTitle());
		listParams.add(2, chapterNum);
		listParams.add(3, booksBO.getBookById(new Long(bookId).longValue()).getHalfBookChptr());

		// return a view which will be resolved by an excel view resolver
		return new ModelAndView("pdfView", "listParams", listParams);
	}
	
	@RequestMapping(value = "/read_book", method = RequestMethod.GET)
	public String readBook(HttpServletRequest request, Model model) throws IOException {		
		
		return "general_pages/vitepublishing_read_books";
	}
	@RequestMapping(value = "/read_book_login", method = RequestMethod.GET)
	public String readBookLoggedIn(HttpServletRequest request, Model model) throws IOException {		
		
		return "general_pages/vitepublishing_read_books_login";
	}
	@RequestMapping(value = "/read_book_details", method = RequestMethod.GET)
	public String readBookDetails(HttpServletRequest request, Model model) throws IOException {		
		
		return "general_pages/vite_publishing_book_details";
	}
	
	@RequestMapping(value = "/fbLogin", method = RequestMethod.GET)
	public String getFacebookLogin(HttpServletRequest request, Model model, HttpServletResponse response, 
			@RequestParam(value="code") String code) throws IOException {		
		
		
		String url=""; 
		String accessToken=""; 
		String graph="";
		
		Map fbProfileData = null;
		//code = request.getParameter("code");
		if (code == null || code.equals("")) {
			FacebookConnector fbConnection = new FacebookConnector();
			url = fbConnection.getFBAuthUrl();
			response.sendRedirect(url);
		} else{
			FacebookConnector fbConnection = new FacebookConnector();
			accessToken = fbConnection.getAccessToken(code);

			FBGraph fbGraph = new FBGraph(accessToken);
			graph = fbGraph.getFBGraph();
			fbProfileData = fbGraph.getGraphData(graph);
			String id = fbProfileData.get("id").toString();
			System.out.println("IDnye "+id);
		}
		
		
		return "general_pages/vitepublishing_main";
	
	}
	@RequestMapping(value = "/addUserToDb", method = RequestMethod.GET)
	public void lookupUser(HttpServletRequest request, HttpServletResponse response) {

		logger.debug("Received request to get the facebookId for storage ");
		java.util.Date date= new java.util.Date();
		String facebookID = request.getParameter("fbId");
		
		// Check to see if the user is already in the DB. If so, then don't build the object every time.
		int isRegistered = publishingReaderBO.checkUser(facebookID);
		String name = request.getParameter("name");
		String firstName = "Test";
		String lastName = "User";
		
		
		// Parse the name so we can save it as two separate fields in 
		firstName = name.substring(0, name.indexOf(" "));
		lastName = name.substring(name.indexOf(" "));

		request.getSession().setAttribute("name", firstName + " " + lastName);
		
		if (isRegistered == 0 ) { // If they are not registered in the table, then save the ID
			VitePublishingReader v_r_reader = new VitePublishingReader();

			// Get the first 48 characters of the device
			String deviceType = request.getHeader("user-agent").substring(0,48);
			//String deviceType = "windows";
			
			Timestamp lastLogin = new Timestamp(date.getTime());
			String ipAdress = request.getRemoteAddr();
			String emailAddr = request.getParameter("email");
			
			v_r_reader.setFacebookId(facebookID);
			v_r_reader.setEmailAddr(emailAddr);
			v_r_reader.setFirstName(firstName);
			v_r_reader.setLastName(lastName);
			v_r_reader.setLastLogin(lastLogin);
			v_r_reader.setIpAddress(ipAdress);
			v_r_reader.setDeviceType(deviceType);

			try {

				// Add a new user to the DB.
				publishingReaderBO.save(v_r_reader);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		request.getSession().setAttribute("loggedin", "true");
		request.getSession().setAttribute("readerId", "10000003");
	}
	@RequestMapping(value = "/list_authors/{letter}", method = RequestMethod.GET)
	public ModelAndView authorsList(@PathVariable("letter") String letter, HttpServletRequest request, Model model) throws IOException {		
		
		System.out.println("GET AUTHOR INFO!");
		// Load author spotlight authors
		System.out.println("The parameter " + letter);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_authors");
		
		List<VitePublishingAuthor> getAuthorList = authorBO.getAuthors(letter);
		
		if (getAuthorList != null && getAuthorList.size() > 0) {
			System.out.println("GOT  AUTHOR INFORMATION!");
			modelAndView.addObject("getAuthorList", getAuthorList);
		} else {
			System.out.println("NO  AUTHOR INFORMATION!");
			modelAndView.addObject("getAuthorList", null);
		}
		
		return modelAndView;
	}
	@RequestMapping(value = "/list_categories/{letter}", method = RequestMethod.GET)
	public ModelAndView categoryList(@PathVariable("letter") String letter, HttpServletRequest request, Model model) throws IOException {		
		
		System.out.println("GET CATEGORY INFO!");
		// Load author spotlight authors
		System.out.println("The parameter " + letter);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_category");
		
		List<VitePublishingBooks> getCategoryList = authorBO.getCategories(letter);
		
		if (getCategoryList != null && getCategoryList.size() > 0) {
			System.out.println("GOT  AUTHOR INFORMATION!");
			modelAndView.addObject("getCategoryList", getCategoryList);
		} else {
			System.out.println("NO  AUTHOR INFORMATION!");
			modelAndView.addObject("getCategoryList", null);
		}
		
		return modelAndView;
	}
	
	private void displayBooks(List<VitePublishingBooks> books, boolean fullbooks) {
		
		if (fullbooks) {
			System.out.println("----------------- FULL BOOKS --------------------\n");
		} else {
			System.out.println("----------------- HALF BOOKS --------------------\n");
		}
		
		for (VitePublishingBooks book : books) {
			System.out.println(book.toString());
		}
		
		System.out.println("-----------------------------------------------------\n");
	}
	@RequestMapping(value = "/sendEmail", method = RequestMethod.GET)
	public String sendEmailToGroup(Model model, HttpServletRequest request) throws IOException {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("general_pages/vitepublishing_bookshelf");
		
		ArrayList<String> bookParagraphs = new ArrayList<String>();
		
		// Get all full books on bookshelf
		List<VitePublishingBooks> getBookSummarys = booksBO.getBookSummarys();
		List<VitePublishingEmailParms> emailStuff = new ArrayList<VitePublishingEmailParms>();;
		
		// Build the list of strings to send as email links
		for (VitePublishingBooks book : getBookSummarys) {
			VitePublishingEmailParms email = new VitePublishingEmailParms();
			long bookId= book.getBookId();
			String bookSummary = book.getBookSummary();
			// String to add to the array list 
			String link = "http://jpcloudusa004.nshostserver.net:33306/VitePublishing/vitepub/"
					+ "publishercontroller/bookchapterspage?bookId="+bookId+"&chapterNum=1&chapterCount=2&typebook=fullbook&frombookshelf=true";
			
			email.setLink(link);
			email.setSummary(bookSummary);	
			emailStuff.add(email);
		}
		
		// When I get the summarys, we need to send them as links to the group email
		//sendEmailLink(emailStuff);
		//return modelAndView;
		return "general_pages/vitepublishing_bookshelf?readerId=10000003";
		
	}
	private void sendEmailLink(List<VitePublishingEmailParms> books) {
		
		final String username = "keithneibarger14@gmail.com";
		final String password = "Oyevay99";

		Properties props = new Properties();
		//props.put("mail.smtp.user","keith neibarger"); 
		props.put("mail.smtp.host", "smtp.gmail.com"); 
		props.put("mail.smtp.port", "25"); 
		props.put("mail.debug", "true"); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.starttls.enable","true"); 
		props.put("mail.smtp.EnableSSL.enable","true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
		props.setProperty("mail.smtp.port", "465"); 
		props.setProperty("mail.smtp.socketFactory.port", "465"); 

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("to-email@gmail.com"));
			message.setSubject("Testing Subject");
			message.setText("Dear Mail Crawler,"
					+ "\n\n No spam to my email, please!");

			

			
		    /*Transport t = session.getTransport(protocol);
		    try {
		        t.connect("smtp.gmail.com", username, password);
		        t.sendMessage(message, message.getAllRecipients());
		    } finally {
		        t.close();
		    }*/

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	private List<VitePublishingBookshelfRow> buildBookshelfRows(List<VitePublishingBooks> books) {
		
		List<VitePublishingBookshelfRow> bookShelfRows = null;
		int numBooksInRow = 0;
		
		if (books != null) {
			bookShelfRows = new ArrayList<VitePublishingBookshelfRow>();
			VitePublishingBooks book1 = null;
			VitePublishingBooks book2 = null;
			VitePublishingBooks book3 = null;
			long book1CurrChpt = 1;
			long book2CurrChpt = 1;
			long book3CurrChpt = 1;
			VitePublishingBookshelfRow bookshelfRow = null;
			
			if (books.size() <= 3) {
				System.out.println("Bookshelf has LESS THAN OR EQUAL to 3 books!");
				
				bookshelfRow = new VitePublishingBookshelfRow();
				
				if (books.size() == 1) {
					book1 = books.get(0);
					book1CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book1.getBookId()).getCurrentChptr()).longValue();
					book2 = new VitePublishingBooks();
					book3 = new VitePublishingBooks();
					numBooksInRow = 1;
				} 
				
				if (books.size() == 2) {
					book1 = books.get(0);
					book1CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book1.getBookId()).getCurrentChptr()).longValue();
					book2 = books.get(1);
					book2CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book2.getBookId()).getCurrentChptr()).longValue();
					book3 = new VitePublishingBooks();
					numBooksInRow = 2;
				} 
				
				if (books.size() == 3) {
					book1 = books.get(0);
					book1CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book1.getBookId()).getCurrentChptr()).longValue();
					book2 = books.get(1);
					book2CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book2.getBookId()).getCurrentChptr()).longValue();
					book3 = books.get(2);
					book3CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book3.getBookId()).getCurrentChptr()).longValue();
					numBooksInRow = 3;
				} 
				
				bookshelfRow.setBook1(book1);
				bookshelfRow.setBook2(book2);
				bookshelfRow.setBook3(book3);
				bookshelfRow.setBook1CurrChapter(book1CurrChpt);
				bookshelfRow.setBook2CurrChapter(book2CurrChpt);
				bookshelfRow.setBook3CurrChapter(book3CurrChpt);
				bookshelfRow.setNumBooksInRow(numBooksInRow);
				bookShelfRows.add(bookshelfRow);
				
			} else {
				System.out.println("Bookshelf has MORE THAN 3 books!");
				
				int currentLoopIndx = 0;
				int bookOneIndx = 0;
				int bookTwoIndx = 0;
				int bookThreeIndx = 0;
				
				int n = books.size() / 2;
				for (int i = 0; i < n; i++) {
					
					bookshelfRow = new VitePublishingBookshelfRow();
					
					if (i % 3 == 0) {
						
						if (i == 0) {
							bookOneIndx = currentLoopIndx;
							bookTwoIndx = currentLoopIndx + 1;
							bookThreeIndx = currentLoopIndx + 2;
						} else {
							bookOneIndx = currentLoopIndx + 1;
							bookTwoIndx = currentLoopIndx + 2;
							bookThreeIndx = currentLoopIndx + 3;
						}
						
					} else {
						bookOneIndx = currentLoopIndx;
						bookTwoIndx = currentLoopIndx + 1;
						bookThreeIndx = currentLoopIndx + 2;	
						
					}	
					
					currentLoopIndx = bookThreeIndx+1;
					
					if (bookOneIndx < books.size()) {
						book1 = books.get(bookOneIndx);
						book1CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book1.getBookId()).getCurrentChptr()).longValue();
					} else {
						book1 = new VitePublishingBooks();
					}
					
					if (bookTwoIndx < books.size()) {
						book2 = books.get(bookTwoIndx);
						book2CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book2.getBookId()).getCurrentChptr()).longValue();
					} else {
						book2 = new VitePublishingBooks();
					}
					
					if (bookThreeIndx < books.size()) {
						book3 = books.get(bookThreeIndx);
						book3CurrChpt = new Long(bookShelfBO.getBookFromBookshelfById(book3.getBookId()).getCurrentChptr()).longValue();
					} else {
						book3 = new VitePublishingBooks();
					}
					
					bookshelfRow.setBook1(book1);
					bookshelfRow.setBook2(book2);
					bookshelfRow.setBook3(book3);
					bookshelfRow.setBook1CurrChapter(book1CurrChpt);
					bookshelfRow.setBook2CurrChapter(book2CurrChpt);
					bookshelfRow.setBook3CurrChapter(book3CurrChpt);
					
					if (book1.getBookTitle() != null && book2.getBookTitle() == null && book3.getBookTitle() == null) {
						numBooksInRow = 1;
					} else if (book1.getBookTitle() != null && book2.getBookTitle() != null && book3.getBookTitle() == null) {
						numBooksInRow = 2;
					} else if (book1.getBookTitle() != null && book2.getBookTitle() != null && book3.getBookTitle() != null) {
						numBooksInRow = 3;
					} else {
						numBooksInRow = 0;
					}
					bookshelfRow.setNumBooksInRow(numBooksInRow);
					bookShelfRows.add(bookshelfRow);

				}
			}
		}
		
		return bookShelfRows;
	}
}
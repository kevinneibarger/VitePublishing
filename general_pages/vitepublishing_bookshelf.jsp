<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vite Publishing</title>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 <script type="text/javascript">
          $(document).ready(function () {
     	 });
 </script>
    
<link href="${pageContext.request.contextPath}/css/vitepub.css"
	rel="stylesheet">
</head>
<body style="overflow: auto;" bgcolor="#fff">
	<c:set var="fullBooksOnBookshelf" value="${fullBooks}"/>
	<c:set var="fullBooksCount" value="${fullBooksCount}"/>
	<c:set var="halfBooksOnBookShelf" value="${halfBooks}"/>
	<c:set var="halfBooksCount" value="${halfBooksCount}"/>
	<c:set var="fullBooksBookshelf" value="${fullBooksBookShelf}"/>
	<c:set var="halfBooksBookshelf" value="${halfBooksBookShelf}"/>
	<c:set var="name" value="${sessionScope.name}"/>
	
	<jsp:include page="../navigation/topNavVitePub.jsp"/>
	<%-- <jsp:include page="../navigation/vitepublishing_bookshelf_header.jsp" />--%>

	<div id="divmainpagewrapper">
		<table width="100%" bgcolor="#fff">
			<tr>

				<td>
					<table>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td><img
								src="${pageContext.request.contextPath}/images/books-128.png">
							</td>
							<td>
								<div class="welcome_identifier"
									style="font-family: Calibri; font-size: 20pt; color: #000; font-weight: bold">
									WELCOME ${name} <span class="chg_pwd"
										style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
										<a href="#">[CHANGE PASSWORD]</a>
									</span>
								</div>
								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 22pt; color: #2B3D8F; font-weight: bold">YOUR
									BOOKSHELF</div>
									<div
									style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold"> Email To Group
									<%-- <a href="${pageContext.request.contextPath}/vitepub/publishercontroller/sendEmail">  Email To Group  </a> --%>  </div>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr>
				<td>
					<hr width="100%">
				</td>
			</tr>

			<!-- Full Books Title Row -->
			<tr id="full_book_title_row">
				<td>
					<table>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td><span
								style="font-family: Calibri; font-size: 22pt; color: #2B3D8F; font-weight: bold">FULL
									BOOKS</span></td>
							<td style="width: 60px;">&nbsp;</td>
							<td><span
								style="font-family: Calibri; font-size: 13pt; font-color: blue">SORT
									BY LAST PURCHASE | BY AUTHOR NAME (A-Z) | BY TITLE (A-Z)</span></td>
						</tr>
					</table>
				</td>
			</tr>
			<!-- Full Books Row -->
			<c:choose>
			<c:when test="${fullBooksCount gt 0}">
			<tr id="full_book_row" align="left">
				<td>
					<table style="border-spacing: 8px" width="75%" align="center">
					
					<c:forEach var="bookshelf" items="${fullBooksBookshelf}" varStatus="loop">	
					 
						<c:if test="${bookshelf.numBooksInRow != 0}">
							<c:choose>
								<c:when test="${bookshelf.numBooksInRow == 1}">	
									<tr>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${bookshelf.book1.bookId}" />
											<jsp:param name="bookTitle" value="${bookshelf.book1.bookTitle}" />
											<jsp:param name="authorFirst" value="${bookshelf.book1.author.firstName}" />
											<jsp:param name="authorLast" value="${bookshelf.book1.author.lastName}" />
											<jsp:param name="book1CurrChpt" value="${bookshelf.book1CurrChapter }"/>
											<jsp:param name="totalChapters" value="${bookshelf.book1.halfBookChptr }"/>
											<jsp:param name="bookColumn" value="1"/>
											<jsp:param name="fullbookhalfbook" value="fullbook" />
										</jsp:include>
									</tr>		
									<tr><td width="100%">&nbsp;</td></tr>	
								</c:when>
								<c:when test="${bookshelf.numBooksInRow == 2}">
									<tr>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${bookshelf.book1.bookId}" />
											<jsp:param name="bookTitle" value="${bookshelf.book1.bookTitle}" />
											<jsp:param name="authorFirst" value="${bookshelf.book1.author.firstName}" />
											<jsp:param name="authorLast" value="${bookshelf.book1.author.lastName}" />
											<jsp:param name="book1CurrChpt" value="${bookshelf.book1CurrChapter }"/>
											<jsp:param name="totalChapters" value="${bookshelf.book1.halfBookChptr }"/>
											<jsp:param name="bookColumn" value="1"/>
											<jsp:param name="fullbookhalfbook" value="fullbook" />
										</jsp:include>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${bookshelf.book2.bookId}" />
											<jsp:param name="bookTitle" value="${bookshelf.book2.bookTitle}" />
											<jsp:param name="authorFirst" value="${bookshelf.book2.author.firstName}" />
											<jsp:param name="authorLast" value="${bookshelf.book2.author.lastName}" />
											<jsp:param name="book2CurrChpt" value="${bookshelf.book2CurrChapter }"/>
											<jsp:param name="totalChapters" value="${bookshelf.book2.halfBookChptr }"/>
											<jsp:param name="bookColumn" value="2"/>
											<jsp:param name="fullbookhalfbook" value="fullbook" />
										</jsp:include>
									</tr>		
									<tr><td width="100%">&nbsp;</td></tr>	
								</c:when>
								<c:when test="${bookshelf.numBooksInRow == 3}">
									<tr>
									<jsp:include page="vitepublishing_book.jsp">
										<jsp:param name="bookId" value="${bookshelf.book1.bookId}" />
										<jsp:param name="bookTitle" value="${bookshelf.book1.bookTitle}" />
										<jsp:param name="authorFirst" value="${bookshelf.book1.author.firstName}" />
										<jsp:param name="authorLast" value="${bookshelf.book1.author.lastName}" />
										<jsp:param name="book1CurrChpt" value="${bookshelf.book1CurrChapter }"/>
										<jsp:param name="totalChapters" value="${bookshelf.book1.halfBookChptr }"/>
										<jsp:param name="bookColumn" value="1"/>
										<jsp:param name="fullbookhalfbook" value="fullbook" />
									</jsp:include>
									<jsp:include page="vitepublishing_book.jsp">
										<jsp:param name="bookId" value="${bookshelf.book2.bookId}" />
										<jsp:param name="bookTitle" value="${bookshelf.book2.bookTitle}" />
										<jsp:param name="authorFirst" value="${bookshelf.book2.author.firstName}" />
										<jsp:param name="authorLast" value="${bookshelf.book2.author.lastName}" />
										<jsp:param name="book2CurrChpt" value="${bookshelf.book2CurrChapter }"/>
										<jsp:param name="totalChapters" value="${bookshelf.book2.halfBookChptr }"/>
										<jsp:param name="bookColumn" value="2"/>
										<jsp:param name="fullbookhalfbook" value="fullbook" />
									</jsp:include>
									<jsp:include page="vitepublishing_book.jsp">
										<jsp:param name="bookId" value="${bookshelf.book3.bookId}" />
										<jsp:param name="bookTitle" value="${bookshelf.book3.bookTitle}" />
										<jsp:param name="authorFirst" value="${bookshelf.book3.author.firstName}" />
										<jsp:param name="authorLast" value="${bookshelf.book3.author.lastName}" />
										<jsp:param name="book3CurrChpt" value="${bookshelf.book3CurrChapter }"/>
										<jsp:param name="totalChapters" value="${bookshelf.book3.halfBookChptr }"/>
										<jsp:param name="bookColumn" value="3"/>
										<jsp:param name="fullbookhalfbook" value="fullbook" />
									</jsp:include>
									</tr>		
									<tr><td width="100%">&nbsp;</td></tr>	
								</c:when>
							</c:choose>
						</c:if>
						
					</c:forEach>
					</table>
				</td>
			</tr>
		</c:when>
		<c:otherwise>

		</c:otherwise>
		</c:choose>
		
			<!-- Half Books Title ROW -->
			<tr id="half_book_title_row">
				<td>
					<table>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td><span
								style="font-family: Calibri; font-size: 22pt; color: #2B3D8F; font-weight: bold">HALF
									BOOKS</span></td>
							<td style="width: 60px;">&nbsp;</td>
							<td><span
								style="font-family: Calibri; font-size: 13pt; font-color: blue">SORT
									BY AUTHOR NAME (A-Z) | BY TITLE (A-Z)</span></td>
						</tr>
					</table>
				</td>
			</tr>

			<!-- Half Books Row -->
			<c:choose>
			<c:when test="${halfBooksCount gt 0}">
			<tr id="half_book_row">
				<td>
					<table style="border-spacing: 8px" width="75%" align="center">
					
					<c:forEach var="bookshelf" items="${halfBooksBookshelf}" varStatus="loop">	
					 
						<c:if test="${bookshelf.numBooksInRow != 0}">
							<c:choose>
								<c:when test="${bookshelf.numBooksInRow == 1}">	
									<tr>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${bookshelf.book1.bookId}" />
											<jsp:param name="bookTitle" value="${bookshelf.book1.bookTitle}" />
											<jsp:param name="authorFirst" value="${bookshelf.book1.author.firstName}" />
											<jsp:param name="authorLast" value="${bookshelf.book1.author.lastName}" />
											<jsp:param name="book1CurrChpt" value="${bookshelf.book1CurrChapter }"/>
											<jsp:param name="totalChapters" value="${bookshelf.book1.halfBookChptr }"/>
											<jsp:param name="bookColumn" value="1"/>
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
									</tr>		
									<tr><td width="100%">&nbsp;</td></tr>	
								</c:when>
								<c:when test="${bookshelf.numBooksInRow == 2}">
									<tr>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${bookshelf.book1.bookId}" />
											<jsp:param name="bookTitle" value="${bookshelf.book1.bookTitle}" />
											<jsp:param name="authorFirst" value="${bookshelf.book1.author.firstName}" />
											<jsp:param name="authorLast" value="${bookshelf.book1.author.lastName}" />
											<jsp:param name="book1CurrChpt" value="${bookshelf.book1CurrChapter }"/>
											<jsp:param name="totalChapters" value="${bookshelf.book1.halfBookChptr }"/>
											<jsp:param name="bookColumn" value="1"/>
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${bookshelf.book2.bookId}" />
											<jsp:param name="bookTitle" value="${bookshelf.book2.bookTitle}" />
											<jsp:param name="authorFirst" value="${bookshelf.book2.author.firstName}" />
											<jsp:param name="authorLast" value="${bookshelf.book2.author.lastName}" />
											<jsp:param name="book2CurrChpt" value="${bookshelf.book2CurrChapter }"/>
											<jsp:param name="totalChapters" value="${bookshelf.book2.halfBookChptr }"/>
											<jsp:param name="bookColumn" value="2"/>
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
									</tr>		
									<tr><td width="100%">&nbsp;</td></tr>	
								</c:when>
								<c:when test="${bookshelf.numBooksInRow == 3}">
									<tr>
									<jsp:include page="vitepublishing_book.jsp">
										<jsp:param name="bookId" value="${bookshelf.book1.bookId}" />
										<jsp:param name="bookTitle" value="${bookshelf.book1.bookTitle}" />
										<jsp:param name="authorFirst" value="${bookshelf.book1.author.firstName}" />
										<jsp:param name="authorLast" value="${bookshelf.book1.author.lastName}" />
										<jsp:param name="book1CurrChpt" value="${bookshelf.book1CurrChapter }"/>
										<jsp:param name="totalChapters" value="${bookshelf.book1.halfBookChptr }"/>
										<jsp:param name="bookColumn" value="1"/>
										<jsp:param name="fullbookhalfbook" value="halfbook" />
									</jsp:include>
									<jsp:include page="vitepublishing_book.jsp">
										<jsp:param name="bookId" value="${bookshelf.book2.bookId}" />
										<jsp:param name="bookTitle" value="${bookshelf.book2.bookTitle}" />
										<jsp:param name="authorFirst" value="${bookshelf.book2.author.firstName}" />
										<jsp:param name="authorLast" value="${bookshelf.book2.author.lastName}" />
										<jsp:param name="book2CurrChpt" value="${bookshelf.book2CurrChapter }"/>
										<jsp:param name="totalChapters" value="${bookshelf.book2.halfBookChptr }"/>
										<jsp:param name="bookColumn" value="2"/>
										<jsp:param name="fullbookhalfbook" value="halfbook" />
									</jsp:include>
									<jsp:include page="vitepublishing_book.jsp">
										<jsp:param name="bookId" value="${bookshelf.book3.bookId}" />
										<jsp:param name="bookTitle" value="${bookshelf.book3.bookTitle}" />
										<jsp:param name="authorFirst" value="${bookshelf.book3.author.firstName}" />
										<jsp:param name="authorLast" value="${bookshelf.book3.author.lastName}" />
										<jsp:param name="book3CurrChpt" value="${bookshelf.book3CurrChapter }"/>
										<jsp:param name="totalChapters" value="${bookshelf.book3.halfBookChptr }"/>
										<jsp:param name="bookColumn" value="3"/>
										<jsp:param name="fullbookhalfbook" value="halfbook" />
									</jsp:include>
									</tr>		
									<tr><td width="100%">&nbsp;</td></tr>	
								</c:when>
							</c:choose>
						</c:if>
						
					</c:forEach>
					
					<%-- <c:forEach var="halfBooksList" items="${halfBooks}" varStatus="loop" end="${fn:length(halfBooks)}">				
					
						<c:if test="${loop.index % 3 == 0 and loop.index <= fn:length(halfBooks) }"> 
							<tr>
								<c:choose>
									<c:when test="${(fn:length(halfBooks) - loop.index) % 1 == 0 and fn:length(halfBooks) == 1}">
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${halfBooks[loop.index].bookId}" />
											<jsp:param name="bookTitle" value="${halfBooks[loop.index].bookTitle}" />
											<jsp:param name="authorFirst" value="${halfBooks[loop.index].author.firstName}" />
											<jsp:param name="authorLast" value="${halfBooks[loop.index].author.lastName}" />
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
									</c:when>
									<c:when test="${(fn:length(halfBooks) - loop.index) % 2 == 0}">
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${halfBooks[loop.index].bookId}" />
											<jsp:param name="bookTitle" value="${halfBooks[loop.index].bookTitle}" />
											<jsp:param name="authorFirst" value="${halfBooks[loop.index].author.firstName}" />
											<jsp:param name="authorLast" value="${halfBooks[loop.index].author.lastName}" />
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${halfBooks[loop.index+1].bookId}" />
											<jsp:param name="bookTitle" value="${halfBooks[loop.index+1].bookTitle}" />
											<jsp:param name="authorFirst" value="${halfBooks[loop.index+1].author.firstName}" />
											<jsp:param name="authorLast" value="${halfBooks[loop.index+1].author.lastName}" />
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
									</c:when>
									<c:otherwise>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${halfBooks[loop.index].bookId}" />
											<jsp:param name="bookTitle" value="${halfBooks[loop.index].bookTitle}" />
											<jsp:param name="authorFirst" value="${halfBooks[loop.index].author.firstName}" />
											<jsp:param name="authorLast" value="${halfBooks[loop.index].author.lastName}" />
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${halfBooks[loop.index+1].bookId}" />
											<jsp:param name="bookTitle" value="${halfBooks[loop.index+1].bookTitle}" />
											<jsp:param name="authorFirst" value="${halfBooks[loop.index+1].author.firstName}" />
											<jsp:param name="authorLast" value="${halfBooks[loop.index+1].author.lastName}" />
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include>
										<jsp:include page="vitepublishing_book.jsp">
											<jsp:param name="bookId" value="${halfBooks[loop.index+2].bookId}" />
											<jsp:param name="bookTitle" value="${halfBooks[loop.index+2].bookTitle}" />
											<jsp:param name="authorFirst" value="${halfBooks[loop.index+2].author.firstName}" />
											<jsp:param name="authorLast" value="${halfBooks[loop.index+2].author.lastName}" />
											<jsp:param name="fullbookhalfbook" value="halfbook" />
										</jsp:include> 

									</c:otherwise>
								</c:choose>

							</tr>		
							<tr><td width="100%">&nbsp;</td></tr>	
						</c:if> 	
						</c:forEach> --%>

					</table>
				</td>
			</tr>
			</c:when>
			</c:choose>
		</table>
	</div>

</body>
</html>
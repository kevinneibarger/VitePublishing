<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	$(document)
			.ready(
					function() {
						
						$("#buyFullBook").css('cursor','pointer');
						$("#moreInCatButton").css('cursor', 'pointer');
						$("#moreByAuthorButton").css('cursor', 'pointer');
						
						$("#moreInCatButton").click(function() {
							window.location='${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/all';
						});

						$("#moreByAuthorButton").click(function() {
							window.location='${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/all';
						});
						
						$(function() {
							$("#dialog")
									.dialog(
											{
												autoOpen : false,
												modal : true,
												width : 500,
												height : 300,
												buttons : {
													"Yes, I want to buy" : function() {
														$(this).dialog("close");

														// Add Ajax call here - bookshelfBo.buyFullBook(new Long(readerId).longValue(), new Long(bookId).longValue());
														$
																.ajax({

																	type : "GET",
																	url : '${pageContext.request.contextPath}/vitepub/publishercontroller/buybook?readerId=${sessionScope.readerId}&bookId=${sessionScope.bookId}',
																	async : false,
																	// data: {'name':name,'email': email, 'fbId' : fbId},
																	success : function(
																			data) {
																		window.location = '${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=${sessionScope.readerId}';
																	},
																	complete : function() {
																	},
																	error : function(
																			xhr,
																			textStatus,
																			errorThrown) {
																		console
																				.log('ajax loading error...');
																		return false;
																	}
																});
													},
													"No, I changed my mind" : function() {
														$(this).dialog("close");
													}
												}
											});

							$("#buyFullBook").on("click", function() {
								$("#dialog").dialog("open");
							});
						});
					});
</script>

<link href="${pageContext.request.contextPath}/css/vitepub.css"
	rel="stylesheet">
</head>
<body style="overflow: auto;" bgcolor="#fff">
	<c:set var="book" value="${bookById}" />
	<c:set var="chaptersNum" value="${book.halfBookChptr}" />
	<c:set var="firstHalfChapters" value="${firstHalfChaptersList }" />
	<c:set var="secondHalfChapters" value="${secondHalfChaptersList }" />
	<c:set var="allChapters" value="${fullBookChaptersList }" />
	<c:set var="fullorhalfbook" value="${typebook}" />
	<c:set var="bookCost" value="${bookCost}" />
	<c:set var="fromBookshelf" value="true" />

	<%-- Test VARS --%>
	<c:set var="loggedin" value="${sessionScope.loggedin}" />

	<c:choose>
		<c:when test="${fullorhalfbook ne null and fullorhalfbook ne ''}">
			<c:choose>
				<c:when test="${fullorhalfbook eq 'fullbook'}">
					<c:set var="fullbook" value="true" />
					<c:set var="readablechpts" value="${chaptersNum }"/>
				</c:when>
				<c:otherwise>
					<c:set var="fullbook" value="false" />
					<c:set var="readablechpts" value="${chaptersNum / 2}"/>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<c:set var="fromBookshelf" value="false" />
		</c:otherwise>
	</c:choose>

	<jsp:include page="../navigation/topNavVitePub.jsp" />
	<%--<jsp:include page="../navigation/vitepublishing_book_detail_header.jsp">
		<jsp:param value="${fromBookshelf}" name="frombookshelf"/>
		<jsp:param value="${fullbook}" name="isfullbook"/>
		<jsp:param value="${book.bookTitle}" name="bookTitle"/>
		<jsp:param value="${book.author.firstName}" name="authorFirst"/>
		<jsp:param value="${book.author.lastName}" name="authorLast"/>
		<jsp:param value="${bookCost}" name="bookCost"/>
	</jsp:include> --%>

	<div id="divmainpagewrapper">
		<div id="dialog" title="Buy This Book"
			style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
			<table>
				<tr>
					<td>
						<!-- Book Img --> <span
						style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
							<img src="${pageContext.request.contextPath}/images/books.png">
					</span>
					</td>
					<td>
						<!-- Book Title -->
						<div
							style="font-family: Calibri; font-size: 18pt; color: #2B3D8F; font-weight: bold; width: 240px">
							<c:out value="${book.bookTitle}" />
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<!-- Author Name -->
						<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;BY
							<c:out value="${book.author.firstName}" />&nbsp;<c:out value="${book.author.lastName}" />
						</div>
					</td>
					<td>
						<!-- Book Cost -->
						<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;Price: $<c:out value="${bookCost}" />
						</div>
					</td>
				</tr>
			</table>
		</div>

		<table width="100%" bgcolor="#fff">
			<tr>
				<td>
					<table>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td><img
								src="${pageContext.request.contextPath}/images/user_man-128.png">
							</td>
							<td>
								<div class="welcome_identifier"
									style="font-family: Calibri; font-size: 20pt; color: #000; font-weight: bold">
									<span class="book_title"
										style="font-family: Calibri; font-size: 20pt; color: #2B3D8F; font-weight: bold">
										<c:out value="${book.bookTitle}" />
									</span>

								</div>
								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
									BY
									<c:out value="${book.author.firstName}" />
									,
									<c:out value="${book.author.lastName}" />
									[1 BOOK(S)]
								</div>
							</td>
							<td style="width: 450px" align="right">
								<table>
									<tr>
										<td>
											<div id="moreByAuthorButton">
												<span><img
													src="${pageContext.request.contextPath}/images/category.png">
												</span>
											</div>


										</td>
										<td id="moreByAuthorButton"><span style="margin-top: 0px;">SEE MORE BY
												AUTHOR</span></td>
									</tr>
									<tr>
										<td>
											<div id="moreInCatButton">
												<span><img
													src="${pageContext.request.contextPath}/images/category.png">
												</span>
											</div>


										</td>
										<td id="moreInCatButton"><span style="margin-top: 0px;">SEE MORE BY
												CATEGORY</span></td>
									</tr>
									<c:if test="${!fullbook}">
									<tr>
										<td>
											<div id="buyFullBook">
												<span><img
													src="${pageContext.request.contextPath}/images/category.png">
												</span>
											</div>


										</td>
										<td id="buyFullBook"><span style="margin-top: 0px;">ADD
												TO BOOKSHELF</span></td>
									</tr>
									</c:if>
								</table>


							</td>


						</tr>


					</table>
				</td>
			</tr>

			<tr>
				<td>&nbsp;</td>
			</tr>

			<tr>
				<td>
					<table>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td style="width: 50px;">&nbsp;</td>
							<td>
								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
									CATEGORY: <span
										style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
										<c:out value="${book.category}"/> [ 100 BOOK(S)] </span>

								</div>
							</td>
						</tr>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td style="width: 50px;">&nbsp;</td>
							<td>
								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
									SUB-CATEGORY: <span
										style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
										<c:out value="${book.subCategory}"/> [ 10 BOOK(S)] </span>

								</div>
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


			<tr>

				<td>
					<table>
						<tr>
							<td style="width: 150px;">&nbsp;</td>
							<td style="width: 300px;"><div class="bookshelf_text"
									style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
									NUMBER OF CHAPTERS: <span
										style="font-family: Calibri; font-size: 11pt; color: #000; font-weight: bold">
										<c:out value="${book.halfBookChptr}"/> CHAPTERS </span>

								</div></td>
							<td>
								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
									NUMBER OF WORDS: <span
										style="font-family: Calibri; font-size: 11pt; color: #000; font-weight: bold">
										UNKNOWN </span>

								</div>
							</td>
							<td style="width: 400px;">&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td style="width: 200px;">&nbsp;</td>
							<td colspan="2">

								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
									SUMMARY: <span
										style="font-family: Calibri; font-size: 10pt; color: #000;">
										<c:out value="${book.bookSummary }"/> </span>
								</div>


							</td>
							<td>&nbsp;</td>

						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td colspan="2">
								<div class="bookshelf_text"
									style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
									TABLE OF CONTENTS: <span
										style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
										<c:out value="${book.bookTitle}"/> </span>
								</div>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><div class="progress">
									<div class="progress-bar" role="progressbar" aria-valuenow="5"
										aria-valuemin="0" aria-valuemax="100" style="width: 5%;">
										<span class="show">5% READ (ON CHAPTER 3)</span>
									</div>
								</div>


								<div style="margin-top: 0px; margin-left: 20px;">
									<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${book.bookId}&chapterNum=${chapter}&chapterCount=${readablechpts}&typebook=${fullorhalfbook}&frombookshelf=${fromBookshelf}"><span
										style="font-family: Calibri; font-size: 10pt; color: #2B3D8F; font-style: italic;">
											GO TO CHAPTER 1</span></a>
								</div></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
						</tr>
						<tr id="chapterslist">
							<td>&nbsp;</td>
							<td colspan="3">
								<table>
									<c:forEach items="${allChapters}" var="chapter">
										<%-- Get 2nd column Chapters --%>
										<fmt:parseNumber var="columnTwoChpt" value="${(fn:length(allChapters) / 2) + chapter}"/>
											<tr>
												<td style="width: 55px;">&nbsp;
												</td>
												<c:if test="${fn:contains(firstHalfChaptersList, chapter)}"> 
													<td style="width: 375px; border-bottom: solid 1px; padding: 10px;">
														<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${book.bookId}&chapterNum=${chapter}&chapterCount=${readablechpts}&typebook=${fullorhalfbook}&frombookshelf=${fromBookshelf}"> > CHAPTER ${chapter} -
															<c:if test="${!loggedin and allChapters eq '1'}">
																<span> 
																	FREE PREVIEW - LOGIN TO READ MORE
																</span>
															</c:if>
															<c:if test="${loggedin or fullbook}">
																<span> 
																	READ NOW
																</span>
															</c:if>
														</a>
													</td>
												</c:if> 
												<td style="width: 55px;">&nbsp;</td>
													<c:if test="${columnTwoChpt <= fn:length(allChapters) }">
														<c:if test="${fn:contains(secondHalfChaptersList, columnTwoChpt)}">
															<td style="width: 375px; border-bottom: solid 1px; padding: 10px;">
																	<c:if test="${!loggedin or loggedin and !fullbook}">
																		<span> 
																			 CHAPTER ${columnTwoChpt} - PURCHASE TO READ 
																		</span>
																	</c:if>
																	<c:if test="${fullbook and loggedin}">
																		<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${book.bookId}&chapterNum=${columnTwoChpt}&chapterCount=${readablechpts}&typebook=${fullorhalfbook}&frombookshelf=${fromBookshelf}"> > CHAPTER ${columnTwoChpt} -
																		<span> 
																			READ NOW
																		</span>
																		</a>
																	</c:if>
															</td>
														</c:if>
													</c:if>
												</tr>
											</c:forEach>
										</table>
									</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
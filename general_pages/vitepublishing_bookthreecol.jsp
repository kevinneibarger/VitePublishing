<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="fullorhalf" value="${param.fullbookhalfbook}"/>
<c:set var="bookshelf" value="${param.bookshelf}"/>
<c:set var="bookNumCol" value="${param.bookColumn }"/>
<c:set var="book1" value="${param.book1}"/>
<c:set var="book2" value="${param.book2}"/>
<c:set var="book3" value="${param.book3}"/>

<!-- Book 1 data -->
<c:set var="bookId1" value="${book1.bookId}"/>
<c:set var="bookTitle1" value="${book1.bookTitle}"/>
<c:set var="authorFirst1" value="${book1.author.firstName}"/>
<c:set var="authorLast1" value="${book1.author.firstName}"/>
<c:set var="chaptersNum1" value="${book1.halfBookChptr}"/>
<c:set var="book1Chpt" value="${book1.book1CurrChapter }"/>

<!-- Book 2 data -->
<c:set var="bookId2" value="${book2.bookId}"/>
<c:set var="bookTitle2" value="${book2.bookTitle}"/>
<c:set var="authorFirst2" value="${book2.author.firstName}"/>
<c:set var="authorLast2" value="${book2.author.firstName}"/>
<c:set var="chaptersNum2" value="${book2.halfBookChptr}"/>
<c:set var="book2Chpt" value="${book2.book1CurrChapter }"/>

<!-- Book 3 data -->
<c:set var="bookId3" value="${book3.bookId}"/>
<c:set var="bookTitle3" value="${book3.bookTitle}"/>
<c:set var="authorFirst3" value="${book3.author.firstName}"/>
<c:set var="authorLast3" value="${book3.author.firstName}"/>
<c:set var="chaptersNum3" value="${book3.halfBookChptr}"/>
<c:set var="book3Chpt" value="${book3.book1CurrChapter }"/>

<c:choose>
	<c:when test="${fullorhalf eq 'fullbook'}">
		<c:set var="readablechpts1" value="${chaptersNum1 }"/>
	</c:when>
	<c:otherwise>
		<c:set var="readablechpts1" value="${chaptersNum1 / 2}"/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${fullorhalf eq 'fullbook'}">
		<c:set var="readablechpts2" value="${chaptersNum2 }"/>
	</c:when>
	<c:otherwise>
		<c:set var="readablechpts2" value="${chaptersNum2 / 2}"/>
	</c:otherwise>
</c:choose>

<c:choose>
	<c:when test="${fullorhalf eq 'fullbook'}">
		<c:set var="readablechpts3" value="${chaptersNum3 }"/>
	</c:when>
	<c:otherwise>
		<c:set var="readablechpts3" value="${chaptersNum3 / 2}"/>
	</c:otherwise>
</c:choose>
			
<c:choose>
	<c:when test="${bookNumCol eq '1' }">
		<c:set var="currentChapter" value="${book1Chpt}"/>
	</c:when>
	<c:when test="${bookNumCol eq '2' }">
		<c:set var="currentChapter" value="${book2Chpt}"/>
	</c:when>
	<c:otherwise>
		<c:set var="currentChapter" value="${book3Chpt}"/>
	</c:otherwise>
</c:choose>


	<!-- Spacer Cell -->
	<td style="width: 200px; border-right: thin solid #2B3D8F;">&nbsp;</td>

	<td style="border-top: thin solid #2B3D8F; border-bottom: thin solid #2B3D8F; border-right: thin solid #2B3D8F; width: 440px">
	<table>
		<tr>
			<td>
				<!-- Book Img -->
				<span
						style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
					<img src="${pageContext.request.contextPath}/images/books.png">
					</span>
				</td>
				<td>
					<!-- Book Title -->
					<div style="font-family: Calibri; font-size: 18pt; color: #2B3D8F; font-weight: bold; width: 240px">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId1}&typebook=${fullorhalf}">
							<c:out value="${bookTitle1}"/>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<!-- Author Name -->
					<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;BY <c:out value="${authorFirst1}"/>&nbsp;<c:out value="${authorLast1}"/>
					</div>
				</td>
			</tr>

			<!-- Spacer Row -->
			<tr>
				<td>
					<div>&nbsp;&nbsp;
					</td>
				</tr>

				<!-- Reading Progress Row -->
				<tr>
					<td align="center">
						<div style="margin-bottom: 20px">
							<div
								style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
								&nbsp;&nbsp;PROGRESS:</div>
						</div>
					</td>
					<td>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="5"
								aria-valuemin="0" aria-valuemax="100" e="width: 5%;">
								<span class="show"> 5% READ (ON CHAPTER <c:out value="${currentChapter}"/>) </span>
							</div>
						</div>
					</td>
				</tr>

				<!-- Spacer Row -->
				<tr>
					<td>&nbsp;&nbsp;</td>
				</tr>

				<!-- Goto Book Summary or Chapter Row -->
				<tr>
					<td>
						<div
							style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId1}&typebook=${fullorhalf}">GO
								TO SUMMARY</a>
						</div>
					</td>
					<td align="right">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${bookId1}&chapterNum=${currentChapter}&chapterCount=${readablechpts1}&typebook=${fullorhalf}&frombookshelf=true">
							<div
								style="margin-top: 0px; font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
								GOTO CHAPTER <c:out value="${currentChapter}"/> 
							</div>
						</a>
					</td>

				</tr>
			</table>
		</td>
		
	<td style="width: 200px; border-right: thin solid #2B3D8F;">&nbsp;</td>

	<td style="border-top: thin solid #2B3D8F; border-bottom: thin solid #2B3D8F; border-right: thin solid #2B3D8F; width: 440px">
	<table>
		<tr>
			<td>
				<!-- Book Img -->
				<span
						style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
					<img src="${pageContext.request.contextPath}/images/books.png">
					</span>
				</td>
				<td>
					<!-- Book Title -->
					<div style="font-family: Calibri; font-size: 18pt; color: #2B3D8F; font-weight: bold; width: 240px">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId2}&typebook=${fullorhalf}">
							<c:out value="${bookTitle2}"/>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<!-- Author Name -->
					<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;BY <c:out value="${authorFirst2}"/>&nbsp;<c:out value="${authorLast2}"/>
					</div>
				</td>
			</tr>

			<!-- Spacer Row -->
			<tr>
				<td>
					<div>&nbsp;&nbsp;
					</td>
				</tr>

				<!-- Reading Progress Row -->
				<tr>
					<td align="center">
						<div style="margin-bottom: 20px">
							<div
								style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
								&nbsp;&nbsp;PROGRESS:</div>
						</div>
					</td>
					<td>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="5"
								aria-valuemin="0" aria-valuemax="100" e="width: 5%;">
								<span class="show"> 5% READ (ON CHAPTER <c:out value="${currentChapter}"/>) </span>
							</div>
						</div>
					</td>
				</tr>

				<!-- Spacer Row -->
				<tr>
					<td>&nbsp;&nbsp;</td>
				</tr>

				<!-- Goto Book Summary or Chapter Row -->
				<tr>
					<td>
						<div
							style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId2}&typebook=${fullorhalf}">GO
								TO SUMMARY</a>
						</div>
					</td>
					<td align="right">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${bookId2}&chapterNum=${currentChapter}&chapterCount=${readablechpts2}&typebook=${fullorhalf}&frombookshelf=true">
							<div
								style="margin-top: 0px; font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
								GOTO CHAPTER <c:out value="${currentChapter}"/> 
							</div>
						</a>
					</td>

				</tr>
			</table>
		</td>
		
		<td style="width: 200px; border-right: thin solid #2B3D8F;">&nbsp;</td>

	<td style="border-top: thin solid #2B3D8F; border-bottom: thin solid #2B3D8F; border-right: thin solid #2B3D8F; width: 440px">
	<table>
		<tr>
			<td>
				<!-- Book Img -->
				<span
						style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
					<img src="${pageContext.request.contextPath}/images/books.png">
					</span>
				</td>
				<td>
					<!-- Book Title -->
					<div style="font-family: Calibri; font-size: 18pt; color: #2B3D8F; font-weight: bold; width: 240px">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId3}&typebook=${fullorhalf}">
							<c:out value="${bookTitle3}"/>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<!-- Author Name -->
					<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;BY <c:out value="${authorFirst3}"/>&nbsp;<c:out value="${authorLast3}"/>
					</div>
				</td>
			</tr>

			<!-- Spacer Row -->
			<tr>
				<td>
					<div>&nbsp;&nbsp;
					</td>
				</tr>

				<!-- Reading Progress Row -->
				<tr>
					<td align="center">
						<div style="margin-bottom: 20px">
							<div
								style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
								&nbsp;&nbsp;PROGRESS:</div>
						</div>
					</td>
					<td>
						<div class="progress">
							<div class="progress-bar" role="progressbar" aria-valuenow="5"
								aria-valuemin="0" aria-valuemax="100" e="width: 5%;">
								<span class="show"> 5% READ (ON CHAPTER <c:out value="${currentChapter}"/>) </span>
							</div>
						</div>
					</td>
				</tr>

				<!-- Spacer Row -->
				<tr>
					<td>&nbsp;&nbsp;</td>
				</tr>

				<!-- Goto Book Summary or Chapter Row -->
				<tr>
					<td>
						<div
							style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId3}&typebook=${fullorhalf}">GO
								TO SUMMARY</a>
						</div>
					</td>
					<td align="right">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${bookId3}&chapterNum=${currentChapter}&chapterCount=${readablechpts3}&typebook=${fullorhalf}&frombookshelf=true">
							<div
								style="margin-top: 0px; font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
								GOTO CHAPTER <c:out value="${currentChapter}"/> 
							</div>
						</a>
					</td>

				</tr>
			</table>
		</td>
											
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="bookId" value="${param.bookId}"/>
<c:set var="bookTitle" value="${param.bookTitle}"/>
<c:set var="authorFirst" value="${param.authorFirst}"/>
<c:set var="authorLast" value="${param.authorLast}"/>
<c:set var="fullorhalf" value="${param.fullbookhalfbook}"/>
<c:set var="book1Chpt" value="${param.book1CurrChpt}"/>
<c:set var="book2Chpt" value="${param.book2CurrChpt}"/>
<c:set var="book3Chpt" value="${param.book3CurrChpt}"/>
<c:set var="bookNumCol" value="${param.bookColumn }"/>
<c:set var="chaptersNum" value="${param.totalChapters }"/>

<c:choose>
	<c:when test="${fullorhalf eq 'fullbook'}">
		<c:set var="readablechpts" value="${chaptersNum }"/>
	</c:when>
	<c:otherwise>
		<c:set var="readablechpts" value="${chaptersNum / 2}"/>
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

<c:choose>
	<c:when test="${bookTitle eq '' and authorFirst eq '' and authorLast eq ''}">
		<td style="width: 200px">&nbsp;</td>
		<td style="width: 440px">&nbsp;
		<table>
		<tr>
			<td>
				<!-- Book Img -->
				<span style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
					&nbsp;
					</span>
				</td>
				<td>
					<div style="font-family: Calibri; font-size: 18pt; color: #2B3D8F; font-weight: bold; width: 240px">
					&nbsp;
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<!-- Author Name -->
					<div style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;
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
							<div style="font-family: Calibri; font-size: 12pt; color: #000; font-weight: bold">
								&nbsp;</div>
						</div>
					</td>
					<td>
						<div>
							<div>
								<span> &nbsp;</span>
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
							&nbsp;
						</div>
					</td>
					<td align="right">
						<div
							style="margin-top: 0px; font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
							&nbsp;</div>
					</td>

				</tr>
			</table>
		</td>
	</c:when>
<c:otherwise>
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
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId}&typebook=${fullorhalf}">
							<c:out value="${bookTitle}"/>
						</a>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<!-- Author Name -->
					<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;BY <c:out value="${authorFirst}"/>&nbsp;<c:out value="${authorLast}"/>
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
							&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${bookId}&typebook=${fullorhalf}">GO
								TO SUMMARY</a>
						</div>
					</td>
					<td align="right">
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId=${bookId}&chapterNum=${currentChapter}&chapterCount=${readablechpts}&typebook=${fullorhalf}&frombookshelf=true">
							<div
								style="margin-top: 0px; font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
								GOTO CHAPTER <c:out value="${currentChapter}"/> 
							</div>
						</a>
					</td>

				</tr>
			</table>
		</td>
</c:otherwise>	
</c:choose>

											
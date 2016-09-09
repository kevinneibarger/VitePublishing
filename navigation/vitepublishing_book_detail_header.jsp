<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Navigation Bar</title>
<link href="${pageContext.request.contextPath}/css/vitepub.css"
	rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function() {

		$("#moreInCatButton").css('cursor', 'pointer');
		$("#moreByAuthorButton").css('cursor', 'pointer');
		$("#bookChapters").css('cursor', 'pointer');
		$("#addToBookshelf").css('cursor', 'pointer');
		$("#buyFullBook").css('cursor', 'pointer');
		$("#backToBookshelf").css('cursor', 'pointer');

		$("#moreInCatButton").click(function() {
			alert("Goto To Books By Category Page");
		});

		$("#moreByAuthorButton").click(function() {
			alert("Goto To Books By Author Page");
		});

		$('#tableofcontents').hide();
		$('#gotochpterone').hide();
		//$('#chapterslist').hide();
		
		$("#bookChapters").click(function() {
			$('#tableofcontents').show();
			$('#gotochpterone').show();
			$('#chapterslist').show();
		});

		$("#addToBookshelf").click(function() {
			alert("Goto To Bookshelf page and add book");
		});
		
		$("#backToBookshelf").click(function() {
			 $.ajax({

                type: "GET",
                url: '${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=${sessionScope.readerId}',        
                async: false,
               // data: {'name':name,'email': email, 'fbId' : fbId},
                success: function(data) { 
               	 window.location = '${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=${sessionScope.readerId}';  
                },
                complete: function() {},
                error: function(xhr, textStatus, errorThrown) 
                {
                  console.log('ajax loading error...');
                  return false;
                }
         });
		});
		
		$(function() {
			$("#dialog").dialog({
					autoOpen: false,
					modal: true,
					width: 500,
					height: 300,
					buttons: {
						"Yes, I want to buy": function() {
							$(this).dialog("close");
							
							// Add Ajax call here - bookshelfBo.buyFullBook(new Long(readerId).longValue(), new Long(bookId).longValue());
							 $.ajax({

				                type: "GET",
				                url: '${pageContext.request.contextPath}/vitepub/publishercontroller/buybook?readerId=${sessionScope.readerId}&bookId=${sessionScope.bookId}',        
				                async: false,
				               // data: {'name':name,'email': email, 'fbId' : fbId},
				                success: function(data) { 
				               	 window.location = '${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=${sessionScope.readerId}';  
				                },
				                complete: function() {},
				                error: function(xhr, textStatus, errorThrown) 
				                {
				                  console.log('ajax loading error...');
				                  return false;
				                }
							 });
						},
						"No, I changed my mind": function() {
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
</head>
<body style="overflow: auto;" bgcolor="#fff">
	<c:set var="frombookshelf" value="${param.frombookshelf}"/>
	<c:set var="fullbook" value="${param.isfullbook}"/>
	<c:set var="bookTitle" value="${param.bookTitle}"/>
	<c:set var="authorF" value="${param.authorFirst}"/>
	<c:set var="authorL" value="${param.authorLast}"/>
	<c:set var="bookCost" value="${param.bookCost}"/>

	<div id="dialog" title="Buy This Book" style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
		<table>
		<tr>
			<td>
				<!-- Book Img -->
				<span style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
					<img src="${pageContext.request.contextPath}/images/books.png">
					</span>
			</td>
			<td>
					<!-- Book Title -->
					<div style="font-family: Calibri; font-size: 18pt; color: #2B3D8F; font-weight: bold; width: 240px">
						<c:out value="${bookTitle}"/>
					</div>
			</td>
		</tr>
		<tr>
			<td>
					<!-- Author Name -->
					<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;BY <c:out value="${authorF}"/>
							&nbsp;&nbsp;<c:out value="${authorL}"/>
					</div>
				</td>
			<td>
			<!-- Book Cost -->
					<div
							style="font-family: Calibri; font-size: 17pt; color: #000; font-weight: bold; width: 200px">
							&nbsp;&nbsp;Price: $<c:out value="${bookCost}"/>
					</div>
				</td>
				
			</tr>
		</table>
	</div>

	<table width="100%">
		<tr>
			<td>
				<table width="100%">
					<tr>
						<td>
							<div id="topcontainer">
								<div id="beforelogo">&nbsp;</div>
						</td>
						<td>
							<div>
								<img
									src="${pageContext.request.contextPath}/images/Header_logo.png">
							</div>
						</td>
						<td style="width: 300px;" align="right">
							<div id="searchlabel">Looking for a Online Book?</div>
						</td>
						<td align="left">
							<table>
								<tr>
									<td>
										<div id="searchbox">
											<input type="text" id="search" name="search" class="search"
												placeholder="Search For Authors or Books" /> <input
												type="button" class="button" value="Search" />
										</div>
									</td>
									<td align="left">
										<div id="status"
											style="margin-top: 40px; font-family: Calibri; font-size: 20px; font-weight: bold;">
											<input type="hidden" id="clicked" value="no" />
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" style="border-spacing: 0px;">
					<tr>
					<c:choose>
						<c:when test="${fullbook}">
							<td id="second">
							<div id="moreInCatButton">See More in Category</div>
							</td>
							<td id="second">
								<div id="moreByAuthorButton">See More by Author</div>
							</td>
							<td id="second">
								<div id="bookChapters">
									Chapters 
								<div>
							</td>
							<td id="second">
								<c:choose>
									<c:when test="${frombookshelf}">
										<div id="backToBookshelf">
											Back To Bookshelf
										<div>
									</c:when>
									<c:otherwise>
										<div id="addToBookshelf">
											Add To Bookshelf
										<div>
									</c:otherwise>
								</c:choose>
							</td>
						</c:when>
						<c:otherwise>
							<td id="second">
								<div id="moreInCatButton">See More in Category</div>
							</td>
							<td id="second">
								<div id="moreByAuthorButton">See More by Author</div>
							</td>
							<td id="second">
								<div id="bookChapters">
									Chapters 
								<div>
							</td>
							<td id="second">
								<c:choose>
									<c:when test="${frombookshelf}">
										<div id="backToBookshelf">
											Back To Bookshelf
										<div>
									</c:when>
									<c:otherwise>
										<div id="addToBookshelf">
											Add To Bookshelf
										<div>
									</c:otherwise>
								</c:choose>
							</td>
							<td id="second">
								<div id="buyFullBook">Buy Full Book</div>
							</td>
						</c:otherwise>
					</c:choose>	
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Top Navigation Bar</title>
	<link href="${pageContext.request.contextPath}/css/vitepub.css" rel="stylesheet"> 
	
	<script type="text/javascript">
          $(document).ready(function () {

        	 $("#buyFullBookChpt").css('cursor','pointer');
        	 $("#previousChapter").css('cursor','pointer');
        	 $("#nextChapter").css('cursor','pointer');
        	 $("#addToBookshelf").css('cursor','pointer');
        	 $("#backToBookshelf").css('cursor','pointer');
        	 $("#dialog-chapters").css('hidden', 'true');
        	 $("#homebutton").css('cursor','pointer');
       		 $("#homebutton").click(function () {
       			window.location =  "${pageContext.request.contextPath}/vitepub/publishercontroller/home";
       		 });
        	 
        	 var result = {};
        	 var params = window.location.search.split(/\?|\&/);
			 //alert("PARAMS: "+params);
			 
             params.forEach( function(it) {
                 
                 if (it.indexOf("=") != -1) {
                     var paramNameVal = it.split("=");
                     result[paramNameVal[0]] = paramNameVal[1];
                 }
             });
             
             var bookIdKey = Object.keys(result)[0];
             var bookIdVal = result[bookIdKey];
             var chapterNumKey = Object.keys(result)[1];
             var chapterCountKey = Object.keys(result)[2];
             var typebookKey = Object.keys(result)[3];
             var typebookVal = result[typebookKey];
             var frombookshelf = Object.keys(result)[4];
             var isfrombookshelf = false;
             
             if (frombookshelf != null && frombookshelf != undefined) {
 				 isfrombookshelf = true;           	 
             }
             
             var prevChapterNumVal = Number(result[chapterNumKey]) - 1;
             var nextChapterNumVal = Number(result[chapterNumKey]) + 1;
             var chapterCount = Number(result[chapterCountKey]);

     		  $("#previousChapter").click(function () {
     
     			 if (prevChapterNumVal > 0) {
     				 var prevChptURL = '${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId='+bookIdVal+'&chapterNum='+prevChapterNumVal+'&chapterCount='+chapterCount+'&typebook='+typebookVal+'&frombookshelf='+isfrombookshelf;
      			
		     			 $.ajax({
		
		                     type: "GET",
		                     url: prevChptURL,        
		                     async: false,
		                    // data: {'name':name,'email': email, 'fbId' : fbId},
		                     success: function(data)
		                     { 
		                   	
		                    	 window.location = prevChptURL;  
		                     },
		                     complete: function() {},
		                     error: function(xhr, textStatus, errorThrown) 
		                     {
		               
		                       console.log('ajax loading error...');
		                       return false;
		                     }
		                    
		              });     
     			  } else {
                 	 alert("Current Chapter is 1, there are no previous chapters.");
                  }
     		  });
   
     		 $("#nextChapter").click(function () {
     	
     			if (nextChapterNumVal <= chapterCount) {
	     			var nextChptURL = '${pageContext.request.contextPath}/vitepub/publishercontroller/bookchapterspage?bookId='+bookIdVal+'&chapterNum='+nextChapterNumVal+'&chapterCount='+chapterCount+'&typebook='+typebookVal+'&frombookshelf='+isfrombookshelf;
	     			
	     			$.ajax({
	
	                    type: "GET",
	                    url: nextChptURL,        
	                    async: false,
	                    success: function(data)
	                    { 
	                     window.location = nextChptURL;
	                   	  },
	                    complete: function() {},
	                    error: function(xhr, textStatus, errorThrown) 
	                    {
	                    	//alert("I AM Error...");
	                      console.log('ajax loading error...');
	                      return false;
	                    }
	                   
	             });     		  
	     		} else {
	               alert("You've reached the end of the book, or need to purchase to read further");
	            }
	     	});
             
             
             
     		 $("#addToBookshelf").click(function () {
     			 alert("Goto Bookshelf page and add book");
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
    			$("#dialog-chapters").dialog({
    					autoOpen: false,
    					modal: true,
    					width: 500,
    					height: 300,
    					buttons: {
    						"Yes, I want to buy": function() {
    							$(this).dialog("close");
    							
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
    			
    			$("#buyFullBookChpt").on("click", function() {
    				$("#dialog-chapters").dialog("open");
    			});
    		});
     		
          });
    </script>
	</head>
	<body style="overflow:auto;" bgcolor="#fff">
	
		<c:set var="frombookshelf" value="${param.frombookshelf}"/>
		<c:set var="fullbook" value="${param.isfullbook}"/>
		<c:set var="bookTitle" value="${param.title}"/>
		<c:set var="authorF" value="${param.first}"/>
		<c:set var="authorL" value="${param.last}"/>
		<c:set var="bookCost" value="${param.bookCost}"/>
		
		<div id="dialog-chapters" title="Buy This Book" style="font-family: Calibri; font-size: 12pt; color: #2B3D8F; font-weight: bold">
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
		
		<table width="100%" >
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
							src="${pageContext.request.contextPath}/images/Header_logo.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	
						<img src="${pageContext.request.contextPath}/images/home.png" id="homebutton"> 
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
					<table width="100%" style="border-spacing:0px;">
						<tr>	
							<c:choose>
								<c:when test="${fullbook}">
									<!-- Don't display "Buy Full Book" -->
									<td id="second">
										<div id="nextChapter">Next Chapter</div>
									</td>
									<td id="second">
										<div id="previousChapter">Previous Chapter<div>
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
									<!-- Display "Buy Full Book" -->
									<td id="second">
										<div id="buyFullBookChpt">Buy Full Book</div>		
									</td>
									<td id="second">
										<div id="nextChapter">Next Chapter</div>
									</td>
									<td id="second">
										<div id="previousChapter">Previous Chapter<div>
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
								</c:otherwise>
							</c:choose>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</td>
</tr>
</table>
</body>
</html>
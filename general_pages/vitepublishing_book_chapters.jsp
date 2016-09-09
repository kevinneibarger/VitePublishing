<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	$(document).ready(function() {
		
    	 $("#previousChapter").css('cursor','pointer');
    	 $("#nextChapter").css('cursor','pointer');
    	 
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
	});
</script>

<link href="${pageContext.request.contextPath}/css/vitepub.css"
	rel="stylesheet">
</head>
<body>
	
	<!-- Create an iFrame and put the Chapter selected in as PDF -->
	<c:set var="bookId" value="${bookId}"/>
	<c:set var="chapterNum" value="${chapterNum}"/>
	<c:set var="pdfFilename" value="${pdfFileName}"/>
	<c:set var="chapterContent" value="${chapterText}"/>
	<c:set var="frombookshelf" value="${frombookshelf}"/>
	<c:set var="typebook" value="${typebook}"/>
	<c:set var="bookTitle" value="${bookTitle}"/>
	<c:set var="authorFirst" value="${authorFirstname}"/>
	<c:set var="authorLast" value="${authorLastname}"/>
	<c:set var="bookCost" value="${bookCost}"/>
	
	<c:choose>
		<c:when test="${typebook ne null and typebook ne ''}">
			<c:choose>
				<c:when test="${typebook eq 'fullbook'}">
					<c:set var="fullbook" value="true"/>
				</c:when>
				<c:otherwise>
					<c:set var="fullbook" value="false"/>
				</c:otherwise>
			</c:choose>
		</c:when>
	</c:choose>
	
	<jsp:include page="../navigation/topNavVitePub.jsp"/>
	
	<%--<jsp:include page="../navigation/vitepublishing_book_chapters_header.jsp">
		<jsp:param value="${frombookshelf}" name="frombookshelf"/>
		<jsp:param value="${fullbook}" name="isfullbook"/>
		<jsp:param value="${bookTitle}" name="title"/>
		<jsp:param value="${authorFirst}" name="first"/>
		<jsp:param value="${authorLast}" name="last"/>
		<jsp:param value="${bookCost}" name="bookCost"/>
	</jsp:include> --%>
		
	<center>
	<table cellpadding="4" cellspacing="8" width="25%">
		<tr>
		<td width="50%" align="right" id="previousChapter">
			<b>PREV CHAPTER&nbsp;&nbsp;|</b>
		</td>
		<td width="50%" align="left" id="nextChapter">
			<b>NEXT CHAPTER</b>
		</td>
		</tr>
	</table>
	
	<iframe src="${pageContext.request.contextPath}/vitepub/publishercontroller/getbookchapterPDF?bookId=${bookId}&chapterNum=${chapterNum}" 
		height="800" width="1000"/>
		
	</center>
	
	<%--<table width="75%" align="center">
		<tr>
			<td> &nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td> &nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr align="center">
			<td align="center">
			<font size="5"><center><b><i>CHAPTER <c:out value="${chapterNum}"/></i></b>
			</center></font></td>
		</tr>
		<tr>
			<td> &nbsp;&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td width="100%">
			<c:out value="${chapterContent}"/>
			</td>
		</tr>
	</table> --%>

</body>
</html>
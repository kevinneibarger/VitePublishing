<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
          $(document).ready(function () {
     	 });
 </script>
    
<link href="${pageContext.request.contextPath}/css/vitepub.css"
	rel="stylesheet">
</head>
<body style="overflow: auto;" bgcolor="#fff">
	<%-- <c:set var="fullBooksOnBookshelf" value="${fullBooks}"/>
	<c:set var="fullBooksCount" value="${fullBooksCount}"/>
	<c:set var="halfBooksOnBookShelf" value="${halfBooks}"/>
	<c:set var="halfBooksCount" value="${halfBooksCount}"/> --%>
	
	<jsp:include page="../navigation/topNavVitePub.jsp"/>

	<div id="divmainpagewrapper">
		<table width="100%" bgcolor="#fff" >
			<tr>

				<td>
					<table >

						<tr>
							<td>&nbsp;</td>
							<td colspan="2"><br>
								<div class="container">
									

									<ul class="pagination">
									    <li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/all">All</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/a">A</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/b">B</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/c">C</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/d">D</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/e">E</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/f">F</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/g">G</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/h">H</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/i">I</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/j">J</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/k">K</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/l">L</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/m">M</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/n">N</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/o">O</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/p">P</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/q">Q</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/r">R</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/s">S</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/t">T</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/u">U</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/v">V</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/w">W</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/x">X</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/y">Y</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/z">Z</a></li>
									</ul>
								</div>
								</td>
								</tr>
								<tr>
								  <td>&nbsp; </td><td> <div class="bookshelf_text"
										style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
									Top Categories
									<br>
									</div></td>
								</tr>
								<tr> 
								 <td> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> 
								 <td>
								  <table>
								<c:forEach var="categoryList" items="${getCategoryList}">
											<tr>
												<td>

													<div>
														&nbsp;&nbsp;
														<c:out value="${categoryList}" />
														&nbsp; 
														<hr width="250px">
													</div>

												</td>
											</tr>
										</c:forEach>
									</table>
									</td>
																
								</tr>
						</table>
		</td>
			</tr>
		</table>
</div>

</body>
</html>
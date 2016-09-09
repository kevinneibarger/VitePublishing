<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authors</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link href="${pageContext.request.contextPath}/css/vitepub.css" rel="stylesheet"> 
<script src="${pageContext.request.contextPath}/js/jquery.popupoverlay.js"></script>
<script src="http://code.jquery.com/jquery-git.js"></script>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
									    <li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/all">All</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/a">A</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/b">B</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/c">C</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/d">D</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/e">E</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/f">F</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/g">G</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/h">H</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/i">I</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/j">J</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/k">K</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/l">L</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/m">M</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/n">N</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/o">O</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/p">P</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/q">Q</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/r">R</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/s">S</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/t">T</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/u">U</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/v">V</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/w">W</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/x">X</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/y">Y</a></li>
										<li><a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/z">Z</a></li>
									</ul>
								</div>
								</td>
								</tr>
								<tr>
								  <td>&nbsp; </td><td> <div class="bookshelf_text"
										style="font-family: Calibri; font-size: 16pt; color: #2B3D8F; font-weight: bold">
									Top Authors
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
								<c:forEach var="authorList" items="${getAuthorList}">
											<tr>
												<td>

													<div>
														&nbsp;&nbsp;
														<c:out value="${authorList.firstName}" />
														,
														<c:out value="${authorList.lastName}" />
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
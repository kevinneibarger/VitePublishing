<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Navigation Bar</title>
<link href="${pageContext.request.contextPath}/css/vitepub.css"
	rel="stylesheet">

<script type="text/javascript">
	$(document).ready(function() {
		$("#fullBooksButton").css('cursor', 'pointer');
		$("#halfBooksButton").css('cursor', 'pointer');
		$("#changePswdButton").css('cursor', 'pointer');
		 $("#homebutton").css('cursor','pointer');
   		 $("#homebutton").click(function () {
   			window.location =  "${pageContext.request.contextPath}/vitepub/publishercontroller/home";
   		 });

		$("#fullBooksButton").click(function() {
			$('#full_book_title_row').show();
			$('#full_book_row').show();
			$('#half_book_title_row').hide();
			$('#half_book_row').hide();
			$('#full_book_row_nobooks').show();
			$('#half_book_row_nobooks').hide();
		});

		$("#halfBooksButton").click(function() {
			$('#full_book_title_row').hide();
			$('#full_book_row').hide();
			$('#half_book_title_row').show();
			$('#half_book_row').show();
			$('#half_book_row_nobooks').show();
			$('#full_book_row_nobooks').hide();
		});

		$("#changePswdButton").click(function() {
			alert("Cannot change password from here, not implemented yet!");
		});
	});
</script>
</head>
<body style="overflow: auto;" bgcolor="#fff">
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
				<table width="100%" style="border-spacing: 0px;">
					<tr>
						<td id="second">
							<div id="fullBooksButton">Full Books</div>
						</td>
						<td id="second">
							<div id="halfBooksButton">Half Books</div>
						</td>
						<td id="second">
							<div id="changePswdButton">Change Password</div>
						</td>
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
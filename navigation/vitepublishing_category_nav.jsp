<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
						<td id="second">
							<div id="changeCatButton">Change Category</div>
						</td>
						<td id="second">
							<div id="viewBooksButton">View A - Z</div>
						</td>
						<td id="second">
							<div id="selectBookButton">Select Book</div>
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
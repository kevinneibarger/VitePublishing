<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Top Navigation Bar</title>
<link href="${pageContext.request.contextPath}/css/vitepub.css" rel="stylesheet"> 
  
</head>
<body style="overflow:auto;" bgcolor="#fff">
   <table width="100%" >
		<tr>
			<td>
			  <table width="100%" >
			    <tr> <td> <div id="topcontainer">
					<div id="beforelogo">&nbsp;</div></td> 
			     <td><div>
					<img
						src="${pageContext.request.contextPath}/images/Header_logo.png">
				</div></td>
				<td style="width:300px;" align="right"> <div id="searchlabel">Looking for a Online Book?</div> </td>
				<td align="left">
				 <table >
				   <tr><td><div id="searchbox">

					<input type="text" id="search" name="search" class="search"
						placeholder="Search For Authors or Books" /> <input type="button"
						class="button" value="Search" />
					

				</div></td>
				<td align="left"> <div id="status" style="margin-top:40px;font-family: Calibri;font-size: 20px;font-weight:bold;"> 
				<input type="hidden" id="clicked" value="no"/></div>
				 </td>
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
						
						<td id="first">
							<div >&nbsp;</div>
						</td>
						<td id="second"><div>Read Books Online</div></td>
						<td id="second">
							<div>View Authors</div>
						</td>
						<%-- <td id="second"><div> <a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf"> Your Bookshelf</a></div></td> --%>
						<td id="second"><div>Publish A Book</div></td>
						<td id="login_signup_but"><div>
						<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/login">Login/Sign Up</div></td>
						<td id="last">
							<div>&nbsp;</div>
						</td>
						
					</tr>
				</table>
			</td>
		</tr>
      <tr> <td>
<%-- <div id="login_box_nav" title="Login/Sign Up" >
 <div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-primary">
					<!-- <div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div> -->
					<div class="panel-body">
						<fieldset>

							<div>
									<!-- <fb:login-button size="large"
										onlogin="checkLoginState();">
  											Login Or SignUp with Facebook
									</fb:login-button>
									 -->
									<input type="image" id="login_signup"
										src="${pageContext.request.contextPath}/images/main_login_btn.png">
								<br> <br><span> OR </span> <br><br>
							</div>
							<div>
								 <a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf">Proceed
									to read Free Books! </a> 

							</div>

						</fieldset>
					</div>
				</div>
			</div>
		</div>
	</div>
</div> --%> 
      </td></tr>
</table>
</body>
</html>
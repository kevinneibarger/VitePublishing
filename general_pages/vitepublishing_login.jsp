<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vite Publishing</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/css/metisMenu.min.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/css/sb-admin-2.css"
	rel="stylesheet">

<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:include page="../navigation/loginNav.jsp" />
	<div class="container">
	<table width="100%" border=0> 
					<tr>
					<td>
		<div class="row">
			<div style="margin-left: 25%; margin-right:5%;margin-top:-10%">
				<div class="login-panel panel panel-primary">
				
					<div class="panel-heading">
						<h3 class="panel-title">Sign Up with Vite</h3>
					</div> 
					 <div class="panel-body">

						<form
							action="${pageContext.request.contextPath}/vitepub/publishercontroller/homenewuser"
							id="login">
							<fieldset>
								<div class="form-group">
									<input class="form-control" id="fname" name="fname"
										placeholder="FirstName" type="companyname" value="" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" id="lname" name="lname"
										placeholder="LastName" type="companyname" value="">
								</div>
								<div class="form-group">
									<input class="form-control" id="email" name="email"
										placeholder="Email" type="email" value="">
								</div>
								<div class="form-group">
									<input class="form-control" id="lname" name="uname"
										placeholder="Username" type="username" value="">
								</div>
								<div class="form-group">
									<input class="form-control" id="lname" name="passcd"
										placeholder="Password" type="password" value="">
								</div>
								<div class="form-group">
									<input class="form-control" id="lname" name="conpasscd"
										placeholder="Confirm Password" type="password" value="">
								</div>
								


								<input type="submit" id="login_button"
									class="btn btn-lg btn-primary btn-block" value="Sign Up">

							</fieldset>
						</form>
					</div>
					 
					
					
					
				</div>
			</div>
		</div>
		</td>
		<td>
			
					      <div style="margin-left: 2%; margin-right:35%;margin-top:-10%">
									<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/homeloggedin"><input type="button" id="login_button"
									style="background-color: #337ab7; border-color: #2e6da4; width:300px; color:white;height:43px" value="Login"></a>
								<br> <br>
							</div>
							<div style="margin-left: 2%; margin-right:35%;">
									<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/home/homeloggedin"><input type="image" id="facebook_login"
									src="${pageContext.request.contextPath}/images/facebook_login_button.png"></a>
								<br> <br>
							</div>
							<div style="font-family: Calibri; font-size:16pt;">
								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/home">
								 Proceed
									to read Free Books! </a> 

							</div>
							<%-- <div>
								<input type="image" id="facebook_login"
									src="${pageContext.request.contextPath}/images/facebook_login_button.png">
								<br>
								<br> <span> OR </span> <br>
								<br>
							</div> --%>

			
					</td>
					</tr>			
					</table>
	</div>
</body>
</html>
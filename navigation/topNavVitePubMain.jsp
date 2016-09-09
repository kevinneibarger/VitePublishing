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
        		 
        		 $("#homebutton").css('cursor','pointer');
        		 $("#homebutton").click(function () {
        			window.location =  "${pageContext.request.contextPath}/vitepub/publishercontroller/home";
        		 });
        		 
        		 $('#login_box_nav').hide(); 
        		 
        		 $("#login_navbar").click(function () {
        		 if ($('#status').val() === ''){
        		     //alert(" The name ? " + $('#status').val());
        		  $('#login_box_nav').dialog({
        			  bgiframe: true,
        		        modal: true,
        		        width: 400,
        		        autoOpen: false,
  			       
  			      });
  			      $.ajaxSetup({ cache: true });
        		    $.getScript('//connect.facebook.net/en_US/all.js', function(){
        		      FB.init({
        		        appId: '112924825811140',
        		                cookie: true,
        		                oauth: true,
        		                xfbml : true, // parse social plugins on this page
        						version : 'v2.7' // use graph api version 2.5
        		      });     
        		      (function(d, s, id) {
        					var js, fjs = d.getElementsByTagName(s)[0];
        					if (d.getElementById(id))
        						return;
        					js = d.createElement(s);
        					js.id = id;
        					js.src = "//connect.facebook.net/en_US/sdk.js";
        					fjs.parentNode.insertBefore(js, fjs);
        				}(document, 'script', 'facebook-jssdk'));
        		      
        		 //checkLoginState();
        		  $("#login_box_nav").dialog("open");
        		 
        		 }); 
        		 } else {
    				 //alert('Already Logged in!');
    			 }
                });
        	});
        </script>
<script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);

    if (response.status === 'connected') {
    	//alert ('Connected to facebook ');
    	var myElem1 = document.getElementById('login_navbar');
    	//alert(" The login status : " +myElem1);
    	
    	
    	//alert("Value of Logged in:  " + $("#logged_in").val());
      FB.api('/me?fields=email,name,id', function(response){                                                           
    	  var name = response.name; 
          var email = response.email;
          var fbId = response.id;
          
          
          var myElem = document.getElementById('login_signup');
          if (myElem != null) 
        	  document.getElementById("login_signup").src = '${pageContext.request.contextPath}/images/Manage_books_logged_in.png';
          
          //Take the vales and send to
          $.ajax({

                type: "GET",
                url: '${pageContext.request.contextPath}/vitepub/publishercontroller/addUserToDb/',        
                async: false,
                data: {'name':name,'email': email, 'fbId' : fbId},
                success: function(data)
                {
                	 
                },
                complete: function() {
            	//window.location = "${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf"; 
            	},
                error: function(xhr, textStatus, errorThrown) 
                {
                  console.log('ajax loading error...');
                  return false;
                }
         });
    	  
    	  document.getElementById('status').innerHTML = 'Hello, '
				+ response.name;
    	  $("#status").val(response.name);
    	  $("#logged_in").val('yes');
      });
      $('#login_box_nav').dialog("close");
      // Set the login nav button to be un-clickable
      
   
    }  else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
    	
    	// make an AJAX call to set this session variable 
    	/* $.ajax({

                          type: "GET",
                          url: '${pageContext.request.contextPath}/vitepub/publishercontroller/setSessionVar/',        
                          async: false,
                          data: {},
                          success: function(data)
                          { location.reload(); },
                          complete: function() {},
                          error: function(xhr, textStatus, errorThrown) 
                          {
                            console.log('ajax loading error...');
                            return false;
                          }
                   }); */
    	
    	var myElem1 = document.getElementById('login_navbar');
    	//alert(" The login status : " +myElem1);
    	
    	if (document.getElementById("clicked").value === "yes") {
        	//alert ('Clicked the button!');
    	FB.login(function(response){
	    	 alert("Here! before logging in?")
            if(response.authResponse)
            {
                FB.api('/me?fields=email,name,id', function(responseFromFB){                                                           

                    var name = responseFromFB.name; 
                    var email = responseFromFB.email;
                    var fbId = responseFromFB.id;
                    
                    
                    var myElem = document.getElementById('login_signup');
                    if (myElem != null) 
                  	  document.getElementById("login_signup").src = '${pageContext.request.contextPath}/images/Manage_books_logged_in.png';
                    
                    //Take the vales and send to
                    $.ajax({

                          type: "GET",
                          url: '${pageContext.request.contextPath}/vitepub/publishercontroller/addUserToDb/',        
                          async: false,
                          data: {'name':name,'email': email, 'fbId' : fbId},
                          success: function(data)
                          {  },
                          complete: function() {},
                          error: function(xhr, textStatus, errorThrown) 
                          {
                            console.log('ajax loading error...');
                            return false;
                          }
                   });

                });
            }
            else
            {
                console.log('The login failed because they were already logged in');
            }
        }, {scope:'email'});  
	 
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      //document.getElementById('img').src = '${pageContext.request.contextPath}/images/main_login_btn.png';
     }
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
    //alert('This is the login state!');
    window.location = "${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=10000003"; 
   // $("#login_box").dialog("close");
  }
  </script>  
</head>
<body style="overflow:auto;" bgcolor="#fff">

<%-- <c:set var="readerId" value="${sessionScope.readerId}"/>
<c:set var="loggedin" value="${sessionScope.loggedin}"/> --%>

<c:choose>
	<c:when test="${loggedin == 'true' }">
		<c:set var="isloggedin" value="true"/>
	</c:when>
	<c:otherwise>
		<c:set var="isloggedin" value="false"/>
	</c:otherwise>
</c:choose>

<table width="100%" >
	<tr>
		<td>
			<table width="100%" >
				<tr>
					<td>
						<div id="topcontainer">
							<div id="beforelogo">&nbsp; <input type="hidden" id="logged_in" value=""></div>
						</td> 
						<td>
							<div id="homebutton">
								<img src="${pageContext.request.contextPath}/images/Header_logo.png">
								
								</div>
								
							</td>
							<td style="width:300px;" align="right"> 
								<div id="searchlabel">Looking for a Online Book?</div>
							</td>
							<td align="left">
								<table >
									<tr>
										<td>
											<div id="searchbox">
												<input type="text" id="search" name="search" class="search" placeholder="Search For Authors or Books" />
												<input type="button" class="button" value="Search" />
											</div>
										</td>
										<td align="left">
											<div id="status" style="margin-top:40px;font-family: Calibri;font-size: 20px;font-weight:bold;"> 
												<input type="hidden" id="clicked" value="no"/>
											</div>
										</td>
									</table>
								</td> 
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<table width="100%" style="border-spacing:0px;" >
							<tr>
								<td id="first">
									<div >&nbsp;</div>
								</td>
								<td id="second">
									<div>
										<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_categories/all">Read Books Online</a>
									</div>
								</td>
								<td id="second">
									<div>
										<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/list_authors/all"> View Authors </a>
									</div>
								</td>
								<%--<c:if test="${isloggedin}"> --%>
								<td id="second">
									<div>
										<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=${readerId}"> Your Bookshelf</a>
									</div>
								</td>
								<%--</c:if> --%>
								<td id="second">
									<div>Publish A Book</div>
								</td>
							<%--	<c:choose>
								 <c:when test="${!isloggedin}"> --%>
								<td id="endbtn">
									<div id="login_navbar">Login/Sign Up</div>
								</td>
								<%-- </c:when>
								<%-- <c:otherwise> 
									<td id="endbtn">
										<div>Logout</div>
									</td>
								</c:otherwise>
								</c:choose> --%>
								<td id="last">
									<div>&nbsp;</div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td>
						<div id="login_box_nav" title="Login/Sign Up" >
							<div class="container">
								<div class="row">
									<div class="col-md-4 col-md-offset-4">
										<div class="login-panel panel panel-primary">
											<div class="panel-body">
												<fieldset>
													<div> <br>
														&nbsp;&nbsp;&nbsp;
														<fb:login-button size="large" onlogin="checkLoginState();">
															Login Or SignUp with Facebook
														</fb:login-button>
													</div>
												</fieldset>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div> 
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
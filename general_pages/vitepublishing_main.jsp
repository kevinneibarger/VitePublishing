<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="org.vite.publishing.facebook_api.FacebookConnector"%>
<%@ page import="org.vite.publishing.facebook_api.FBGraph" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vite Publishing</title>

<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link href="${pageContext.request.contextPath}/css/vitepub.css" rel="stylesheet"> 
<script src="${pageContext.request.contextPath}/js/jquery.popupoverlay.js"></script>
          <script type="text/javascript">
          $(document).ready(function () {
    		  $('#login_box_nav').hide(); 
    		 // $('#close_it').hide();
     		 
     		 $("#login_signup").click(function () {
     		var logged_in = document.getElementById("login_signup").src;
     		  var currentUrl = window.location.protocol + '//' + window.location.host;
     		  //alert(currentUrl);
         	  if (logged_in != currentUrl + '/VitePublishing/images/Manage_books_logged_in.png') {
     		  $('#login_box_nav').dialog({
     			  bgiframe: true,
     		        modal: true,
     		        width: 400,
     		        autoOpen: false,
			       
			      });
     		 $("#login_box_nav").dialog("open");
         	  } else {
         		 $.ajax({

                     type: "GET",
                     url: '${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf/',        
                     async: false,
                    // data: {'name':name,'email': email, 'fbId' : fbId},
                     success: function(data)
                     { 
                    	
                    	 window.location = "${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf";  
                     },
                     complete: function() {},
                     error: function(xhr, textStatus, errorThrown) 
                     {
                       console.log('ajax loading error...');
                       return false;
                     }
                    
              });
         	  }
    		
    		  }); 
    	 });
    </script>
    <script>
  // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
     // alert("Logged into facebook!");
      //document.getElementById("img").src = '${pageContext.request.contextPath}/images/main_Blue_buttons.png';
      
      testAPI();
    }  else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      //document.getElementById('img').src = '${pageContext.request.contextPath}/images/main_login_btn.png';
    } 
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
   function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
    
    $("#login_box_nav").dialog("close");
    window.location = "${pageContext.request.contextPath}/vitepub/publishercontroller/bookshelf?readerId=10000003";
  } 

   window.fbAsyncInit = function() {
  FB.init({
    appId      : '112924825811140',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.7' // use graph api version 2.5
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };
 
  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Hello, ' + response.name + '!';
    });
  } 
</script> 
</head>
<body id="main_page" style="overflow:auto;" bgcolor="#fffffffff">
 

<jsp:include page="../navigation/topNavVitePubMain.jsp"/>
<c:set var="newestBk" value="${newestBooks}"/>

<div id="divmainpagewrapper">
		<table width="100%" bgcolor="#ffffff">
			<tr>
				<td> 
				<table width="100%"  >
				     
						<tr>
							<td>
								<!-- <div id="container"> --> <!-- <div id="div1"> --> <img
								src="${pageContext.request.contextPath}/images/main_book_img.png"><%-- <%=session.getAttribute("logged_in")%> --%>
							</td>
							<td>
								<div style="margin-top: 55px; margin-left: 35px">
									<img
										src="${pageContext.request.contextPath}/images/main_large_logo.png">
								</div>
								<div style="margin-top: 5px"> <span style="font-family:Calibri; font-size:18px">
						Online books service that helps readers discover new <br>
						authors in the community as well as publish books for <br>
						Authors. members receive a personalized daily email<br>
						alerting them about new authors from across the <br> world.
						No Downloads. Just read books online! First <br> half is
						free!</span>
					</div>
							</td>
						</tr>
						<tr>
							<td>
								<div style="margin-left: 65px;">
									<span> <input type="button" id="books"
										class="button_detail"
										style="border: none; background-color: white"
										value="1,000 Books">
									</span> &nbsp;&nbsp; &nbsp; &nbsp; <span><input type="button"
										id="author" class="button_detail"
										style="border: none; background-color: white"
										value="80 Authors"> </span> &nbsp;&nbsp; &nbsp; &nbsp; <input
										type="button" id="readers" class="button_detail"
										style="border: none; background-color: white"
										value="5,000 Readers">
								</div>
							</td>
							<td style="width: 800px; ">&nbsp;
					 </td></tr>
					</table>
				</td>
			</tr>
			 <tr>
				<td colspan="3">
					
					<hr width="100%" />
				</td>
			</tr> 
			 <tr>
				<td >
					<table width="100%" >
						<tr>
							<td style="height: 207px;width:304px">
								<div id="bluebox" style="margin-left: 65px;">
									<span class="bluebox"> <label> <br> &nbsp;
											&nbsp; Read First Half For Free!
									</label></span> <br>
									<span class="bluebox"><p>
											&nbsp; &nbsp; > Determine if you like the book before you <br>
											&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;purchase the book <br>
											&nbsp; &nbsp;> Search across authors and book categories <br>
											&nbsp; &nbsp;> Don't get charged for books if you don't like
											<br> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; the first half! <br>
										</p> </span> &nbsp;&nbsp; &nbsp;
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
										type="image" id="start_searching"
										src="${pageContext.request.contextPath}/images/main_start_search_btn.png">


								</div>
							</td>
							<td style="height: 207px;width:304px">
								<div id="bluebox">
									<span class="bluebox" style="margin-left: 5px;"> <label> <br> &nbsp;
											&nbsp; Manage your Bookshelf
									</label></span> <br>
									<span class="bluebox"><p>
											&nbsp; &nbsp; > Select books by Category <br> &nbsp;
											&nbsp;> See book progress per book<br> &nbsp; &nbsp;>
											Shelf new books! <br>
										</p> </span> <br>
									<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									 
										<%-- <input type="image" id="login_signup"
										src="${pageContext.request.contextPath}/images/main_login_btn.png"> --%>
										<input type="image" id="login_signup"
										src="${pageContext.request.contextPath}/images/main_login_btn.png">
										<%-- 
										<img id ="login_signup" src="${pageContext.request.contextPath}/images/main_login_btn.png"> --%>
										
								</div>
							</td>
							<td style="height: 207px; width: 304px">
								<div id="bluebox">
									<span class="bluebox"> <label> <br> &nbsp;
											&nbsp; Publish your Book!
									</label></span> <br> <span class="bluebox"><p>
											&nbsp; &nbsp; > Publish a book for free! <br> &nbsp;
											&nbsp;> Make money when readers purchase the <br> &nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;seconf half of the book <br>
											&nbsp; &nbsp;> Track which books are successful!<br>
										</p> </span>

									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<div>
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="image" id="start_searching"
											src="${pageContext.request.contextPath}/images/main_start_publish_btn.png">
									</div>
							</td>
						</tr>
					</table>
				</td>
				</tr> 
				<tr>
				<td>
					<table width="100%" style="border-spacing:0px;" >
						<tr>
							<td style="width:404px;">
								<div style="margin-left:75px;"><br>
										<span class="newbookstext"> 
										 <img src="${pageContext.request.contextPath}/images/books_small.PNG">
											 <div style="margin-top:-35px;margin-left:55px;">Newest Books</div> </span>  <span
											class="newbookstextdesc"> Below are the newest
											published books by authors<br> in the community
										</span>
									</div>
									
									
							</td>
							 <td style="width:404px">
								<div style="margin-left:75px;margin-bottom:40px">
										<span class="newbookstext"> 
										 <img src="${pageContext.request.contextPath}/images/streamline_small.PNG">
											 <div style="margin-top:-35px;margin-left:55px;">Spotlight Authors </div> </span>  <span
											class="newbookstextdesc"> Below are a few of the authors
											published on our site! 
										</span>
									</div>
								
							</td>
							<td style="width:404px">
							<div style="margin-left:75px;margin-bottom:20px">
										<span class="newbookstext"> Read the first half free! </span> <br> <span
												class="newbookstextdesc"> First half of the book is on us!
									</span>
									</div> 
								
							</td> 
						</tr>
						<tr>
							<td style="width:304px; border-right: thin solid #2B3D8F;">
								<div style="margin-left:75px">
									<table> <c:forEach var="newestBookLst" items="${newestBk}" ><tr> <td> 
									<span class="newestbooksrecords"> <img
												src="${pageContext.request.contextPath}/images/emblem-library-small.PNG">
												<div id="newestbookstextrecs">
														<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${newestBookLst.bookId}&typebook=halfbook">
															<c:out value="${newestBookLst.bookTitle}"/>
														</a>
														<br>
														<hr width="250px">
												</div>
											</span>
									</td>
									</tr>
									</c:forEach>
									
									</table>
								</td>
								<td style="width:304px; border-right: thin solid #2B3D8F;">
								<div style="margin-left:75px">
									<table> <c:forEach var="spotLightAuthor" items="${spotLightAuthors}" ><tr> <td> 
									<span class="newestbooksrecords">  <img
											src="${pageContext.request.contextPath}/images/user_man_small.PNG">
												<div id="featuredauthors">
													&nbsp;&nbsp;
														<c:out value="${spotLightAuthor.author.firstName}"/>,
														<c:out value="${spotLightAuthor.author.lastName}"/>&nbsp;
														[<c:out value="${spotLightAuthor.bookCount}"/> BOOK(S)]
														<br>
														<hr width="250px">
												</div>
											</span>
									</td>
									</tr>
									</c:forEach>
									
									</table>
									</div>
								</td>
								<td style="width:304px; border-right: thin solid #2B3D8F;">
								<div style="margin-left:75px">
									<table> <c:forEach var="readFirstBook" items="${readFirstBooks}" ><tr> <td> 
										<span class="newestbooksrecords"> <img
												src="${pageContext.request.contextPath}/images/emblem-library-small.PNG">
												<div id="newestbookstextrecs">
													<a href="${pageContext.request.contextPath}/vitepub/publishercontroller/bookdetailpage?bookId=${readFirstBook.book.bookId}&typebook=halfbook">
													<i><c:out value="${readFirstBook.category}"/></i>:
														<b><c:out value="${readFirstBook.book.bookTitle}"/></b> 
														<hr width="250px">
													</a> 
												</div>
												
										</span>
									</td>
									</tr>
									</c:forEach>
									
									</table>
									
									
									</div>
								
								</td>
							</tr>
									
					</table>
				</td>
			</tr>
		</table>
</div>
   <%-- <div id="login_box" title="Login/Sign Up" >
      
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
									<fb:login-button size="large"
										onlogin="checkLoginState();">
  											Login Or SignUp with Facebook
									</fb:login-button>
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
</div>  --%>
<jsp:include page="../navigation/bottom.jsp"/>

</body>
</html>
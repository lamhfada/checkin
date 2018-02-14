<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Check in</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <style>
  	h2{ 
	 font-family: "微軟正黑體", "Helvetica Neue", Helvetica, Arial, "微软雅黑", "メイリオ", "맑은 고딕", sans-serif;
	} 
  </style>
</head>

<body>
<div style="width:250px;" class="container">
${ errorss }
<c:if test= "${not empty errorMsgs }">
  <script>
  $( function() {
    $( "#Alert" ).dialog();
  } );
  </script>
  <div id="Alert" title="通知">
    <p>${errorMsgs}</p>
  </div>
</c:if>
<h1 style="text-align:center;">Check In</h1>

<form action="setDate" method="post">
	<div class="form-group">
		<label for="name">查詢姓名:</label>
		<input type="text" class="form-control" id="name" name="name" placeholder="請輸入姓名" value="${ param.name }"/>
	</div>		
	
	<button type="submit" class="btn btn-default" name="checkin" value="簽到"/>簽到</button>
	<button type="submit" class="btn btn-default" name="checkdate" value="確認日期"/>確認日期</button>
</form>
<c:choose> 
   <c:when test= "${ not empty Allday }">   
    	<center>
    		<h2>已簽到日期</h2>
    	
	    <%--  LinkedList<String> ODs = (LinkedList<String>)request.getAttribute("Allday"); --%>
	  	<c:forEach var="oneday" items="${Allday}">
			<tr>
				<td>
					<li style="font-size: 1em; color: red;">
						<%--<%= error %> --%>${ oneday }
					</li>
				</td>
			</tr>
		</c:forEach> 
   </c:when>    
   <c:when test= "${ CKD }">  
   		
   		<h2 class="font">從古自今都未簽到</h2>
   		</center>
   </c:when> 
</c:choose>   
<c:if test= "${not empty Already }">
  <center>
  <h3 style="font-family: '微軟正黑體', 'Helvetica Neue', 'Helvetica';">今天${ Already } </h2>
  </center>
</c:if>
</div>
</body>
</html>

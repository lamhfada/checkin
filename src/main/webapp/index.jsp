<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=big5" />
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<%-- <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/style/usl213.css"/><%-- /CRM/style/usl213.css--%> 
<title>首頁</title>
</head>
<body>
<!--start headeer-->


<%-- 
<jsp:include page="/WEB-INF/view/common/header.jsp">
	<jsp:param value="首頁" name="title"/>
</jsp:include>
--%>


<!--end header-->
<center>
<form action="consider" method="post">
	<table class="news" >
	<tr>
		<td>目前傷害</td><td><input type="text" name="curruntDMG" /></td>
	</tr>
	<tr>
		<td>目標傷害</td><td><input type="text" name="targetDMG" /></td>
	</tr>
	<tr>
		<td>活動結束日期</td><td><input type="date" name="endDay" min="2018-01-01"></td>
	</tr>
	</table>
</form>
<a href="<%= request.getContextPath() %>/theRollcall/checkIn.jsp">CHECK IN!!!</a> 
</center>


<!--start header-->
<%-- 
<%@include file="/WEB-INF/view/common/footer.jsp" %>
--%>
<!--end footer-->

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
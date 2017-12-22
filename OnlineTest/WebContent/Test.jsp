<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="in.vamsoft.pojo.ModelQuestion"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<style>

.result{
text-align:center;
margin-top:50px;
height:400px;
width:500px;
border:1px solid #ccffcc;
background-color:#eee;
}
.content{
margin-top:150px;
}
</style>

<body>
 <div class="col-sm-4"></div>
	<div class="result col-sm-4">
		<div class="col-sm-4"></div>
		<div class="content col-sm-4">
			<label>Your Score is:<%=session.getAttribute("marks") %></label><br>
			<%
        if((int)session.getAttribute("marks")>2){
          session.invalidate();
        %>
			<label style="color: green">Your eligible</label>
			<% 
        }else{
        
        %>
			<label style="color: red">Your not eligible</label>
			<%
        }
        %>
		</div>
	</div>
  
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login succes </title>
</head>
<body>
<%

String uname=null;
String sessionID=null;
Cookie[] c=request.getCookies();

if(c!=null){
	 for(Cookie ck:c){
		 if(ck.getName().equals("userc")) uname=ck.getValue();
			 
		 
	 }
}
%>
<h3><%=uname %> do the checkout</h3>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout"/>
</form>

</body>
</html>
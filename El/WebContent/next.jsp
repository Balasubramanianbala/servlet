<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP Scripting to access the data</h1><br>
user id:<%=request.getParameter("userid") %>
password:<%=request.getParameter("pwd") %>
<h1>EL way to access the data</h1><br>
user id is:${param.userid}
password is:${param.pwd}
</body>
</html>
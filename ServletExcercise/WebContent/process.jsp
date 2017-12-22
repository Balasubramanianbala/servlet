<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="obj" class="in.vamsoft.pojo.User"/>  
     <%@page import="in.vamsoft.pojo.DBConnectionUtil"%>  
  <%@page import="in.vamsoft.Dao.RegisterDao"%>  
<jsp:setProperty property="*" name="obj"/>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%  
int status=RegisterDao.register(obj);  
if(status<0)  
out.print("You are successfully registered");  
  
%>  
</body>
</html>
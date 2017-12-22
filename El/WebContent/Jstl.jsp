<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var ="name" value="Balu"></c:set>
<c:out value="${name }"></c:out>
<br>

<c:forEach var="i" begin="1" end="10" step="1">
i is:<c:out value="${i}"/>
</br>
 </c:forEach>
 <c:set var="age" value="60"/>
 <c:if test="${age>18 }" var="major">
 <c:out value="You are a major"></c:out>
 </c:if>
 
 <c:choose>
 <c:when test="${age>18 and age<60 }">
 Major
 </c:when>
 <c:otherwise>Senior citizen</c:otherwise>
 </c:choose>
<c:import url="test.html"></c:import>
<c:catch var="exception">
<%
	int x=5/0;
	%>
</c:catch>
<c:if test="${exception ne null }">
<p>
Exception is: ${exception } <br/> Exception Message: ${exception.message }</p>
</c:if>
</body>
</html>

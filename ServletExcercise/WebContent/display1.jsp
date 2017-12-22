<%@page import="in.vamsoft.pojo.DemoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		List<DemoBean> list=(List<DemoBean>) session.getAttribute("list");
		List<DemoBean> list1=(List<DemoBean>) session.getAttribute("list");
		for (DemoBean l : list) {
		%><table>
		<tr>
			<td><%=l.getName()%></td>
			<td><%=l.getAge()%></td>
		</tr>
		</table>
		<%
	  		}
	  	for (DemoBean l : list1) {
		%><table>
			<tr>
			<td><%=l.getName()%></td>
			<td><%=l.getAge()%></td>
			</tr>
		</table>
	<%
	  }
	%>
</body>
</html>
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
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
		<form action="Resultservlet" method="post">
		<h2>Welcome</h2>
		<%=session.getAttribute("name") %><br><br>
		
	
		 <h2>test started</h2>
 
		
				<a style="float: right" href="LogoutServlet"><span
						class="glyphicon glyphicon-log-in"></span> Logout</a></li>
			</ul>
		</div>



		
				<div class="text-left">
					<h4>
						Welcome:
						<%=session.getAttribute("name")%></h4>
						<h3 style="text-align:left">Test</h3>
				</div>
				

					
					
						<%
						  List<ModelQuestion> questions = (List<ModelQuestion>) session.getAttribute("ModelQuestion");
						%>

						<%
						  for (ModelQuestion element : questions) {
						%>
						<div>
					   <div><%=element.getQno()%><%=element.getQut()%></div>
                        <div>
							<input type="radio" name="<%=element.getQno()%>"
								value="<%=element.getOpta()%>"><%=element.getOpta()%><br>

							<input type="radio" name="<%=element.getQno()%>"
								value="<%=element.getOptb()%>"><%=element.getOptb()%><br>
							<input type="radio" name="<%=element.getQno()%>"
								value="<%=element.getOptc()%>"><%=element.getOptc()%><br>
							<input type="radio" name="<%=element.getQno()%>"
								value="<%=element.getOptd()%>"><%=element.getOptd()%><br>
						</div>

						<%
                          }
                        %>
					
</div>
					<div class="container-fluid text-center" style="float: right">
						<input type="submit" name="submit" value="submit">
					</div>



				</div>





	</form>
  
		
</body>
</html>
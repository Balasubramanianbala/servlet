<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<pre>
		<form action="InsertServlet" method="post">	  
   Name: <input type="text" name="fname" />
  
  <br><br>
  Emailid:  <input type="text" name="email" />
    
  <br><br>
  Password: <input type="password" name="passwd" />
    
  <br><br>
  <input type="submit" name="add" value="Submit">
</form>
</pre> 
</body>
</html>
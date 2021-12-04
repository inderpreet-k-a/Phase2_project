<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || password == null || username.equals("") || password.equals("")) {
			throw new ServletException("Credentials missing....!!");
		} else {
			if (username.equals("tom") && password.equals("jerry")) {
								
				session.setAttribute("username", username);
				session.setMaxInactiveInterval(60);
				
				response.sendRedirect("dashboard.html");
				
			} else {
				throw new ServletException("Invalid Credentials....!!");
			}
		}
	%>


</body>
</html>
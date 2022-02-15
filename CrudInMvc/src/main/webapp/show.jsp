<%@page import="java.io.PrintWriter"%>
<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.UserServiceImpl"%>
<%@page import="com.dao.UserService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome page</title>
		<!-- Font Icon -->
		<link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
		<!-- Welcome css -->
		<link rel="stylesheet" href="css/welcome.css">
	</head>

	<body>
		<%
			User user = (User) session.getAttribute("currentUser");
		%>
		<div class="bgimg">
			<div class="topleft">
				<p>QDev</p>
			</div>
			<div class="middle">
				<h1>
					Welcome
					<%= user.getFirstName() %></h1>
				<hr>
				<p><%= user.getFirstName() + " " + user.getLastName() %></p>
			</div>
			<div class="bottomleft">
				<p>
					Email to :
					<%= user.getEmail() %></p>
			</div>
		</div>
	</body>

</html>
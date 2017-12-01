<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Single Location Ninjas</title>
</head>
<body>
<a href = "/">Home</a>&nbsp; <a href = "/ninjas">Back</a>
	<h1><c:out value="${ dojoLoc.name }" /> Location Users</h1>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach items = "${ dojo }" var = "ninja">
			<tr>
				<td><c:out value = "${ ninja.firstname }" /></td>
				<td><c:out value = "${ ninja.lastname }" /></td>
				<td><c:out value = "${ ninja.age }" /></td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
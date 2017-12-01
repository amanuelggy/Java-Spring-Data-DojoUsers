<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome page</title>
</head>
<body>
	<a href = "/">Home</a>
	<h1>Hello new user!</h1>
	<form:form method = "POST" action = "/ninjas/new" modelAttribute = "ninja">
	
		<form:label path = "dojo">Dojo Locations: </form:label><form:select path = "dojo">
				<c:forEach items = "${ dojos }" var = "dojo">
					<form:option  value = "${dojo}" label = "${ dojo.name }" />
				</c:forEach>
			  </form:select><br><br>
		<form:label path = "firstname">First Name: </form:label><form:input path = "firstname" /><br><br>
		<form:label path = "lastname">Last Name: </form:label><form:input path = "lastname" /><br><br>
		<form:label path = "age">Age: </form:label><form:input type = "number" path = "age" /><br><br>
		<input type = "submit" value = "Submit">
	</form:form>

</body>
</html>
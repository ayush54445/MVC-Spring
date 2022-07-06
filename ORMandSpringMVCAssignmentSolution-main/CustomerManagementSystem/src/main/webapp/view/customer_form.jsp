<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<center>
	<form action="${pageContext.request.contextPath}/save" method="POST">
	
		<input type="hidden" name="id" value="${Customer.id}"><br>
		<input type="text" name="firstName" value="${Customer.firstName}"
			placeholder="First Name"><br><br>
			 <input type="text"	name="lastName" value="${Customer.lastName}"
			placeholder="Last Name"><br><br>
			<input type="text" name="email" value="${Customer.email}" placeholder="email"><br><br>
		<input type="submit" value="save">

	</form>

</center>
</body>
</html>
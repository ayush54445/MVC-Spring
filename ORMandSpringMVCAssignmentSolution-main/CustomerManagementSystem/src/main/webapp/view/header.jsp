<%

	String session_username = (String)session.getAttribute("username");
	
%>

<div>
	<div style="float: left">
		<% if(session_username != null) { %>
			<button><a href="${pageContext.request.contextPath}/add" style="text-decoration: none">Add</a></button> | 
			<button><a href="${pageContext.request.contextPath}/list" style="text-decoration: none">List</a></button>
		<% } %>
	</div>

	<div style="float: right">
		<% if(session_username == null) { %>
			<button><a href="${pageContext.request.contextPath}/login" style="text-decoration: none">Login</a></button>
		<% } %>
		
		<% if(session_username != null) { %>
			Welcome <%= session.getAttribute("username") %> | 
			<button><a href="${pageContext.request.contextPath}/logout" style="text-decoration: none">Logout</a></button>
		<% } %>

	</div>
</div>


<br />
<br />

<center>
	<header style="background-color: green; color: white; height: 50px;">
		<h1>Customer Relationship Manager</h1>
	</header>
</center>

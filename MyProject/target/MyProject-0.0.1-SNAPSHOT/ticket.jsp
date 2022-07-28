<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %> 
<%@page import="java.util.*, java.io.*" %>
<%
String userName = "username";
try {
Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection conn = DriverManager.getConnection(
				System.getenv("db_url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
			);
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<body>

<h1>Retrieve data from database</h1>

<table border="1">
<tr>
<td>userName</td>
<td>amount</td>
<td>description</td>
<td>create</td>
</tr>
<%
try{
	conn = DriverManager.getConnection(
			System.getenv("db_url"), 
			System.getenv("db_username"), 
			System.getenv("db_password")
		);
String sql ="select * from users";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("username") %></td>
<td><%=resultSet.getString("amount") %></td>
<td><%=resultSet.getString("description") %></td>

<td><a href="update.jsp?id=<%=resultSet.getString("username")%>">create</a></td>
</tr>
<%
}
conn.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>
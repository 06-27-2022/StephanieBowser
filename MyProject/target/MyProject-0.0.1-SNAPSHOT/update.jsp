<%@page import="java.sql.*"%>
<%
String userName = request.getParameter("username");

Connection conn = DriverManager.getConnection(
		System.getenv("db_url"), 
		System.getenv("db_username"), 
		System.getenv("db_password")
	);

try {
Class.forName("org.postgresql.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<%
try{
	conn = DriverManager.getConnection(
			System.getenv("db_url"), 
			System.getenv("db_username"), 
			System.getenv("db_password")
		);
statement=connection.createStatement();
String SQL ="select * from reimburse where username="+userName;
resultSet = statement.executeQuery(SQL);
while(resultSet.next()){
%>
<!DOCTYPE html>
<html>
<body>
<h1>Update data from database</h1>
<form method="post" action="update-process.jsp">
<input type="hidden" name="username" value="<%=resultSet.getString("username") %>">
<input type="text" name="username" value="<%=resultSet.getString("username") %>">
<br>
First name:<br>
<input type="text" name="amount" value="<%=resultSet.getString("amount") %>">
<br>
Last name:<br>
<input type="text" name="description" value="<%=resultSet.getString("description") %>"><br>
<br><br>
<input type="submit" value="submit">
</form>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</body>
</html>
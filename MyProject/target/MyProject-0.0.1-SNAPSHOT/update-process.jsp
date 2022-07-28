<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%
String userName = request.getParameter("username");
String amount=request.getParameter("amount");
String description=request.getParameter("description");

if(userName != null)
{
Connection conn = null;
PreparedStatement ps = null;
//int personID = Integer.parseInt(userName);
try
{
Class.forName("org.postgresql.Driver");
conn = DriverManager.getConnection(
		System.getenv("db_url"), 
		System.getenv("db_username"), 
		System.getenv("db_password")
	);
String SQL="Update reimburse set username=?,amount=?,description=?? where username="+userName;
ps = conn.prepareStatement(SQL);
ps.setString(1, userName);
ps.setString(2, amount);
ps.setString(3, description);

int i = ps.executeUpdate();
if(i > 0)
{
out.print("Record Updated Successfully");
}
else
{
out.print("There is a problem in updating Record.");
} 
}
catch(SQLException sql)
{
request.setAttribute("error", sql);
out.println(sql);
}
}
%>
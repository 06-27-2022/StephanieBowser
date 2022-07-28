package com.revature1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature1.model.Reimburse;
import com.revature1.model.User;


public class ConnectionUtil {


	public static Connection getNewConnection() throws SQLException {
		
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = DriverManager.getConnection(
				System.getenv("db_url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
			);

		
		return conn;
	}

	public static boolean validate(String userName,String password){
		boolean status=false;
		try{		
			User user = null;
		
		Connection conn = null;

			conn = ConnectionUtil.getNewConnection();

			PreparedStatement stmt=conn.prepareStatement("select * from users where username=? and password=?");
			stmt.setString(1,userName);
			stmt.setString(2,password);
			
			ResultSet set=stmt.executeQuery();
			status=set.next();
			
			
		}catch(Exception e){System.out.println(e);}
		return status;
		}
	
	public static boolean validate(String userName, String amount,String description){
		boolean status=false;
		try{		
			Reimburse reimburse = null;
		
		Connection conn = null;

			conn = ConnectionUtil.getNewConnection();

			PreparedStatement stmt=conn.prepareStatement("select * from reimburses where username=? and amount=? and description=?");
			stmt.setString(1,userName);
			stmt.setString(2,amount);
			stmt.setString(3,description);
			
			ResultSet set=stmt.executeQuery();
			status=set.next();
			
			
		}catch(Exception e){System.out.println(e);}
		return status;
		}
}
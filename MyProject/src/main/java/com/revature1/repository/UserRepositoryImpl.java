package com.revature1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature1.model.Reimburse;
import com.revature1.model.User;
import com.revature1.util.ConnectionUtil;

/*
 * It is very common to have specific classes that handle the logic for methods that
 * will interact with your data source (DB). We call this classes repositories. They
 * follow a design pattern called the Data Access Object (DAO) design pattern.
 */
public class UserRepositoryImpl implements UserRepository{

	/**
	 * I want a method that I can use to get all of the users' information
	 * from the DB. I don't just want this method to print this users; I want it
	 * to return a List of users to the caller.
	 */
	public List<User> findAllUsers() {
		
		/*
		 * I've moved my Connection declaration up so that it will be in scope
		 * for both the "try" and "finally" blocks.
		 */
		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		//Declaring the list and initalizing the List we will return at the end of this method.
		List<User> users = new ArrayList<>();
		
		//Declare my SQL query string ahead of time:
		final String SQL = "select * from users";
		
		try {
			//The first step is to get a connection.
			conn = ConnectionUtil.getNewConnection();
			
			/*
			 * After we have established a connection, we can execute SQL statements
			 * against our DB. We will need the Statement interface. We can use our
			 * connection to create a statement.
			 */
			stmt = conn.createStatement();

			
			/*
			 * The ResultSet will store the results of a running a query (e.g. the
			 * records that are returned after executing that query).
			 */
			set = stmt.executeQuery(SQL);
			
			/*
			 * You have to extra the results from a ResultSet one by one once you have
			 * the records local to your application.
			 */
			
			while(set.next()) {
				/* 
				 * While there is another record in the result set, let's print the
				 * the contents of the table rows here.
				 */
				
				User user = new User(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getString(5),
						set.getBoolean(6));
				
				/*
				 * Let's add User objects to our List<User> (list of users)
				 * on each iteration.
				 */
	
				users.add(user);
				 
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			/*
			 * Remember that a finally always executes. This makes it a good place
			 * to close your connection to your DB. Yes, you can have a try-catch
			 * block inside of a try-catch block.
			 */
			try {
			conn.close();
			stmt.close();
			set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return users;
	}
	

	@Override
	public void save(User user) {
		/*
		 * The standard JDBC workflow includes a Connection. We will also want
		 * a Statement so that we can execute it against our DB. We don't necessarily
		 * need a ResultSet if we're not planning on getting records back.
		 */
		
		Connection conn = null;
		/*
		 * If you're ever going to be inserting user input into a DB, you should use a
		 * special kind of Statement called a PreparedStatement. A PreparedStatement 
		 * protects against SQL injection by precompiling a SQL query with placeholders
		 * and then later substituting in the necessary values. 
		 */
		PreparedStatement stmt = null;
		/*
		 * We will alter our SQL String to a parameterized SQL String (the
		 * question marks being parameters).
		 */
		final String SQL = "insert into users values(default, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);
			

			/*
			 * Before you execute a PreparedStatement, you need to specify what the
			 * values of each parameter( each ?) should be.
			 */
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getUserName());
			stmt.setString(4, user.getPassword());
			stmt.setBoolean(5, user.getManager());
			stmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			conn.close();
			stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	/**
	 * This method should update an existing user record in the "users"
	 * table.
	 * 
	 * @param user an user object containing updated state that will be written to
	 * the DB.
	 */
	@Override
	public void update(User user) {
		//The first step should always be to open a Connection to your DB.
		Connection conn = null;
		//I also know that I need a Statement object if I want to run queries against the DB.
		PreparedStatement stmt = null;
		final String SQL = "update users set lastname = ? where id = ?";
		
		try {
			//Using our utility class and method to grab a new connection to the DB
			conn = ConnectionUtil.getNewConnection();
			//Using the connection to get a Statement object.
			stmt = ((Connection) conn).prepareStatement(SQL);
			//Setting the parameters in our parameterized query
			stmt.setString(1, user.getLastName());
			stmt.setInt(2, user.getId());
			//Executing the query
			stmt.execute();
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
			conn.close();
			stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


	//Update amount and description

	/**
	 * This method should locate just a single user by their unique ID and return
	 * that User object to the caller.
	 * 
	 * @param id The user's unique identifier in the database
	 */
	@Override
	public User findById(int id) {
		
		User user = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from users where id = ?";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);

			stmt.setInt(1, id);
			set = stmt.executeQuery();
			
			//Now extract the data from the record in the ResultSet
			if(set.next()) {
				user = new User(
						set.getInt(1),
						set.getString(2),
						set.getString(3),
						set.getString(4),
						set.getString(5),
						set.getBoolean(6)
						);
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return user;
	}


	@Override
	public List<Reimburse> findAllReimburse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void save(Reimburse reimburse) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Reimburse reimburse) {
		// TODO Auto-generated method stub
		
	}	
}
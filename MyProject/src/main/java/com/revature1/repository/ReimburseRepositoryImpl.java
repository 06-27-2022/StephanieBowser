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
import com.revature1.util.ConnectionUtil;


public class ReimburseRepositoryImpl implements ReimburseRepository{


	public List<Reimburse> findAllReimburse() {
		

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		
		List<Reimburse> reimburses = new ArrayList<>();
		

		final String SQL = "select * from reimburses";
		
		try {

			conn = ConnectionUtil.getNewConnection();

			stmt = conn.createStatement();

			set = stmt.executeQuery(SQL);
			
			while(set.next()) {

				Reimburse reimburse = new Reimburse(
						set.getString(1),
						set.getString(2),
						set.getString(3));

				reimburses.add(reimburse);
				 
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
		
		return reimburses;
	}



	@Override
	public void save(Reimburse reimburse) {

		Connection conn = null;

		PreparedStatement stmt = null;

		final String SQL = "insert into reimburses values(?, ?, ?)";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);

			stmt.setString(1, reimburse.getUserName());
			stmt.setString(2, reimburse.getAmount());
			stmt.setString(3, reimburse.getDescription());
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
	
//Update my tables in reimburses
	public void update(Reimburse reimburse) {

		Connection conn = null;
		
		PreparedStatement stmt = null;
		final String SQL = "update reimburses set username= smbowser amount= amount and description= description";
		
		try {

			conn = ConnectionUtil.getNewConnection();

			stmt = ((Connection) conn).prepareStatement(SQL);

			stmt.setString(1, reimburse.getUserName());
			stmt.setString(2, reimburse.getAmount());
			stmt.setString(3, reimburse.getDescription());
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

	public Reimburse findByuserName(String userName) {
		
		Reimburse reimburse = null;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from reimburses where username = ?";
		
		try {
			conn = ConnectionUtil.getNewConnection();
			stmt = conn.prepareStatement(SQL);

			stmt.setString(1, userName);
			set = stmt.executeQuery();
			

			if(set.next()) {
				reimburse = new Reimburse(
						set.getString(1),
						set.getString(2),
						set.getString(3)
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
		
		
		return reimburse;
	}



	@Override
	public Reimburse findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Reimburse findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
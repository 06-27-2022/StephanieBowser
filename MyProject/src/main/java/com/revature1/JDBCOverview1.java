package com.revature1;

import java.util.List;

import com.revature1.model.Reimburse;
import com.revature1.model.User;
import com.revature1.repository.ReimburseRepository;
import com.revature1.repository.ReimburseRepositoryImpl;
import com.revature1.repository.UserRepository;
import com.revature1.repository.UserRepositoryImpl;

//public class JDBCOverview1 {
//
//
//	public static void main(String[] args) {
//		
//		UserRepository userRepository = new UserRepositoryImpl();
//
//		User newUser = new User(2, "First Name", "Last Name", 
//				"username", "password");
//		userRepository.save(newUser);
//
//		User userToUpdate = new User(1, "Stephanie", "Bowser", 
//				"smbowser", "passwd");
//		
//		userRepository.update(userToUpdate);
//		
//		//Printing all users
//		List<User> users = userRepository.findAllUsers();
//		System.out.println(users);
//		for(User individual : users) {
//			System.out.println(individual);
//		}
//		
//		User retrievedUser = userRepository.findById(100);
//		System.out.println(retrievedUser);
//	}
//	
//}

public class JDBCOverview1 {

	public static void main(String[] args) {
		
		UserRepository userRepository = new UserRepositoryImpl();

		User newUser = new User(2, "Someone", 
				"Manager", "manager", "password1", true);
		userRepository.save(newUser);
		List<User> users = userRepository.findAllUsers();
		System.out.println(users);
		
		ReimburseRepository reimburseRepository = new ReimburseRepositoryImpl();
		
		
		Reimburse newReimburse = new Reimburse("manager", "100", 
				"I need a reimbursement");
		reimburseRepository.save(newReimburse);
		List<Reimburse> reimburses = reimburseRepository.findAllReimburse();
		System.out.println(reimburses);
	}
	
	
	
}